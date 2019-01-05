package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Building;
import com.builder.schedule.demo.model.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service

public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }


    @Override
    public Set<Building> findAll() {
        return null;
    }

    @Override
    public Building findById(Long aLong) {
        return null;
    }

    @Override
    public Building save(Building object) {
        return null;
    }

    @Override
    public void delete(Building object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
