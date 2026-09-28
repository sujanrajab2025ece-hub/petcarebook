package com.example.petcarebook.controller;

import com.example.petcarebook.entity.VaccinationRecord;
import com.example.petcarebook.service.VaccinationRecordService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vaccination-records")
public class VaccinationRecordController {
    private final VaccinationRecordService service;
    public VaccinationRecordController(VaccinationRecordService service) { this.service = service; }
    @PostMapping public ResponseEntity<?> add(@Valid @RequestBody VaccinationRecord record) { VaccinationRecord saved = service.add(record); return saved == null ? ResponseEntity.badRequest().body(java.util.Map.of("record", "Pet and vaccine type must exist; date given cannot be in the future")) : ResponseEntity.ok(saved); }
    @GetMapping public List<VaccinationRecord> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public ResponseEntity<VaccinationRecord> getById(@PathVariable Long id) { return ResponseEntity.of(java.util.Optional.ofNullable(service.getById(id))); }
    @PutMapping("/{id}") public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody VaccinationRecord record) { VaccinationRecord updated = service.update(id, record); return updated == null ? ResponseEntity.badRequest().body(java.util.Map.of("record", "Record not found, linked pet/type invalid, or date given is in the future")) : ResponseEntity.ok(updated); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
    @GetMapping("/search") public List<VaccinationRecord> search(@RequestParam String keyword) { return service.search(keyword); }
    @GetMapping("/due") public List<VaccinationRecord> dueSoon(@RequestParam(defaultValue = "7") int days) { return service.dueSoon(days); }
}
