package com.example.seitest2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.seitest2.model.lokasiModel;
import com.example.seitest2.repository.lokasiRepository;
import com.example.seitest2.service.ResourceNotFoundException;

@Service
public class lokasiService {

    @Autowired
    private lokasiRepository lokasiRepository;

    public lokasiModel saveLokasi(lokasiModel lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public List<lokasiModel> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public lokasiModel updateLokasi(Long id, lokasiModel lokasiDetails) {
        lokasiModel lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found with id: " + id));
        lokasi.setNama_lokasi(lokasiDetails.getNama_lokasi());
        lokasi.setNegara(lokasiDetails.getNegara());
        lokasi.setProvinsi(lokasiDetails.getProvinsi());
        lokasi.setKota(lokasiDetails.getKota());
        return lokasiRepository.save(lokasi);
    }

    public void deleteLokasi(Long id) {
        lokasiModel lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found with id: " + id));
        lokasiRepository.delete(lokasi);
    }
}


