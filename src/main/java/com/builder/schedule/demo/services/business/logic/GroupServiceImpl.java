package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long aLong) {
        return groupRepository.findById(aLong).orElse(null);
    }

    @Override
    public Group save(Group object) {
        return groupRepository.save(object);
    }

    @Override
    public void delete(Group object) {
        groupRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        groupRepository.deleteById(aLong);
    }
}
