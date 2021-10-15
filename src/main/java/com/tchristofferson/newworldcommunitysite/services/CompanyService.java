package com.tchristofferson.newworldcommunitysite.services;

import com.tchristofferson.newworldcommunitysite.dao.CompaniesDao;
import com.tchristofferson.newworldcommunitysite.models.Company;
import com.tchristofferson.newworldcommunitysite.models.enums.FactionSizes;
import com.tchristofferson.newworldcommunitysite.models.enums.Factions;
import com.tchristofferson.newworldcommunitysite.models.enums.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompaniesDao companiesDao;

    @Autowired
    public CompanyService(@Qualifier("testDao") CompaniesDao companiesDao) {
        this.companiesDao = companiesDao;
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
    }

    public void addCompany(Company company) {
        companiesDao.addCompany(company);
    }

    public boolean updateCompany(int id, Company company) {
        return companiesDao.updateCompany(id, company);
    }

    public Optional<Company> getCompany(int id) {
        return companiesDao.getCompany(id);
    }

    public boolean deleteCompany(int id) {
        return companiesDao.deleteCompany(id);
    }

    public List<Company> getCompanies() {
        return companiesDao.getCompanies();
    }
}
