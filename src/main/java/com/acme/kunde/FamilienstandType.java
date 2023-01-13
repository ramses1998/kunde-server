package com.acme.kunde;

public enum FamilienstandType {
    /**
    * Ledig mit dem internen Wert L für z.B. das Mapping in einem JSON-Datensatz oder das Abspeichern in einer DB.
    */
    LEDIG("L"),

    /**
    * Verheiratet mit dem internen Wert VH für z.B. das Mapping in einem JSON-Datensatz oder
    * das Abspeichern in einer DB.
    */
    VERHEIRATET("VH"),

    /**
    * Geschieden mit dem internen Wert G für z.B. das Mapping in einem JSON-Datensatz oder
    * das Abspeichern in einer DB.
    */
    GESCHIEDEN("G"),

    /**
    * Verwitwet mit dem internen Wert VW für z.B. das Mapping in einem JSON-Datensatz oder
    * das Abspeichern in einer DB.
    */
    VERWITWET("VW");

    private final String value;

    FamilienstandType(final String value) {
        this.value = value;
    }
}
