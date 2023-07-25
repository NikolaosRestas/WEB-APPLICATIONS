package com.example.demo2.Controller;


import com.example.demo2.Model.Gym;
import com.example.demo2.Service.GymService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class GymController {
    private final GymService gymservice;

    public GymController(GymService gymservice){
        this.gymservice = gymservice;
    }

    @GetMapping("/gym/index")
    public String getAllGyms(Model model){
        model.addAttribute("gyms", gymservice.getAllGyms());
        return "gym/index";
    }

    @GetMapping("/gym/create")
    public String showCreateForm(Gym gym) {
        return "gym/create";
    }

    @PostMapping("/addGym")
    public String addUser(Gym gym, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "gym/create";
        }
        gymservice.insertGym(gym);
        return "redirect:/gym/index";
    }

    @GetMapping("/gym/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Gym gym = gymservice.findGymById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Gym Id:" + id));
        gymservice.deleteGymById(gym.getId());
        return "redirect:/gym/index";
    }

    @GetMapping("/gym/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Gym gym = gymservice.findGymById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Gym Id:" + id));

        model.addAttribute("gym", gym);
        return "gym/update";
    }

    @PostMapping("/gym/update/{id}")
    public String updateGym(@PathVariable("id") long id, Gym gym,
                              BindingResult result, Model model){
        if (result.hasErrors()) {
            gym.setId(id);
            return "update-user";
        }

        gymservice.updateGym(gym);
        return "redirect:/gym/index";
    }

}