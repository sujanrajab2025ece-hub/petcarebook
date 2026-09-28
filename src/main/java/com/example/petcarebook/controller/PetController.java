package com.example.petcarebook.controller;

import com.example.petcarebook.entity.Pet;
import com.example.petcarebook.service.PetService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetService service;
    public PetController(PetService service) { this.service = service; }
    @PostMapping public ResponseEntity<?> add(@Valid @RequestBody Pet pet) { Pet saved = service.add(pet); return saved == null ? ResponseEntity.badRequest().body(java.util.Map.of("ownerId", "Owner must exist")) : ResponseEntity.ok(saved); }
    @GetMapping public List<Pet> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public ResponseEntity<Pet> getById(@PathVariable Long id) { return ResponseEntity.of(java.util.Optional.ofNullable(service.getById(id))); }
    @PutMapping("/{id}") public ResponseEntity<Pet> update(@PathVariable Long id, @Valid @RequestBody Pet pet) { return ResponseEntity.of(java.util.Optional.ofNullable(service.update(id, pet))); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
    @GetMapping("/search") public List<Pet> search(@RequestParam String keyword) { return service.search(keyword); }
}
