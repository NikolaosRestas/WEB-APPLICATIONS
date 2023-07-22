package com.example.demo3.Service;

import com.example.demo3.Model.Customer;
import com.example.demo3.Repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo){
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers(){
        return this.customerRepo.findAll();
    }

    public Optional<Customer> findCustomerById(Long id){
        return customerRepo.findById(id);
    }

    public boolean deleteCustomerById(Long id){
        try {
            customerRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertCustomer(Customer customer) {
        customerRepo.save(customer);
        return true;
    }
    public boolean updateCustomer(Customer customer) {
        try {
            customerRepo.save(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
