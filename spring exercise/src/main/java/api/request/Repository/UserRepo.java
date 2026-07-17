package api.request.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}