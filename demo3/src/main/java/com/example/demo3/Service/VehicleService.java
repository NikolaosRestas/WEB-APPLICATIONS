package com.example.demo3.Service;

import com.example.demo3.Model.Vehicle;
import com.example.demo3.Repository.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepo;

    public VehicleService(VehicleRepository vehicleRepo){
        this.vehicleRepo = vehicleRepo;
    }

    public List<Vehicle> getAllVehicles(){
        return this.vehicleRepo.findAll();
    }

    public Optional<Vehicle> findVehicleById(Long id){
        return vehicleRepo.findById(id);
    }

    public boolean deleteVehicleById(Long id){
        try {
            vehicleRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertVehicle(Vehicle vehicle) {
        vehicleRepo.save(vehicle);
        return true;
    }
    public boolean updateVehicle(Vehicle vehicle) {
        try {
            vehicleRepo.save(vehicle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
