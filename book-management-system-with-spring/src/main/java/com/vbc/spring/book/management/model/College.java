package com.vbc.spring.book.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum College {
    SIOM("Sinhgad Institute Of Management", "Wadgoan-bk, Pune-41"),
    SIMCA("Sinhgad Institute of Computer Application", "Narhe, Pune"),
    SCOEP("Sinhgad College Of Engineering", "Ambegoan-Bk, Pune");

    private final String name;
    private final String address;
}
