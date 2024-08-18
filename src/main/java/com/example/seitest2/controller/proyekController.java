package com.example.seitest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.seitest2.model.proyekModel;
import com.example.seitest2.service.proyekService;
import java.util.List;

@RestController
@RequestMapping("/proyek")
public class proyekController {

    @Autowired
    private proyekService proyekService;

    @PostMapping
    public ResponseEntity<proyekModel> createProyek(@RequestBody proyekModel proyek, @RequestParam List<Long> lokasiIds) {
        proyekModel savedProyek = proyekService.saveProyek(proyek, lokasiIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProyek);
    }

    @GetMapping
    public ResponseEntity<List<proyekModel>> getAllProyek() {
        List<proyekModel> proyekList = proyekService.getAllProyek();
        return ResponseEntity.ok(proyekList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<proyekModel> updateProyek(@PathVariable Long id, @RequestBody proyekModel proyekDetails, @RequestParam List<Long> lokasiIds) {
        proyekModel updatedProyek = proyekService.updateProyek(id, proyekDetails, lokasiIds);
        return ResponseEntity.ok(updatedProyek);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Long id) {
        proyekService.deleteProyek(id);
        return ResponseEntity.noContent().build();
    }
}
