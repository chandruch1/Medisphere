package api.request.service;

import api.request.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.User;

import java.util.List;

@Service
public class UserSer {

    @Autowired
    private UserRepo t;

    // Create
    public User create(User user) {
        return t.save(user);
    }

    // Get By Id
    public User getelement(Long id) {
        return t.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    // Get All Users
    public List<User> getAll() {
        return t.findAll();
    }

    // Update User
    public User update(Long id, User user) {

        User existing = t.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());

        return t.save(existing);
    }

    // Delete User
    public void delete(Long id) {

        User existing = t.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        t.delete(existing);
    }
}