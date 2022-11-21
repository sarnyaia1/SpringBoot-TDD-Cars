package com.spring.testing.service;

import com.spring.testing.model.Car;
import com.spring.testing.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService implements CarRepository {

    @Override
    public Car getCarDetails(String name) {
        return null;
    }
}
