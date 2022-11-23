package com.spring.testing.repository;

import com.spring.testing.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{

    Optional<Car> findByName(String pulse);
}
