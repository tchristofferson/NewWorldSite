package com.tchristofferson.newworldcommunitysite.dao;

import com.tchristofferson.newworldcommunitysite.models.Company;

import java.util.List;
import java.util.Optional;

public interface CompaniesDao {

    void addCompany(Company company);

    boolean updateCompany(int id, Company company);

    Optional<Company> getCompany(int id);

    boolean deleteCompany(int id);

    List<Company> getCompanies();

}
