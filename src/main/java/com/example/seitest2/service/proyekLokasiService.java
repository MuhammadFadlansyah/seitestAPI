package com.example.seitest2.service;

import com.example.seitest2.model.proyekLokasiModel;
import com.example.seitest2.repository.proyekLokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class proyekLokasiService {

    @Autowired
    private proyekLokasiRepository proyekLokasiRepository;

    public List<proyekLokasiModel> getAllProyekLokasi() {
        return proyekLokasiRepository.findAll();
    }
}
