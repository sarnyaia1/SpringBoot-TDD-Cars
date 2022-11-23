package com.spring.testing.controller;

import com.spring.testing.model.Car;
import com.spring.testing.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/{name}")
    public ResponseEntity<Car> getCarDetails(@PathVariable String name) throws Exception {
        Car car = carService.getCarDetails(name);
        return new ResponseEntity<>( car,HttpStatus.OK);
    }

}
