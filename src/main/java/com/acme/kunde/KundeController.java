package com.acme.kunde;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path = "/rest")
@CrossOrigin(origins = "*")
@Slf4j
public class KundeController {

    List<Adresse> ADRESSEN = List.of(
            new Adresse(
                    UUID.fromString("20000000-0000-0000-0000-000000000000"),
                    "00000",
                    "Aachen"
            ),
            new Adresse(
                    UUID.fromString("20000000-0000-0000-0000-000000000001"),
                    "11111",
                    "Augsburg"
            ),
            new Adresse(
                    UUID.fromString("20000000-0000-0000-0000-000000000030"),
                    "33333",
                    "Ahlen"
            ),
            new Adresse(
                    UUID.fromString("20000000-0000-0000-0000-000000000040"),
                    "44444",
                    "Dortmund"
            ),
            new Adresse(
                    UUID.fromString("20000000-0000-0000-0000-000000000050"),
                    "55555",
                    "Essen"
            ),
            new Adresse(
                    UUID.fromString("20000000-0000-0000-0000-000000000060"),
                    "66666",
                    "Freiburg"
            )
    );

    List<Kunde> KUNDEN = List.of(
            new Kunde(
                    UUID.fromString("00000000-0000-0000-0000-000000000000"),
                    "Max Musstermann",
                    "max-musstermann@acme.com",
                    1,
                    true,
                    LocalDate.of(1950, 1, 5),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.LEDIG,
                    List.of(InteresseType.LESEN, InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(0)
            ),
            new Kunde(
                    UUID.fromString("00000000-0000-0000-0000-000000000001"),
                    "Max Doe",
                    "max-doe@acme.com",
                    1,
                    false,
                    LocalDate.of(2000, 7, 8),
                    "https://www.acme.ru",
                    GeschlechtType.WEIBLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.LESEN),
                    ADRESSEN.get(1)
            ),
            new Kunde(
                    UUID.fromString("00000000-0000-0000-0000-000000000002"),
                    "John Doe",
                    "admin@acme.en",
                    1,
                    true,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.it",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERWITWET,
                    List.of(InteresseType.LESEN, InteresseType.SPORT),
                    ADRESSEN.get(2)
            ),
            new Kunde(
                    UUID.fromString("00000000-0000-0000-0000-000000000030"),
                    "John Doe 25",
                    "john-doe-25@acme.cm",
                    0,
                    false,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.no",
                    GeschlechtType.DIVERS,
                    FamilienstandType.LEDIG,
                    List.of(InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(3)
            ),
            new Kunde(
                    UUID.fromString("00000000-0000-0000-0000-000000000040"),
                    "Lukas Mustermann",
                    "lukas-m@acme.com",
                    0,
                    true,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.edu",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.LEDIG,
                    List.of(InteresseType.LESEN, InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(4)
            ),
            new Kunde(
                    UUID.fromString("00000000-0000-0000-0000-000000000050"),
                    "Sophie Mustermann",
                    "sophie@acme.org",
                    0,
                    true,
                    LocalDate.of(1980, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("1959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "Juergen Mustermann",
                    "juergen-mustermann@acme.org",
                    0,
                    true,
                    LocalDate.of(1990, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("2959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "Dinh Mustermann",
                    "admin@acme.org",
                    0,
                    true,
                    LocalDate.of(1980, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("3959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "Edgar M??ller",
                    "admin@acme.org",
                    0,
                    true,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("4959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "Anna Anne",
                    "admin@acme.org",
                    0,
                    true,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("5959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "Jemand Irgendjemnd",
                    "admin@acme.org",
                    0,
                    true,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("6959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "Bla Blabla",
                    "admin@acme.org",
                    0,
                    false,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("7959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "JKHKJ LKHLKHL",
                    "admin@acme.org",
                    0,
                    false,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("8959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "Test Mustermann",
                    "admin@acme.org",
                    0,
                    true,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("9959e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "Lukas M??ller",
                    "admin@acme.org",
                    0,
                    true,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.LESEN),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("1059e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "J??rgen M??ller",
                    "admin@acme.org",
                    0,
                    true,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.SPORT),
                    ADRESSEN.get(5)
            ),
            new Kunde(
                    UUID.fromString("1159e734-54cf-4c24-a25b-b5c0d4fcacdc"),
                    "J??rgen Blablabla",
                    "admin@acme.org",
                    0,
                    false,
                    LocalDate.of(2022, 01, 05),
                    "https://www.acme.com",
                    GeschlechtType.MAENNLICH,
                    FamilienstandType.VERHEIRATET,
                    List.of(InteresseType.LESEN, InteresseType.SPORT, InteresseType.LESEN),
                    ADRESSEN.get(5)
            )
    );

    @GetMapping
    ResponseEntity<List<Kunde>> findAll() {
        return ok().body(KUNDEN);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Kunde> findById(@PathVariable final UUID id) {

        log.debug("findById: id={}", id);
        var kunde = KUNDEN
                .stream()
                .filter(k -> Objects.equals(k.getId(), id))
                .findFirst();
        log.info("Kunde: {}", kunde.get());

        return ok().body(kunde.get());
    }

//    @GetMapping
//    ResponseEntity<List<Kunde>> findByNachname(@RequestParam final String nachname) {
//        final var kunde = KUNDEN.stream()
//                .filter(k -> Objects.equals(k.getNachname(), nachname))
//                .collect(Collectors.toList());
//        return ok().body(kunde);
//    }

    @PostMapping
    ResponseEntity<Void> create(
            @RequestBody final KundeDTO kundeDTO
    ) throws URISyntaxException {
        var kunde = kundeDTO.toKunde();
        kunde.setId(UUID.randomUUID());
        var adresse = kunde.getAdresse();
        adresse.setId(UUID.randomUUID());
        kunde.setAdresse(adresse);
        KUNDEN.add(kunde);
        var uri = new URI("localhost:8080/" + kunde.getId());
        return created(uri).build();
    }

    @PutMapping(path = "/{id}")
    void update(
            @PathVariable final UUID id,
            @RequestBody final KundeDTO kundeDTO) {
        log.info("InputKundeDTO= {}", kundeDTO);

        KUNDEN = KUNDEN.stream()
                .filter(k -> !Objects.equals(k.getId(), id))
                .collect(Collectors.toList());

        final var neuerKunde = kundeDTO.toKunde();
        neuerKunde.setId(id);
        var adresse = kundeDTO.adresse().toAdresse();
        adresse.setId(
                ADRESSEN.stream()
                        .filter(a ->
                                Objects.equals(a.getOrt(), kundeDTO.adresse().ort()) &&
                                        Objects.equals(a.getPlz(), kundeDTO.adresse().plz())
                        )
                        .findFirst().get().getId()
        );
        neuerKunde.setAdresse(adresse);
        log.info("Updated Kunde= {}", neuerKunde);

        var index = 0;

        for (int i = 0; i < KUNDEN.size(); i++) {
            if (Objects.equals(KUNDEN.get(i).getId(), id)) {
                index = i;
            }
        }

        KUNDEN.add(neuerKunde);

//        for (int i = 0; i < KUNDEN.size(); i++) {
//            if (Objects.equals(KUNDEN.get(i).getId(), id)) {
//                final var neuerKunde = kundeDTO.toKunde();
//                neuerKunde.setId(id);
//                var adresse = kundeDTO.adresse().toAdresse();
//                adresse.setId(UUID.fromString("5959e734-54cf-4c24-a25b-b5c0d4fcacdc"));
//                neuerKunde.setAdresse(adresse);
//                log.info("Updated Kunde= {}", neuerKunde);
//                log.info("Index= {}", i);
//                KUNDEN.set(i, neuerKunde);
//            }
//        }


//        KUNDEN = KUNDEN.stream().map(k -> {
//            if (Objects.equals(k.getId(), id)) {
//                final var neuerKunde = kundeDTO.toKunde();
//                neuerKunde.setId(k.getId());
//                var adresse = kundeDTO.adresse().toAdresse();
//                adresse.setId(
//                        ADRESSEN.stream()
//                                .filter(a ->
//                                        Objects.equals(a.getOrt(), kundeDTO.adresse().ort()) &&
//                                        Objects.equals(a.getPlz(), kundeDTO.adresse().plz())
//                                )
//                                .findFirst().get().getId()
//                );
//                neuerKunde.setAdresse(adresse);
//                log.info("Updated Kunde= {}", neuerKunde);
//                return neuerKunde;
//            }
//            return k;
//        }).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable final UUID id) {
        KUNDEN = KUNDEN.stream()
                .filter(k -> !Objects.equals(k.getId(), id))
                .collect(Collectors.toList());
    }
}
