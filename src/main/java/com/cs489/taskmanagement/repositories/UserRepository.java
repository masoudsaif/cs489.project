package com.cs489.taskmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs489.taskmanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
