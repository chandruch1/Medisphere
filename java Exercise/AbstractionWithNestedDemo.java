/**
 * OOP Concept: Abstraction and Encapsulation with Nested Classes
 * 
 * Java allows defining a class within another class. This is called a Nested Class.
 * Nested classes are divided into two categories:
 * 1. Static Nested Class: A nested class that is declared static. It cannot access non-static 
 *    members of the outer class directly.
 * 2. Non-static Nested Class (Inner Class): A class that is non-static. It has direct access 
 *    to all fields and methods of the outer class, including private ones.
 * 
 * Nested classes help in logically grouping classes that are only used in one place, 
 * increasing encapsulation and making code more readable/maintainable.
 */

class NestedDatabaseClient {
    private String databaseUrl;
    private boolean isConnected = false;

    public NestedDatabaseClient(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    // 1. Static Nested Class - holds configuration data, doesn't need outer class state directly
    public static class ConnectionConfig {
        private int timeoutMillis;
        private int maxPoolSize;

        public ConnectionConfig(int timeoutMillis, int maxPoolSize) {
            this.timeoutMillis = timeoutMillis;
            this.maxPoolSize = maxPoolSize;
        }

        public void printConfig() {
            System.out.println("Config [Timeout: " + timeoutMillis + "ms, Pool Size: " + maxPoolSize + "]");
        }
    }

    // 2. Inner Class (Non-static) - represents an active query session.
    // It depends directly on the DatabaseClient's state (isConnected, databaseUrl).
    public class QuerySession {
        private int sessionId;

        public QuerySession(int sessionId) {
            this.sessionId = sessionId;
        }

        public void executeQuery(String sql) {
            // Direct access to outer class private fields (isConnected, databaseUrl)
            if (isConnected) {
                System.out.println("Session #" + sessionId + " on [" + databaseUrl + "] executing query: " + sql);
            } else {
                System.out.println("Session #" + sessionId + " ERROR: Cannot execute query. Database is offline.");
            }
        }
    }

    public void connect() {
        this.isConnected = true;
        System.out.println("DatabaseClient: Connected to " + databaseUrl);
    }

    public void disconnect() {
        this.isConnected = false;
        System.out.println("DatabaseClient: Disconnected from " + databaseUrl);
    }
}

public class AbstractionWithNestedDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstraction & Encapsulation with Nested Classes ===");

        // 1. Instantiating the Static Nested Class
        // Does not require an instance of DatabaseClient
        NestedDatabaseClient.ConnectionConfig config = new NestedDatabaseClient.ConnectionConfig(5000, 10);
        System.out.print("Static Nested Class Output: ");
        config.printConfig();

        // 2. Instantiating the Outer Class
        NestedDatabaseClient client = new NestedDatabaseClient("jdbc:mysql://localhost:3306/production_db");

        // 3. Instantiating the Inner Class (Non-static)
        // Requires an existing instance of the Outer Class
        NestedDatabaseClient.QuerySession session1 = client.new QuerySession(4001);

        System.out.println("\n--- Attempting query before connecting ---");
        session1.executeQuery("SELECT * FROM users"); // should fail

        System.out.println("\n--- Connecting and retrying query ---");
        client.connect();
        session1.executeQuery("SELECT * FROM users"); // should succeed

        client.disconnect();
    }
}
