package com.example.demo4.Controller;

import com.example.demo4.Model.Gym;
import com.example.demo4.Service.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {
    private final GymService gymService;

    public GymController(GymService gymService){
        this.gymService = gymService;
    }

    @GetMapping
    public List<Gym> getGyms(GymService gymservice){
        return gymservice.getAllGyms();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Gym> getGym(@PathVariable("id") Long id) {
        return new ResponseEntity<>(gymService.findGymById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Gym> addGym(@RequestBody Gym gym) {
        final Gym createdGym = gymService.insertGym(gym);
        return new ResponseEntity<>(createdGym, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGym(@PathVariable("id") long id) {
        gymService.deleteGymById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gym> updateGym(@RequestBody Gym gym) {
        Gym updatedGym = gymService.updateGym(gym);
        return new ResponseEntity<>(updatedGym, HttpStatus.OK);

    }
}