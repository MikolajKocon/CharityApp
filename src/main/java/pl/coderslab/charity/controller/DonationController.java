package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    private final CategoryService categoryService;

    private final InstitutionService institutionService;

    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/form")
    public String addDonation(Model model) {
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "form";
    }

    @PostMapping("/form")
    public String addDonation(@Valid Donation donation, BindingResult results, Model model) {
        model.addAttribute("donation", donation);
        if(results.hasErrors()){
            return "form";
        }
        donationService.save(donation);
        return "form-confirmation";
    }

    @ModelAttribute("categories")
    public List<Category> findCategories() {
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> findInstitution() {
        return institutionService.findAll();
    }
}
