package com.example.petcarebook.service;
import com.example.petcarebook.entity.Owner;
import com.example.petcarebook.repository.OwnerRepository;
import java.util.List;
import org.springframework.stereotype.Service;
@Service public class OwnerService { private final OwnerRepository repository; public OwnerService(OwnerRepository repository) { this.repository = repository; } public Owner add(Owner data) { return repository.save(data); } public List<Owner> getAll() { return repository.findAll(); } public Owner getById(Long id) { return repository.findById(id).orElse(null); } public Owner update(Long id, Owner data) { Owner owner = getById(id); if (owner == null) return null; owner.setName(data.getName()); owner.setEmail(data.getEmail()); owner.setPhone(data.getPhone()); return repository.save(owner); } public boolean delete(Long id) { if (!repository.existsById(id)) return false; repository.deleteById(id); return true; } public List<Owner> search(String keyword) { return repository.findByNameContainingIgnoreCase(keyword); } }
