package com.example.seitest2.controller;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.seitest2.service.lokasiService;
import com.example.seitest2.model.lokasiModel;

@RestController
@RequestMapping("/lokasi")
@CrossOrigin(origins = "http://localhost/bcit-ci-CodeIgniter-bcb17eb")
public class lokasiController {

    @Autowired
    private lokasiService lokasiService;

    @PostMapping
    public ResponseEntity<lokasiModel> createLokasi(@RequestBody lokasiModel lokasi) {
        lokasi.setCreated_at(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
        lokasiModel savedLokasi = lokasiService.saveLokasi(lokasi);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLokasi);
    }

    @GetMapping
    public ResponseEntity<List<lokasiModel>> getAllLokasi() {
        List<lokasiModel> lokasiList = lokasiService.getAllLokasi();
        return ResponseEntity.ok(lokasiList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<lokasiModel> updateLokasi(@PathVariable Long id, @RequestBody lokasiModel lokasiDetails) {
        lokasiModel updatedLokasi = lokasiService.updateLokasi(id, lokasiDetails);
        return ResponseEntity.ok(updatedLokasi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Long id) {
        lokasiService.deleteLokasi(id);
        return ResponseEntity.noContent().build();
    }
}


