package com.example.demo2.Service;

import com.example.demo2.Model.Nomos;
import com.example.demo2.Repository.NomosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomosService {
    private final NomosRepository nomosRepo;

    public NomosService(NomosRepository nomosRepo){
        this.nomosRepo = nomosRepo;
    }

    public List<Nomos> getAllNomos(){
        return this.nomosRepo.findAll();
    }

    public Optional<Nomos> findNomoById(Long id){
        return nomosRepo.findById(id);
    }

    public boolean deleteNomoById(Long id){
        try {
            nomosRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertNomos(Nomos nomos) {
        nomosRepo.save(nomos);
        return true;
    }
    public boolean updateNomos(Nomos nomos) {
        try {
            nomosRepo.save(nomos);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}