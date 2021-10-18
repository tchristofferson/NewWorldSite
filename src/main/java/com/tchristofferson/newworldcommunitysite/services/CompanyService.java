package com.tchristofferson.newworldcommunitysite.services;

import com.tchristofferson.newworldcommunitysite.dao.CompaniesDao;
import com.tchristofferson.newworldcommunitysite.models.Company;
import com.tchristofferson.newworldcommunitysite.models.enums.FactionSizes;
import com.tchristofferson.newworldcommunitysite.models.enums.Factions;
import com.tchristofferson.newworldcommunitysite.models.enums.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompaniesDao companiesDao;

    @Autowired
    public CompanyService(@Qualifier("testDao") CompaniesDao companiesDao) {
        this.companiesDao = companiesDao;
        this.companiesDao.addCompany(new Company("Cheeky Blinders", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_25, "The Cheeky Blinders is the most notorious gang in all of New World. We hunt in packs and kill everything in our path."));
        this.companiesDao.addCompany(new Company("The Crimson Shadow", "Krocylea", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.OVER_50, "We only play New World. We are not like other companies that are playing multiple games. We are laser focused on New World and  clearing its content. Drop on by if you're interested!"));
        this.companiesDao.addCompany(new Company("The High Council", "Himavanta", Factions.MARAUDERS, Regions.US_EAST, FactionSizes.UNDER_50, "We are a PvP heavy company that focuses on territory control."));
        this.companiesDao.addCompany(new Company("Ordo Aeterna Lucis", "Valhalla", Factions.COVENANT, Regions.US_EAST, FactionSizes.OVER_50, "We are focused on maintaining an active and cohesive companies that we will continuously refine as we progress to maintain a competitive edge"));
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

    public Page<Company> findPaginated(Pageable pageable, String name, String server, Factions faction, Regions region, FactionSizes factionSize) {
        return companiesDao.findPaginated(pageable, name, server, faction, region, factionSize);
    }
}
