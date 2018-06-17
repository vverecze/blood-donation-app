package com.reaktorlabs.model;

/**
 *
 * @author Viki
 */
public enum GenderType {
    FEMALE("Nő"), MALE("Férfi");
    
    private final String label;

    private GenderType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
