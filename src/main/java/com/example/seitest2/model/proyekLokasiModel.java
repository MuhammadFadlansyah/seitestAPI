package com.example.seitest2.model;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "proyek_lokasi")
@IdClass(proyekLokasiId.class)
public class proyekLokasiModel implements Serializable {

    @Id
    @Column(name = "proyek_id")
    private Long proyekId;

    @Id
    @Column(name = "lokasi_id")
    private Long lokasiId;

    @ManyToOne
    @JoinColumn(name = "proyek_id", insertable = false, updatable = false)
    private proyekModel proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id", insertable = false, updatable = false)
    private lokasiModel lokasi;

    public Long getProyekId() {
        return proyekId;
    }

    public void setProyekId(Long proyekId) {
        this.proyekId = proyekId;
    }

    public Long getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(Long lokasiId) {
        this.lokasiId = lokasiId;
    }

    public proyekModel getProyek() {
        return proyek;
    }

    public void setProyek(proyekModel proyek) {
        this.proyek = proyek;
    }

    public lokasiModel getLokasi() {
        return lokasi;
    }

    public void setLokasi(lokasiModel lokasi) {
        this.lokasi = lokasi;
    }
}