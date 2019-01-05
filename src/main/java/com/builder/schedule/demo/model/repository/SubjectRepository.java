package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

    @Override
    Set<Subject> findAll();

    @Query("select sub from Subject sub where sub.name = :name and sub.type = :type")
    Subject findByNameAndType(@Param("name") String name, @Param("type") String type);

}
