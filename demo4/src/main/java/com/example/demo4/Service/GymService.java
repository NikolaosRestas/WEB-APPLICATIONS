package com.example.demo4.Service;

import com.example.demo4.Model.Gym;
import com.example.demo4.Repository.GymRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GymService {
    private final GymRepository gymRepository;

    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    public List<Gym> getAllGyms() {
        return this.gymRepository.findAll();
    }

    public Gym findGymById(Long id) {
        return gymRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find gym with id: %s", id)));
    }

    public boolean deleteGymById(Long id) {
        final int deletedCount = gymRepository.deleteGymById(id);
        if (deletedCount <= 0) {
            throw new RuntimeException(String.format("Cannot find gym with id: %s", id));
        }
        return true;
    }

    public Gym insertGym(Gym gym) {
        return gymRepository.save(gym);
    }

    public Gym updateGym(Gym gym) {
        Gym savedGym = findGymById(gym.getId());
        savedGym.setName(gym.getName());
        savedGym.setAddress(gym.getAddress());
        savedGym.setCounty(gym.getCounty());
        return gymRepository.save(savedGym);
    }
}