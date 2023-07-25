package com.example.demo2.Service;

import com.example.demo2.Model.County;
import com.example.demo2.Repository.CountyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomosService {
    private final CountyRepository nomosRepo;

    public NomosService(CountyRepository nomosRepo){
        this.nomosRepo = nomosRepo;
    }

    public List<County> getAllNomos(){
        return this.nomosRepo.findAll();
    }

    public Optional<County> findNomoById(Long id){
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

    public boolean insertNomos(County county) {
        nomosRepo.save(county);
        return true;
    }
    public boolean updateNomos(County county) {
        try {
            nomosRepo.save(county);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}