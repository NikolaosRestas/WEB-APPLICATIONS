package com.example.demo2.Service;

import com.example.demo2.Model.Gym;
import com.example.demo2.Repository.GymRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GymService {
    private final GymRepository gymRepo;

    public GymService(GymRepository gymRepo){
        this.gymRepo = gymRepo;
    }

    public List<Gym> getAllGyms(){
        return this.gymRepo.findAll();
    }

    public Optional<Gym> findGymById(Long id){
        return gymRepo.findById(id);
    }

    public boolean deleteGymById(Long id){
        try {
            gymRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertGym(Gym gym) {
        gymRepo.save(gym);
        return true;
    }
    public boolean updateGym(Gym gym) {
        try {
            gymRepo.save(gym);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}