package com.tchristofferson.newworldcommunitysite.models.enums;

public enum Factions {

    COVENANT("Covenant"),
    MARAUDERS("Marauders"),
    SYNDICATE("Syndicate");

    private final String displayName;

    Factions(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
