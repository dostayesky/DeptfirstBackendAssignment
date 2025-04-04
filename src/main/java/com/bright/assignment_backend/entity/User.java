package com.bright.assignment_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
//@ToString(exclude = {"password"})
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;


}
