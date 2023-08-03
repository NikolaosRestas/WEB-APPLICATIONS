package com.example.demo4.Service;


import com.example.demo4.Model.Customer;
import com.example.demo4.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find customer with id: %s", id)));
    }

    public boolean deleteCustomerById(Long id) {
        final int deletedCount = customerRepository.deleteCustomerById(id);
        if (deletedCount <= 0) {
            throw new RuntimeException(String.format("Cannot find customer with id: %s", id));
        }
        return true;
    }

    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        Customer savedCustomer = findCustomerById(customer.getId());
        savedCustomer.setGym(customer.getGym());
        savedCustomer.setName(customer.getName());
        savedCustomer.setAddress(customer.getAddress());
        savedCustomer.setEmail(customer.getEmail());
        savedCustomer.setPhone(customer.getPhone());
        return customerRepository.save(savedCustomer);
    }
}