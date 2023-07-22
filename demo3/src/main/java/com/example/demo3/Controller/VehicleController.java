package com.example.demo3.Controller;

import com.example.demo3.Model.Customer;
import com.example.demo3.Model.Vehicle;
import com.example.demo3.Service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {
    private final VehicleService vehicleservice;

    public VehicleController(VehicleService vehicleservice){
        this.vehicleservice = vehicleservice;
    }

    @GetMapping("/vehicle/index")
    public String getAllVehicles(Model model){
        model.addAttribute("vehicles", vehicleservice.getAllVehicles());
        return "vehicle/index";
    }

    @GetMapping("/vehicle/create")
    public String showCreateForm(Vehicle vehicle) {
        return "vehicle/create";
    }

    @PostMapping("/addVehicle")
    public String addUser(Vehicle vehicle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "vehicle/create";
        }
        vehicleservice.insertVehicle(vehicle);
        return "redirect:/vehicle/index";
    }

    @GetMapping("/vehicle/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Vehicle vehicle = vehicleservice.findVehicleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Vehicle Id:" + id));
        vehicleservice.deleteVehicleById(vehicle.getId());
        return "redirect:/vehicle/index";
    }

    @GetMapping("/vehicle/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
            Vehicle vehicle = vehicleservice.findVehicleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Vehicle Id:" + id));

        model.addAttribute("vehicle", vehicle);
        return "redirect:/vehicle/update";
    }

    @PostMapping("/vehicle/update/{id}")
    public String updateVehicle(@PathVariable("id") long id, Vehicle vehicle,
                                 BindingResult result, Model model){
        if (result.hasErrors()) {
            vehicle.setId(id);
            return "update-user";
        }
        vehicleservice.updateVehicle(vehicle);
        return "redirect:/vehicle/index";
    }

}
