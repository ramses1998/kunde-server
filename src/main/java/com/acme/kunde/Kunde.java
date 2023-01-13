package com.acme.kunde;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Kunde {

    private UUID id;
    private String nachname;
    private String email;
    private int kategorie;
    private boolean hasNewsletter;
    private LocalDate geburtsdatum;
    private String homepage;
    private GeschlechtType geschlecht;
    private FamilienstandType familienstand;
    private List<InteresseType> interessen;
    private Adresse adresse;
}
