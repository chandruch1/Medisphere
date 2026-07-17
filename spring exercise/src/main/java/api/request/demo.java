package api.request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "todo")
public class demo {

    public static void main(String[] args) {
        SpringApplication.run(demo.class, args);
    }
}