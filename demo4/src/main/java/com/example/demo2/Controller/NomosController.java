package com.example.demo2.Controller;

import com.example.demo2.Model.County;
import com.example.demo2.Service.NomosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class NomosController {
    private final NomosService nomosservice;

    public NomosController(NomosService nomosservice){
        this.nomosservice = nomosservice;
    }

    @GetMapping("/nomos/index")
    public String getAllNomos(Model model){
        model.addAttribute("nomoses", nomosservice.getAllNomos());
        return "nomos/index";
    }

    @GetMapping("/nomos/create")
    public String showCreateForm(County county) {
        return "nomos/create";
    }

    @PostMapping("/addNomos")
    public String addUser(County county, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "nomos/create";
        }
        nomosservice.insertNomos(county);
        return "redirect:/nomos/index";
    }

    @GetMapping("/nomos/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        County county = nomosservice.findNomoById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Nomos Id:" + id));
        nomosservice.deleteNomoById(county.getId());
        return "redirect:/nomos/index";
    }


    @GetMapping("/nomos/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        County county = nomosservice.findNomoById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Nomos Id:" + id));

        model.addAttribute("nomos", county);
        return "nomos/update";
    }

    @PostMapping("/nomos/update/{id}")
    public String updateNomos(@PathVariable("id") long id, County county,
                              BindingResult result, Model model){
        if (result.hasErrors()) {
            county.setId(id);
            return "update-user";
        }

        nomosservice.updateNomos(county);
        return "redirect:/nomos/index";
    }


}