package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Year;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends CrudRepository<Year, Long> {
}
