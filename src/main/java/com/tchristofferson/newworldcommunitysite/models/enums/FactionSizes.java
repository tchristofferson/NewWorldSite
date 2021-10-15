package com.tchristofferson.newworldcommunitysite.models.enums;

public enum FactionSizes {

    UNDER_10("<10"),
    UNDER_25("<25"),
    UNDER_50("<50"),
    OVER_50("50+");

    private final String displayValue;

    FactionSizes(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
