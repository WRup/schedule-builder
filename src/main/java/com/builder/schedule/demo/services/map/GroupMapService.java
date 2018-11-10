package com.builder.schedule.demo.services.map;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GroupMapService extends AbstractMapService<Group, Long> implements GroupService {
    @Override
    public Set<Group> findAll() {
        return super.findAll();
    }

    @Override
    public Group findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Group save(Group object) {
        return super.save(object);
    }

    @Override
    public void delete(Group object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
