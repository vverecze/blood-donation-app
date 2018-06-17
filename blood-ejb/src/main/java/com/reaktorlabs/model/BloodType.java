package com.reaktorlabs.model;

/**
 *
 * @author Viki
 */
public enum BloodType {
    A("A"), B("B"), AB("AB"), ZERO("0");
    
    private final String label;

    private BloodType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
