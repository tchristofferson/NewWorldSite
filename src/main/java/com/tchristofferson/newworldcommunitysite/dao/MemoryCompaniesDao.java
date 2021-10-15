package com.tchristofferson.newworldcommunitysite.dao;

import com.tchristofferson.newworldcommunitysite.models.Company;
import org.springframework.stereotype.Repository;

import java.util.*;

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
    public List<Company> getCompanies() {
        return new ArrayList<>(COMPANY_DB.values());
    }
}
