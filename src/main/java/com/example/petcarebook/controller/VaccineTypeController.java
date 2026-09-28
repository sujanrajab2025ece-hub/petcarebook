package com.example.petcarebook.controller;

import com.example.petcarebook.entity.VaccineType;
import com.example.petcarebook.service.VaccineTypeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vaccine-types")
public class VaccineTypeController {
    private final VaccineTypeService service;
    public VaccineTypeController(VaccineTypeService service) { this.service = service; }
    @PostMapping public VaccineType add(@Valid @RequestBody VaccineType type) { return service.add(type); }
    @GetMapping public List<VaccineType> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public ResponseEntity<VaccineType> getById(@PathVariable Long id) { return ResponseEntity.of(java.util.Optional.ofNullable(service.getById(id))); }
    @PutMapping("/{id}") public ResponseEntity<VaccineType> update(@PathVariable Long id, @Valid @RequestBody VaccineType type) { return ResponseEntity.of(java.util.Optional.ofNullable(service.update(id, type))); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
    @GetMapping("/search") public List<VaccineType> search(@RequestParam String keyword) { return service.search(keyword); }
}
