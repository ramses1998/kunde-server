package com.acme.kunde;

public enum InteresseType {
    /**
     * Sport mit dem internen Wert S für z.B. das Mapping in einem JSON-Datensatz oder das Abspeichern in einer DB.
     */
    SPORT("S"),
    /**
    * Lesen mit dem internen Wert L für z.B. das Mapping in einem JSON-Datensatz oder das Abspeichern in einer DB.
    */
    LESEN("L"),

    /**
    * Reisen mit dem internen Wert R für z.B. das Mapping in einem JSON-Datensatz oder das Abspeichern in einer DB.
    */
    REISEN("R");

    private final String value;

    InteresseType(final String value) {
        this.value = value;
    }

}
