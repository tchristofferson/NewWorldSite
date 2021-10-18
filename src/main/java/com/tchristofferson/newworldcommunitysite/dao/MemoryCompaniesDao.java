package com.tchristofferson.newworldcommunitysite.dao;

import com.tchristofferson.newworldcommunitysite.models.Company;
import com.tchristofferson.newworldcommunitysite.models.enums.FactionSizes;
import com.tchristofferson.newworldcommunitysite.models.enums.Factions;
import com.tchristofferson.newworldcommunitysite.models.enums.Regions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;

@Repository("testDao")
public class MemoryCompaniesDao implements CompaniesDao {

    private int currentId = 0;
    private final Map<Integer, Company> COMPANY_DB = new HashMap<>();

    @Override
    public void addCompany(Company company) {
        COMPANY_DB.put(currentId, company);
        company.setId(currentId++);
    }

    @Override
    public boolean updateCompany(int id, Company company) {
        if (!COMPANY_DB.containsKey(id))
            return false;

        COMPANY_DB.put(id, company);
        company.setId(id);

        return true;
    }

    @Override
    public Optional<Company> getCompany(int id) {
        Company company = COMPANY_DB.get(id);

        if (company != null)
            return Optional.of(company);

        return Optional.empty();
    }

    @Override
    public boolean deleteCompany(int id) {
        return COMPANY_DB.remove(id) != null;
    }

    @Override
    public Page<Company> findPaginated(Pageable pageable, String name, String server, Factions faction, Regions region, FactionSizes factionSize) {
        List<Company> matchingCompanies = getCompanies(name, server, faction, region, factionSize);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Company> companyList;

        if (matchingCompanies.size() < startItem) {
            companyList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, matchingCompanies.size());
            companyList = matchingCompanies.subList(startItem, toIndex);
        }

        return new PageImpl<>(companyList, PageRequest.of(currentPage, pageSize), matchingCompanies.size());
    }

    private List<Company> getCompanies(String name, String server, Factions faction, Regions region, FactionSizes factionSize) {
        List<Company> companyList = new ArrayList<>();

        for (Company company : COMPANY_DB.values()) {
            if ((name == null || company.getName().toLowerCase().contains(name.trim().toLowerCase()))
                    && (server == null || company.getServer().toLowerCase().contains(server.trim().toLowerCase()))
                    && (faction == null || company.getFaction() == faction)
                    && (region == null || company.getRegion() == region)
                    && (factionSize == null || company.getFactionSize() == factionSize)) {
                companyList.add(company);
            }
        }

        return companyList;
    }
}
