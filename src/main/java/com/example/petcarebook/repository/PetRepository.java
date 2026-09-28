package com.example.petcarebook.repository;
import com.example.petcarebook.entity.Pet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PetRepository extends JpaRepository<Pet, Long> { List<Pet> findByNameContainingIgnoreCase(String keyword); }
