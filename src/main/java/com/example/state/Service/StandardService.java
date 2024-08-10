package com.example.state.Service;

import com.example.state.Model.Standard;
import com.example.state.Repository.StandardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandardService {
    private final StandardRepository standardRepository;

    public StandardService(StandardRepository standardRepository) {
        this.standardRepository = standardRepository;
    }

    public Standard addStandard(Standard standard) {
        return standardRepository.save(standard);
    }

    public List<Standard> getAllStandards() {
        return standardRepository.findAll();
    }

    public Standard updateStandard(int id, Standard standard) {
        // Fetch existing standard by id
        Standard existingStandard = standardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Standard not found"));

        // Update the fields of the existing standard
        existingStandard.setName(standard.getName());
        existingStandard.setMonitorName(standard.getMonitorName());
        existingStandard.setNumberOfStudents(standard.getNumberOfStudents());
        existingStandard.setNumberOfTeachers(standard.getNumberOfTeachers());

        // Save and return the updated standard
        return standardRepository.save(existingStandard);
    }

    public boolean deleteStandard(int id) {
        if (standardRepository.existsById(id)) {
            standardRepository.deleteById(id);
            return true;
        }
        return false;
    }
}