package com.example.petcarebook.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VaccinationRecord { @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id; @NotNull(message = "Pet ID is required") private Long petId; @NotNull(message = "Vaccine type ID is required") private Long vaccineTypeId; @NotBlank(message = "Vaccine name is required") private String vaccineName; @NotNull(message = "Date given is required") private LocalDate dateGiven; private LocalDate nextDueDate; }
