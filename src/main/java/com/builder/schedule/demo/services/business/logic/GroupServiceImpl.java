package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Set<Group> findAll() {
        return null;
    }

    @Override
    public Group findById(Long aLong) {
        return null;
    }

    @Override
    public Group save(Group object) {
        return null;
    }

    @Override
    public void delete(Group object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
