package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends JpaRepository<Year, Long> {
}
