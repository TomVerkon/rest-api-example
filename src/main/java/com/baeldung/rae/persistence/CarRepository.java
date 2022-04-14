package com.baeldung.rae.persistence;

import java.util.List;

import com.baeldung.rae.web.controllers.Car;

public interface CarRepository {

	List<Car> findAll();

	Car save(Car car);

	Car findCar(Long id);

	void deleteCar(Long id);
	
	Car update(Car car);
	
}
