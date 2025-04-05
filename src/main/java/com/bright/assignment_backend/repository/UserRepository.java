package com.bright.assignment_backend.repository;

import com.bright.assignment_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< User,String> {

}
