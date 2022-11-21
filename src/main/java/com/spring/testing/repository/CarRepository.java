package com.spring.testing.repository;

import com.spring.testing.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository {

    Car getCarDetails(String name);
}
