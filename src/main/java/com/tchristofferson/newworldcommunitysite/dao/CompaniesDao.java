package com.tchristofferson.newworldcommunitysite.dao;

import com.tchristofferson.newworldcommunitysite.models.Company;
import com.tchristofferson.newworldcommunitysite.models.enums.FactionSizes;
import com.tchristofferson.newworldcommunitysite.models.enums.Factions;
import com.tchristofferson.newworldcommunitysite.models.enums.Regions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CompaniesDao {

    void addCompany(Company company);

    boolean updateCompany(int id, Company company);

    Optional<Company> getCompany(int id);

    boolean deleteCompany(int id);

    Page<Company> findPaginated(Pageable pageable, String name, String server, Factions faction, Regions region, FactionSizes factionSize);

}
