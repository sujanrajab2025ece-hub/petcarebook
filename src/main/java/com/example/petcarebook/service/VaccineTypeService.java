package com.example.petcarebook.service;
import com.example.petcarebook.entity.VaccineType;
import com.example.petcarebook.repository.VaccineTypeRepository;
import java.util.List;
import org.springframework.stereotype.Service;
@Service public class VaccineTypeService { private final VaccineTypeRepository repository; public VaccineTypeService(VaccineTypeRepository repository) { this.repository = repository; } public VaccineType add(VaccineType data) { return repository.save(data); } public List<VaccineType> getAll() { return repository.findAll(); } public VaccineType getById(Long id) { return repository.findById(id).orElse(null); } public VaccineType update(Long id, VaccineType data) { VaccineType type = getById(id); if (type == null) return null; type.setName(data.getName()); type.setIntervalDays(data.getIntervalDays()); type.setDescription(data.getDescription()); return repository.save(type); } public boolean delete(Long id) { if (!repository.existsById(id)) return false; repository.deleteById(id); return true; } public List<VaccineType> search(String keyword) { return repository.findByNameContainingIgnoreCase(keyword); } }
