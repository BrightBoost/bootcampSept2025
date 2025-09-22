package com.example.relationship.repos;

import com.example.relationship.entities.Post;
import com.example.relationship.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 🟢 Derived Query Methods:

    // Finds User by name
    //just add method declaration
    //implementation provided by JPA
    User findByName(String name);

    // Finds list of Users where Profile has matching email
    List<User> findByProfileEmail(String email);

    // Finds all Users having profile with given phone
    List<User> findByProfilePhone(String phone);

    // Finds Users having at least one Post with title like
    List<User> findByPostsTitleContaining(String keyword);

    // 🟡 HQL-style query for Posts of a user
    @Query("SELECT p FROM Post p WHERE p.user.id = :userId")
    List<Post> findPostsByUserId(@Param("userId") Long userId);

    //here Post is not a table name its class name and p is its alias
    //p.user_id which is variable of Post Class
    //:userId means take the argument passed to the function
}
