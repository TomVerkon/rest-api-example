package com.baeldung.rae.web.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.rae.persistence.CarRepository;
import com.baeldung.rae.web.util.RestPreconditions;

@RestController
@RequestMapping("/api/car")
class CarController {

	private final CarRepository repo;

	CarController(CarRepository carRepository) {
		this.repo = carRepository;
	}

	@GetMapping
	public List<Car> findAll() {
		return repo.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Car save(Car car) {
		return repo.save(car);
	}

	@GetMapping(value = "/{id}")
	public Car findById(@PathVariable("id") Long id) {
		return repo.findCar(id);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCar(@PathVariable("id") Long id) {
		repo.deleteCar(id);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Car update(Car car) {
		RestPreconditions.checkFound(repo.findCar(car.getId()));
		return repo.save(car);
	}

}
