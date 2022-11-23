package com.spring.testing.service;

import com.spring.testing.exception.CarNotFoundException;
import com.spring.testing.model.Car;
import com.spring.testing.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car getCarDetails(String name) {
        Car car = null;
        Optional<Car> optionalCar = carRepository.findByName(name);
        if(optionalCar.isPresent()){
            car = optionalCar.get();
        } else {
            throw new CarNotFoundException();
        }
        return car;
    }
}
