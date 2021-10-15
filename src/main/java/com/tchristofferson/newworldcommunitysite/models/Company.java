package com.tchristofferson.newworldcommunitysite.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tchristofferson.newworldcommunitysite.models.enums.FactionSizes;
import com.tchristofferson.newworldcommunitysite.models.enums.Factions;
import com.tchristofferson.newworldcommunitysite.models.enums.Regions;

import java.util.Objects;

public class Company {

    private int id = -1;
    private String name;
    private String server;
    private Factions faction;
    private Regions region;
    private FactionSizes factionSize;
    private String description;

    public Company(String name, String server, Factions faction, Regions region, FactionSizes factionSize, String description) {
        this.name = name;
        this.server = server;
        this.faction = faction;
        this.region = region;
        this.factionSize = factionSize;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Factions getFaction() {
        return faction;
    }

    public void setFaction(Factions faction) {
        this.faction = faction;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public FactionSizes getFactionSize() {
        return factionSize;
    }

    public void setFactionSize(FactionSizes factionSize) {
        this.factionSize = factionSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Company company = (Company) o;
        return id == company.id && name.equals(company.name) && server.equals(company.server)
                && faction == company.faction && region == company.region && factionSize == company.factionSize
                && Objects.equals(description, company.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, server, faction, region, factionSize, description);
    }
}
