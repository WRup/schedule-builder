package com.builder.schedule.demo.model.repository;

import com.builder.schedule.demo.model.Auditorium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends CrudRepository<Auditorium, Long> {

}
