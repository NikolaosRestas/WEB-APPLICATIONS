package com.example.demo4.Service;

import com.example.demo4.Model.Staff;
import com.example.demo4.Repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return this.staffRepository.findAll();
    }

    public Staff findStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find staff with id: %s", id)));
    }

    public boolean deleteStaffById(Long id) {
        final int deletedCount = staffRepository.deleteStaffById(id);
        if (deletedCount <= 0) {
            throw new RuntimeException(String.format("Cannot find staff with id: %s", id));
        }
        return true;
    }

    public Staff insertStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Staff staff) {
        Staff savedStaff = findStaffById(staff.getId());
        savedStaff.setName(staff.getName());
        savedStaff.setSpecialty(staff.getSpecialty());
        savedStaff.setPhone(staff.getPhone());
        savedStaff.setGender(staff.getGender());
        savedStaff.setGym(staff.getGym());
        return staffRepository.save(savedStaff);
    }
}
