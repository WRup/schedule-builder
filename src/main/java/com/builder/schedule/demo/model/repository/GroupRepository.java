package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Query("select gr from Group gr where gr.name = :name")
    Group findGroupByName(@Param("name") String name);
}
