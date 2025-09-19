package com.example.relationship.controllers;

import com.example.relationship.entities.Post;
import com.example.relationship.entities.Profile;
import com.example.relationship.entities.User;
import com.example.relationship.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // STEP 1: Create User only
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setProfile(null);
        user.setPosts(new ArrayList<>());
        return ResponseEntity.ok(userService.createUser(user));
    }

    // STEP 2: Add or Update Profile
    @PutMapping("/{id}/profile")
    public ResponseEntity<User> addOrUpdateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return ResponseEntity.ok(userService.addOrUpdateProfile(id, profile));
    }

    // STEP 3: Add Post
    @PostMapping("/{id}/posts")
    public ResponseEntity<User> addPost(@PathVariable Long id, @RequestBody Post post) {
        return ResponseEntity.ok(userService.addPostToUser(id, post));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @GetMapping("/profile/email/{email}")
    public ResponseEntity<List<User>> getUsersByProfileEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUsersByProfileEmail(email));
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getPostsByUserId(userId));
    }
}
