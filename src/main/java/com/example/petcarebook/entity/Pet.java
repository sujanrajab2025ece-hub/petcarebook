package com.example.petcarebook.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Pet { @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id; @NotBlank(message = "Name is required") private String name; @NotBlank(message = "Species is required") private String species; @NotBlank(message = "Breed is required") private String breed; @NotNull(message = "Date of birth is required") private LocalDate dateOfBirth; @NotNull(message = "Owner ID is required") private Long ownerId; }
