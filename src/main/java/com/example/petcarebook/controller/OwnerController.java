package com.example.petcarebook.controller;

import com.example.petcarebook.entity.Owner;
import com.example.petcarebook.service.OwnerService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    private final OwnerService service;
    public OwnerController(OwnerService service) { this.service = service; }
    @PostMapping public Owner add(@Valid @RequestBody Owner owner) { return service.add(owner); }
    @GetMapping public List<Owner> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public ResponseEntity<Owner> getById(@PathVariable Long id) { return ResponseEntity.of(java.util.Optional.ofNullable(service.getById(id))); }
    @PutMapping("/{id}") public ResponseEntity<Owner> update(@PathVariable Long id, @Valid @RequestBody Owner owner) { return ResponseEntity.of(java.util.Optional.ofNullable(service.update(id, owner))); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
    @GetMapping("/search") public List<Owner> search(@RequestParam String keyword) { return service.search(keyword); }
}
