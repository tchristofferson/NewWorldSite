package com.tchristofferson.newworldcommunitysite.controllers;

import com.tchristofferson.newworldcommunitysite.exc.NotFoundException;
import com.tchristofferson.newworldcommunitysite.exc.UnprocessableEntityException;
import com.tchristofferson.newworldcommunitysite.models.Company;
import com.tchristofferson.newworldcommunitysite.models.enums.FactionSizes;
import com.tchristofferson.newworldcommunitysite.models.enums.Factions;
import com.tchristofferson.newworldcommunitysite.models.enums.Regions;
import com.tchristofferson.newworldcommunitysite.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/companies")
public class CompaniesController {

    private final CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String getCompanies(Model model) {
        model.addAttribute("companies", companyService.getCompanies());
        return "companies";
    }

    @GetMapping(path = "{id}")
    public String getCompany(Model model, @PathVariable("id") int id) {
        Optional<Company> optionalCompany = companyService.getCompany(id);

        if (optionalCompany.isEmpty())
            throw new NotFoundException();

        model.addAttribute("company", optionalCompany.get());
        return "company";
    }

    @GetMapping(path = "/register")
    public String registerCompany() {
        return "register-company-form";
    }

    @PostMapping(path = "/create")
    public String createCompany(
            @RequestParam("name") String name,
            @RequestParam("server") String server,
            @RequestParam("faction") String factionString,
            @RequestParam("region") String regionString,
            @RequestParam("factionSize") String factionSizeString,
            @Nullable @RequestParam("description") String description) {
        Factions faction;
        Regions region;
        FactionSizes factionSize;

        try {
            faction = Factions.valueOf(factionString);
            region = Regions.valueOf(regionString);
            factionSize = FactionSizes.valueOf(factionSizeString);
        } catch (IllegalArgumentException e) {
            throw new UnprocessableEntityException("Unprocessable faction, region, or factionSize specified!");
        }

        Company company = new Company(name.trim(), server.trim(), faction, region, factionSize, description);
        companyService.addCompany(company);
        return "redirect:/companies/" + company.getId();
    }

}
