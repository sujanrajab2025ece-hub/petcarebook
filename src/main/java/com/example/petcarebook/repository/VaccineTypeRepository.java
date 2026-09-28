package com.example.petcarebook.repository;
import com.example.petcarebook.entity.VaccineType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VaccineTypeRepository extends JpaRepository<VaccineType, Long> { List<VaccineType> findByNameContainingIgnoreCase(String keyword); }
