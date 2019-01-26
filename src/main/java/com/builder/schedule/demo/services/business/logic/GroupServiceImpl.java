package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        Optional<Long> opt = Optional.ofNullable(aLong);
        if(opt.isPresent()) {
            return groupRepository.findById(aLong).orElse(null);
        } else {
            return null;
        }
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
