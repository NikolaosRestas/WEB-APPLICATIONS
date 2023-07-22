package com.example.demo2.Controller;

import com.example.demo2.Model.Customer;
import com.example.demo2.Model.Nomos;
import com.example.demo2.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    private final CustomerService customerservice;

    public CustomerController(CustomerService customerservice){
        this.customerservice = customerservice;
    }

    @GetMapping("/customer/index")
    public String getAllCustomers(Model model){
        model.addAttribute("customers", customerservice.getAllCustomers());
        return "customer/index";
    }

    @GetMapping("/customer/create")
    public String showCreateForm(Customer customer) {
        return "customer/create";
    }

    @PostMapping("/addCustomer")
    public String addUser(Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customer/create";
        }
        customerservice.insertCustomer(customer);
        return "redirect:/customer/index";
    }

    @GetMapping("/customer/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Customer customer = customerservice.findCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Customer Id:" + id));
        customerservice.deleteCustomerById(customer.getId());
        return "redirect:/customer/index";
    }

    @GetMapping("/customer/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Customer customer = customerservice.findCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Customer Id:" + id));

        model.addAttribute("customer", customer);
        return "customer/update";
    }

    @PostMapping("/customer/update/{id}")
    public String updateCustomer(@PathVariable("id") long id, Customer customer,
                              BindingResult result, Model model){
        if (result.hasErrors()) {
            customer.setId(id);
            return "update-user";
        }
        customerservice.updateCustomer(customer);
        return "redirect:/customer/index";
    }
}