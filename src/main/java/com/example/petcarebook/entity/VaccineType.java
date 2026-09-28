package com.example.petcarebook.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VaccineType { @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id; @NotBlank(message = "Name is required") private String name; @NotNull(message = "Interval days is required") @Positive(message = "Interval days must be positive") private Integer intervalDays; private String description; }
