package com.example.demo4.Service;

import com.example.demo4.Model.County;
import com.example.demo4.Repository.CountyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    private final CountyRepository countyRepository;

    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public List<County> getAllCounties() {
        return this.countyRepository.findAll();
    }

    public County findCountyById(Long id) {
        return countyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find county with id: %s", id)));
    }

    public boolean deleteCountyById(Long id) {
        final int deletedCount = countyRepository.deleteCountyById(id);
        if (deletedCount <= 0) {
            throw new RuntimeException(String.format("Cannot find county with id: %s", id));
        }
        return true;
    }

    public County insertCounty(County county) {
        return countyRepository.save(county);
    }

    public County updateCounty(County county) {
        County savedCounty = findCountyById(county.getId());
        savedCounty.setName(county.getName());
        return countyRepository.save(savedCounty);
    }
}