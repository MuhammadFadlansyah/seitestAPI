package com.example.seitest2.controller;

import com.example.seitest2.model.proyekLokasiModel;
import com.example.seitest2.service.proyekLokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proyek_lokasi")
public class proyekLokasiController {

    @Autowired
    private proyekLokasiService proyekLokasiService;

    @GetMapping
    public ResponseEntity<List<proyekLokasiModel>> getAllProyekLokasi() {
        List<proyekLokasiModel> proyekLokasiList = proyekLokasiService.getAllProyekLokasi();
        return ResponseEntity.ok(proyekLokasiList);
    }
}
