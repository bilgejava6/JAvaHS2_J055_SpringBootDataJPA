package com.muhammet.jpa.repository;

import com.muhammet.jpa.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findAllByModel(String model);
    List<Car> findAllByModelLike(String model);
    List<Car> findAllByYear(int year);
    List<Car> findAllByYearLessThan(int year);
    List<Car> findAllByYearGreaterThan(int year);
    List<Car> findAllByFuelType(Integer fuelType);
    List<Car> findAllByIsAvaliableTrue();
    List<Car> findAllByIsAvaliableFalse();
    List<Car> findAllByPriceBetween(Double min, Double max);
    List<Car> findAllByModelAndFuelType(String model,Integer fuelType);
    List<Car> findAllByModelNotLike(String model); // %a%


}
