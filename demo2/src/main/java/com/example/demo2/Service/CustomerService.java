package com.example.demo2.Service;


import com.example.demo2.Model.Customer;
import com.example.demo2.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository cumRepo;

    public CustomerService(CustomerRepository cumRepo){
        this.cumRepo = cumRepo;
    }

    public List<Customer> getAllCustomers(){
        return this.cumRepo.findAll();
    }

    public Optional<Customer> findCustomerById(Long id){
        return cumRepo.findById(id);
    }

    public boolean deleteCustomerById(Long id){
        try {
            cumRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertCustomer(Customer customer) {
        cumRepo.save(customer);
        return true;
    }
    public boolean updateCustomer(Customer customer) {
        try {
            cumRepo.save(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}