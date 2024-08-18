package com.example.seitest2.repository;

import com.example.seitest2.model.proyekLokasiModel;
import com.example.seitest2.model.proyekModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface proyekLokasiRepository extends JpaRepository<proyekLokasiModel, Long> {

    void deleteByProyekId(Long proyekId);

    Set<proyekLokasiModel> findByProyek(proyekModel proyek);
}