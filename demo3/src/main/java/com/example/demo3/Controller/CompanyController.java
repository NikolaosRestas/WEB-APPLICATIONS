package com.example.demo3.Controller;

import com.example.demo3.Model.Company;
import com.example.demo3.Service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {
    private final CompanyService companyservice;

    public CompanyController(CompanyService companyservice){
        this.companyservice = companyservice;
    }

    @GetMapping("/company/index")
    public String getAllCompanies(Model model){
        model.addAttribute("companies", companyservice.getAllCompanies());
        return "company/index";
    }

    @GetMapping("/company/create")
    public String showCreateForm(Company company) {
        return "company/create";
    }

    @PostMapping("/addCompany")
    public String addUser(Company company, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "company/create";
        }
        companyservice.insertCompany(company);
        return "redirect:/company/index";
    }

    @GetMapping("/company/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Company company = companyservice.findCompanyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Company Id:" + id));
        companyservice.deleteCompanyById(company.getId());
        return "redirect:/company/index";
    }

    @GetMapping("/company/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Company company = companyservice.findCompanyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Company Id:" + id));

        model.addAttribute("company", company);
        return "redirect:/company/update";
    }

    @PostMapping("/company/update/{id}")
    public String updateCompany(@PathVariable("id") long id, Company company,
                                 BindingResult result, Model model){
        if (result.hasErrors()) {
            company.setId(id);
            return "update-user";
        }
        companyservice.updateCompany(company);
        return "redirect:/company/index";
    }
}
