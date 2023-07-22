package com.example.demo2.Service;

import com.example.demo2.Model.Staff;
import com.example.demo2.Repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    private final StaffRepository staffRepo;

    public StaffService(StaffRepository staffRepo){
        this.staffRepo = staffRepo;
    }
    public List<Staff> getAllStaff(){
        return staffRepo.findAll();
    }
    public Optional <Staff> findStaffById(Long id){
        return staffRepo.findById(id);
    }

    public boolean deleteStaffById(Long id){
        try{
            staffRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertStaff(Staff staff) {
        staffRepo.save(staff);
        return true;
    }
    public boolean updateStaff(Staff staff) {
        try {
            staffRepo.save(staff);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
