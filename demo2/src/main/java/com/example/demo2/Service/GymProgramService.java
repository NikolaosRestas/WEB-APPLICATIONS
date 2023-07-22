package com.example.demo2.Service;

import com.example.demo2.Model.Program;
import com.example.demo2.Repository.GymProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymProgramService {
    private final GymProgramRepository gymprogramRepo;

    public GymProgramService(GymProgramRepository gymprogramRepo){
        this.gymprogramRepo = gymprogramRepo;
    }

    public List<Program> getAllGymPrograms(){
        return this.gymprogramRepo.findAll();
    }

    public Optional<Program> findGymProgramById(Long id){
        return gymprogramRepo.findById(id);
    }

    public boolean deleteGymProgramById(Long id){
        try {
            gymprogramRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertGymProgram(Program program) {
        gymprogramRepo.save(program);
        return true;
    }
    public boolean updateGymProgram(Program program) {
        try {
            gymprogramRepo.save(program);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}