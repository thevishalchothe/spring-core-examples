package com.vbc.library.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public enum College {
    SIOM("Sinhgad Institute Of Management", "Wadgoan-bk, Pune-41"),
    SIMCA("Sinhgad Institute of Computer Application", "Narhe, Pune"),
    SCOEP("Sinhgad College Of Engineering", "Ambegoan-Bk, Pune");

    private final String name;
    private final String address;

}
