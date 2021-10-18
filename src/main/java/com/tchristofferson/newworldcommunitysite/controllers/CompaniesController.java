package com.tchristofferson.newworldcommunitysite.controllers;

import com.tchristofferson.newworldcommunitysite.exc.NotFoundException;
import com.tchristofferson.newworldcommunitysite.models.Company;
import com.tchristofferson.newworldcommunitysite.models.enums.FactionSizes;
import com.tchristofferson.newworldcommunitysite.models.enums.Factions;
import com.tchristofferson.newworldcommunitysite.models.enums.Regions;
import com.tchristofferson.newworldcommunitysite.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/companies")
public class CompaniesController {

    private static final int COMPANIES_PER_PAGE = 30;
    private final CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "/page/{page}")
    public String getCompanies(
            Model model,
            @PathVariable("page") int page,
            @Nullable @RequestParam("name") String name,
            @Nullable @RequestParam("server") String server,
            @Nullable @RequestParam("faction") String factionString,
            @Nullable @RequestParam("region") String regionString,
            @Nullable @RequestParam("size") String factionSizeString) {
        Factions faction;
        Regions region;
        FactionSizes factionSize;

        try {
            faction = factionString == null || factionString.isBlank() ? null : Factions.valueOf(factionString);
            region = regionString == null || regionString.isBlank() ? null : Regions.valueOf(regionString);
            factionSize = factionSizeString == null || factionSizeString.isBlank() ? null : FactionSizes.valueOf(factionSizeString);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", "Invalid faction, region, or faction size specified!");
            return "/error/422";
        }

        model.addAttribute("companies", companyService.findPaginated(PageRequest.of(page - 1, COMPANIES_PER_PAGE), name, server, faction, region, factionSize));
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
            Model model,
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
            model.addAttribute("errorMessage", "Invalid faction, region, or faction size specified!");
            return "/error/422";
        }

        Company company = new Company(name.trim(), server.trim(), faction, region, factionSize, description);
        companyService.addCompany(company);
        return "redirect:/companies/" + company.getId();
    }

}
