package com.example.yttest.controller;

import com.example.yttest.dto.CarDtoReq;
import com.example.yttest.dto.CarDtoRes;
import com.example.yttest.service.interfaces.ICar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/cars")
    public class CarController {

        @Autowired
        private ICar carService;

        @GetMapping
        public List<CarDtoRes> getAllCars() {
            return carService.findAll();
        }

        @GetMapping("/{id}")
        public CarDtoRes getCarById(@PathVariable Integer id) {
            return carService.findById(id);
        }

        @PostMapping
        public CarDtoRes createCar(@RequestBody CarDtoReq carDtoReq) {
            return carService.createUser(carDtoReq);
        }

        @DeleteMapping("/{id}")
        public void deleteCar(@PathVariable Integer id) {
            carService.deleteById(id);
        }


}
