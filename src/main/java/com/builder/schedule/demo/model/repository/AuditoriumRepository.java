package com.builder.schedule.demo.model.repository;

import com.builder.schedule.demo.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    @Query("select aud from Auditorium aud where aud.name = :name")
    Auditorium findByName(@Param("name") String name);

    @Query("select aud.id from Auditorium aud inner join Lecture l where l.endDate < :startDate or l.startDate > :endDate")
    List<Long> findOccupiedAuditoriums(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
