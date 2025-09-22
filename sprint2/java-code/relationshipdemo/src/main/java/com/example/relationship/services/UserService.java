package com.example.relationship.services;

import com.example.relationship.entities.Post;
import com.example.relationship.entities.Profile;
import com.example.relationship.entities.User;
import com.example.relationship.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User addOrUpdateProfile(Long userId, Profile profileData) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Profile profile = user.getProfile();

        if (profile == null) {
            // First-time add
            profile = new Profile();
        }

        // Update fields
        profile.setEmail(profileData.getEmail());
        profile.setPhone(profileData.getPhone());
        profile.setUser(user); // maintain reverse reference

        user.setProfile(profile); // maintain direct reference

        return userRepository.save(user); // will update the existing profile
    }


    public User addPostToUser(Long userId, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        post.setUser(user);
        user.getPosts().add(post);

        return userRepository.save(user);  // cascade persists post
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUsersByProfileEmail(String email) {
        return userRepository.findByProfileEmail(email);
    }

    public List<Post> getPostsByUserId(Long userId) {
        return userRepository.findPostsByUserId(userId);
    }

//    public User createUser(User user) {
//        // Set the relationship in reverse (Post → User)
//        if (user.getPosts() != null) {
//            for (Post post : user.getPosts()) {
//                post.setUser(user);
//            }
//        }
//
//        return userRepository.save(user);
//    }

}