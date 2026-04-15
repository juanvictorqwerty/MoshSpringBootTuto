package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepo softwareEngineerRepo;

    public SoftwareEngineerService(SoftwareEngineerRepo softwareEngineerRepo) {
        this.softwareEngineerRepo = softwareEngineerRepo;
    }

    public List<SoftareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepo.findAll();
    }

    public void addSoftwareEngineer(SoftareEngineer softareEngineer) {
        softwareEngineerRepo.save(softareEngineer);
    }

    public void deleteSoftwareEngineer(Integer id) {
        softwareEngineerRepo.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id, SoftareEngineer softareEngineer) {
        softwareEngineerRepo.save(softareEngineer);
    }
}
