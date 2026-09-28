package com.example.petcarebook.repository;
import com.example.petcarebook.entity.VaccinationRecord;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecord, Long> { List<VaccinationRecord> findByVaccineNameContainingIgnoreCase(String keyword); List<VaccinationRecord> findByNextDueDateBetween(LocalDate start, LocalDate end); }
