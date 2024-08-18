package com.example.seitest2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.seitest2.model.lokasiModel;
import com.example.seitest2.model.proyekLokasiModel;
import com.example.seitest2.model.proyekModel;
import com.example.seitest2.repository.lokasiRepository;
import com.example.seitest2.repository.proyekLokasiRepository;
import com.example.seitest2.repository.proyekRepository;
import java.util.List;

@Service
public class proyekService {

    @Autowired
    private proyekRepository proyekRepository;

    @Autowired
    private lokasiRepository lokasiRepository;

    @Autowired
    private proyekLokasiRepository proyekLokasiRepository;

    @Transactional
    public proyekModel saveProyek(proyekModel proyek, List<Long> lokasiIds) {
        proyekModel savedProyek = proyekRepository.save(proyek);

        proyekLokasiRepository.deleteByProyekId(savedProyek.getId());

        for (Long lokasiId : lokasiIds) {
            lokasiModel lokasi = lokasiRepository.findById(lokasiId)
                    .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found with id: " + lokasiId));

            proyekLokasiModel proyekLokasi = new proyekLokasiModel();
            proyekLokasi.setProyekId(lokasiId);
            proyekLokasi.setLokasiId(lokasiId);

            proyekLokasiRepository.save(proyekLokasi);
        }

        return savedProyek;
    }

    public List<proyekModel> getAllProyek() {
        List<proyekModel> proyekList = proyekRepository.findAll();
        for (proyekModel proyek : proyekList) {
            proyek.setProyekLokasi(proyekLokasiRepository.findByProyek(proyek));
        }
        return proyekList;
    }

    @Transactional
    public proyekModel updateProyek(Long id, proyekModel proyekDetails, List<Long> lokasiIds) {
        proyekModel proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyek not found with id: " + id));

        proyek.setNama_proyek(proyekDetails.getNama_proyek());
        proyek.setClient(proyekDetails.getClient());
        proyek.setTgl_mulai(proyekDetails.getTgl_mulai());
        proyek.setTgl_selesai(proyekDetails.getTgl_selesai());
        proyek.setPimpinan_proyek(proyekDetails.getPimpinan_proyek());
        proyek.setKeterangan(proyekDetails.getKeterangan());

        // Hapus data proyekLokasi lama
        proyekLokasiRepository.deleteByProyekId(proyek.getId());

        // Tambah data proyekLokasi baru
        for (Long lokasiId : lokasiIds) {
            lokasiModel lokasi = lokasiRepository.findById(lokasiId)
                    .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found with id: " + lokasiId));

            proyekLokasiModel proyekLokasi = new proyekLokasiModel();
            proyekLokasi.setProyekId(id);
            proyekLokasi.setLokasiId(lokasiId);

            proyekLokasiRepository.save(proyekLokasi);
        }

        return proyekRepository.save(proyek);
    }

    @Transactional
    public void deleteProyek(Long id) {
        proyekModel proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyek not found with id: " + id));

        // Hapus data proyekLokasi terkait
        proyekLokasiRepository.deleteByProyekId(id);

        proyekRepository.delete(proyek);
    }
}