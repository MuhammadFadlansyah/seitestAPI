package com.example.seitest2.model;

import java.io.Serializable;
import java.util.Objects;

public class proyekLokasiId implements Serializable {

    private Long proyekId;
    private Long lokasiId;

    // Constructors
    public proyekLokasiId() {}

    public proyekLokasiId(Long proyekId, Long lokasiId) {
        this.proyekId = proyekId;
        this.lokasiId = lokasiId;
    }

    // Getters, setters, equals, and hashCode
}
