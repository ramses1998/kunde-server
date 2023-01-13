package com.acme.kunde;

public record AdresseDTO(
        String plz,
        String ort
) {
    Adresse toAdresse() {
        return new Adresse(
                null,
                plz,
                ort
        );
    }
}
