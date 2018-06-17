package com.reaktorlabs.model;

/**
 *
 * @author Viki
 */
public enum RhType {
    POSITIVE("+"), NEGATIVE("-");
    
    private final String label;

    private RhType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
