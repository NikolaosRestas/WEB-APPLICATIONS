package com.example.demo4.Service;

import com.example.demo4.Model.Program;
import com.example.demo4.Repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymProgramService {
    private final ProgramRepository programRepository;

    public GymProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> getAllPrograms() {
        return this.programRepository.findAll();
    }

    public Program findProgramById(Long id) {
        return programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find program with id: %s", id)));
    }

    public boolean deleteProgramById(Long id) {
        final int deletedCount = programRepository.deleteProgramById(id);
        if (deletedCount <= 0) {
            throw new RuntimeException(String.format("Cannot find program with id: %s", id));
        }
        return true;
    }

    public Program insertProgram(Program program) {
        return programRepository.save(program);
    }

    public Program updateProgram(Program program) {
        Program savedProgram = findProgramById(program.getId());
        savedProgram.setDuration(program.getDuration());
        savedProgram.setPrice(program.getPrice());
        savedProgram.setCustomers(program.getCustomers());
        return programRepository.save(savedProgram);
    }
}