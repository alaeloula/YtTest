package com.example.yttest.service.impl;

import com.example.yttest.dto.CarDtoReq;
import com.example.yttest.dto.CarDtoRes;
import com.example.yttest.entity.Car;
import com.example.yttest.repository.CarRepository;
import com.example.yttest.service.interfaces.ICar;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICar {
    private final CarRepository carRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CarService(CarRepository ucarRepository) {
        this.carRepository = ucarRepository;
    }


    @Override
    public List<CarDtoRes> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDtoRes findById(Integer id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return convertToDto(car);
    }

    @Override
    public CarDtoRes createUser(CarDtoReq carCreateDto) {
        Car car = convertToEntity(carCreateDto);
        Car savedCar = carRepository.save(car);
        return convertToDto(savedCar);
    }

    @Override
    public long count() {
        return carRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }

    private CarDtoRes convertToDto(Car car) {
        return modelMapper.map(car, CarDtoRes.class);
    }

    private Car convertToEntity(CarDtoReq carDtoReq) {
        return modelMapper.map(carDtoReq, Car.class);
    }
}
