package com.example.demo2.Controller;

import com.example.demo2.Model.Staff;
import com.example.demo2.Service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StaffController {
    private final StaffService staffservice;

    public StaffController(StaffService staffservice){
        this.staffservice = staffservice;
    }

    @GetMapping("/staff/index")
    public String getAllStaff(Model model){
        model.addAttribute("staffs", staffservice.getAllStaff());
        return "staff/index";
    }
    @GetMapping("/staff/create")
    public String showCreateForm(Staff staff) {
        return "staff/create";
    }

    @PostMapping("/addStaff")
    public String addStaff(Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "staff/create";
        }
        staffservice.insertStaff(staff);
        return "redirect:/staff/index";
    }

    @GetMapping("/staff/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Staff staff = staffservice.findStaffById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        staffservice.deleteStaffById(id);
        return "redirect:/staff/index";
    }

    @GetMapping("/staff/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Staff staff = staffservice.findStaffById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));

        model.addAttribute("staff", staff);
        return "staff/update";
    }

    @PostMapping("/staff/update/{id}")
    public String updateStaff(@PathVariable("id") long id, Staff staff,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            staff.setId(id);
            return "update-user";
        }
        staffservice.updateStaff(staff);
        return "redirect:/staff/index";
    }


}
