package com.example.petcarebook.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Owner { @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id; @NotBlank(message = "Name is required") private String name; @NotBlank(message = "Email is required") private String email; @NotBlank(message = "Phone is required") private String phone; }
