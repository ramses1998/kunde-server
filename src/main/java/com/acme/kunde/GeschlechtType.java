package com.acme.kunde;

public enum GeschlechtType {
    /**
     * Männlich mit dem internen Wert M für z.B. das Mapping in einem JSON-Datensatz oder
     * das Abspeichern in einer DB.
     */
    MAENNLICH("M"),

    /**
     * Weiblich mit dem internen Wert W für z.B. das Mapping in einem JSON-Datensatz oder
     * das Abspeichern in einer DB.
     */
    WEIBLICH("W"),

    /**
     * Divers mit dem internen Wert D für z.B. das Mapping in einem JSON-Datensatz oder Abspeichern in einer DB.
     */
    DIVERS("D");

    private final String value;

    GeschlechtType(final String value) {
        this.value = value;
    }

}
