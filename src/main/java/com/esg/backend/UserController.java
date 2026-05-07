package com.esg.backend;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    // GET all users
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    // POST user
    @PostMapping
    public User addUser(@RequestBody User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    // GET user by id
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.removeIf(u -> u.getId().equals(id));
        return "Deleted";
    }
}