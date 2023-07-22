package com.example.demo3.Service;

import com.example.demo3.Model.Company;
import com.example.demo3.Repository.CompanyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepo;

    public CompanyService(CompanyRepository companyRepo){
        this.companyRepo = companyRepo;
    }

    public List<Company> getAllCompanies(){
        return this.companyRepo.findAll();
    }

    public Optional<Company> findCompanyById(Long id){
        return companyRepo.findById(id);
    }

    public boolean deleteCompanyById(Long id){
        try {
            companyRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertCompany(Company company) {
        companyRepo.save(company);
        return true;
    }
    public boolean updateCompany(Company company) {
        try {
            companyRepo.save(company);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
