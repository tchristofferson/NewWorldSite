package com.tchristofferson.newworldcommunitysite.models.enums;

public enum Regions {

    US_EAST("US East"),
    US_WEST("US West"),
    EU_CENTRAL("EU Central"),
    AP_SOUTHEAST("AP Southeast"),
    SA_EAST("SA East");

    private final String displayName;

    Regions(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
