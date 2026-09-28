package com.example.petcarebook.repository;
import com.example.petcarebook.entity.Owner;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OwnerRepository extends JpaRepository<Owner, Long> { List<Owner> findByNameContainingIgnoreCase(String keyword); }
