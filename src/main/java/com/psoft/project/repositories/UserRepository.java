package com.psoft.project.repositories;

import com.psoft.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    @Query("select u from User u")
    List<User> findAll();

    @Query("select u from User u where u.id = :id")
    User findById(@Param("id") int id);

    @Query("select u from User u where u.username like %:name%")
    User findByName(@Param("name") String name);

    @Query("select u from User u where u.username = :username")
    User findUserByUsername(@Param("username") String username);

    Optional<User> findByUsername(String username);
}
