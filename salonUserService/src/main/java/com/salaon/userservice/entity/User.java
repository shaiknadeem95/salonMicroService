package com.salaon.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "userName cannot be empty")
    private String username;

    private String fullName;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "please enter the validate email Id")
    private String email;

    @NotBlank(message = "password cannot be empty")
    private String password;

    @NotBlank(message = "phoneNumber cannot be empty")
    private String phone;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @NotBlank(message = "role cannot be empty")
    private String role;


}
