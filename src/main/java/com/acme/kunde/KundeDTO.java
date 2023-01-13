package com.acme.kunde;

import java.time.LocalDate;
import java.util.List;

public record KundeDTO(

        String nachname,
        String email,
        int kategorie,
        boolean hasNewsletter,
        LocalDate geburtsdatum,
        String homepage,
        GeschlechtType geschlecht,
        FamilienstandType familienstand,
        List<InteresseType>interessen,
        AdresseDTO adresse
) {
    Kunde toKunde() {
        return Kunde.builder()
                .id(null)
                .nachname(nachname)
                .email(email)
                .kategorie(kategorie)
                .hasNewsletter(hasNewsletter)
                .geburtsdatum(geburtsdatum)
                .homepage(homepage)
                .geschlecht(geschlecht)
                .familienstand(familienstand)
                .interessen(interessen)
                .adresse(adresse.toAdresse())
                .build();
    }
}
