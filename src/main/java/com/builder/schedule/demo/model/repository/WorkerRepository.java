package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {

    @Query("select wrk from Worker wrk WHERE wrk.name like :name AND wrk.surname like :surname")
    Worker findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}
