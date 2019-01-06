package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Building;
import com.builder.schedule.demo.model.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    @Override
    public Building findById(Long aLong) {
        return buildingRepository.findById(aLong).orElse(null);
    }

    @Override
    public Building save(Building object) {
        return buildingRepository.save(object);
    }

    @Override
    public void delete(Building object) {
        buildingRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        buildingRepository.deleteById(aLong);
    }
}
