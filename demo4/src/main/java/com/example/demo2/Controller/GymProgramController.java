package com.example.demo2.Controller;

import com.example.demo2.Model.Program;
import com.example.demo2.Service.GymProgramService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GymProgramController {
        private final GymProgramService gymprogramservice;

        public GymProgramController(GymProgramService gymprogramservice){
            this.gymprogramservice = gymprogramservice;
        }

        @GetMapping("/program/index")
        public String getAllGymPrograms(Model model){
            model.addAttribute("programs", gymprogramservice.getAllGymPrograms());
            return "program/index";
        }

        @GetMapping("/program/create")
        public String showCreateForm(Program program) {
            return "program/create";
        }

        @PostMapping("/addProgram")
        public String addUser(Program program, BindingResult result, Model model) {
            if (result.hasErrors()) {
                return "program/create";
            }
            gymprogramservice.insertGymProgram(program);
            return "redirect:/program/index";
        }

        @GetMapping("/program/delete/{id}")
        public String deleteUser(@PathVariable("id") long id, Model model) {
            Program program = gymprogramservice.findGymProgramById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid GymProgram Id:" + id));
            gymprogramservice.deleteGymProgramById(program.getId());
            return "redirect:/program/index";
        }

        @GetMapping("/program/edit/{id}")
        public String showUpdateForm(@PathVariable("id") long id, Model model) {
            Program program = gymprogramservice.findGymProgramById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid GymProgram Id:" + id));

            model.addAttribute("program", program);
            return "program/update";
        }

        @PostMapping("/program/update/{id}")
        public String updateGymProgram(@PathVariable("id") long id, Program program,
                                BindingResult result, Model model){
            if (result.hasErrors()) {
                program.setId(id);
                return "update-user";
            }

            gymprogramservice.updateGymProgram(program);
            return "redirect:/program/index";
        }

}
