package com.bright.assignment_backend.repository;

import com.bright.assignment_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User,Long> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}
