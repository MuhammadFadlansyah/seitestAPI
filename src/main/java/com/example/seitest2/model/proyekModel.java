package com.example.seitest2.model;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "proyek")
public class proyekModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama_proyek;
    private String client;
    private String tgl_mulai;
    private String tgl_selesai;
    private String pimpinan_proyek;
    private String keterangan;

    @OneToMany(mappedBy = "proyek")
    private Set<proyekLokasiModel> proyekLokasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_proyek() {
        return nama_proyek;
    }

    public void setNama_proyek(String nama_proyek) {
        this.nama_proyek = nama_proyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTgl_mulai() {
        return tgl_mulai;
    }

    public void setTgl_mulai(String tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public String getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(String tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getPimpinan_proyek() {
        return pimpinan_proyek;
    }

    public void setPimpinan_proyek(String pimpinan_proyek) {
        this.pimpinan_proyek = pimpinan_proyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Set<proyekLokasiModel> getProyekLokasi() {
        return proyekLokasi;
    }

    public void setProyekLokasi(Set<proyekLokasiModel> proyekLokasi) {
        this.proyekLokasi = proyekLokasi;
    }
}
