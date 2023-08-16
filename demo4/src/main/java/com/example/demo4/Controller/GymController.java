package com.example.demo4.Controller;

import com.example.demo4.Model.Gym;
import com.example.demo4.Model.dto.GymRequestDto;
import com.example.demo4.Service.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
@RequestMapping("/gyms")
public class GymController {
    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    public List<Gym> getGyms(@RequestParam(value = "countyId", required = false) Long countyId) {
        return gymService.getAllGyms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gym> getGym(@PathVariable("id") Long id) {
        return new ResponseEntity<>(gymService.findGymById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Gym> addGym(@RequestBody GymRequestDto gym) {
        final Gym createdGym = gymService.insertGym(gym);
        return new ResponseEntity<>(createdGym, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGym(@PathVariable("id") long id) {
        gymService.deleteGymById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gym> updateGym(@RequestBody GymRequestDto gym, @PathVariable("id") long id) {
        Gym updatedGym = gymService.updateGym(gym, id);
        return new ResponseEntity<>(updatedGym, HttpStatus.OK);
    }

}