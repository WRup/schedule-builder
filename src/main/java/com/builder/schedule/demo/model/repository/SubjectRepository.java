package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {


    @Query("select sub from Subject sub where sub.name = :name and sub.type = :type")
    Subject findByNameAndType(@Param("name") String name, @Param("type") String type);

}
