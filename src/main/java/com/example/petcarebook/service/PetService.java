package com.example.petcarebook.service;
import com.example.petcarebook.entity.Pet;
import com.example.petcarebook.repository.OwnerRepository;
import com.example.petcarebook.repository.PetRepository;
import java.util.List;
import org.springframework.stereotype.Service;
@Service public class PetService { private final PetRepository repository; private final OwnerRepository ownerRepository; public PetService(PetRepository repository, OwnerRepository ownerRepository) { this.repository = repository; this.ownerRepository = ownerRepository; } public Pet add(Pet data) { return ownerRepository.existsById(data.getOwnerId()) ? repository.save(data) : null; } public List<Pet> getAll() { return repository.findAll(); } public Pet getById(Long id) { return repository.findById(id).orElse(null); } public Pet update(Long id, Pet data) { Pet pet = getById(id); if (pet == null || !ownerRepository.existsById(data.getOwnerId())) return null; pet.setName(data.getName()); pet.setSpecies(data.getSpecies()); pet.setBreed(data.getBreed()); pet.setDateOfBirth(data.getDateOfBirth()); pet.setOwnerId(data.getOwnerId()); return repository.save(pet); } public boolean delete(Long id) { if (!repository.existsById(id)) return false; repository.deleteById(id); return true; } public List<Pet> search(String keyword) { return repository.findByNameContainingIgnoreCase(keyword); } }
