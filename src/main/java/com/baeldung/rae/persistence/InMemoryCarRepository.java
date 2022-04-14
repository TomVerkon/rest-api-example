package com.baeldung.rae.persistence;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.baeldung.rae.web.controllers.Car;

public class InMemoryCarRepository implements CarRepository {

	private static AtomicLong counter = new AtomicLong();

	private final ConcurrentMap<Long, Car> cars = new ConcurrentHashMap<Long, Car>();

	@Override
	public List<Car> findAll() {
		return this.cars.values().stream().collect(Collectors.toList());
	}

	@Override
	public Car save(Car car) {
		Long id = car.getId();
		if (id == null) {
			id = counter.incrementAndGet();
			car.setId(id);
		}
		this.cars.put(id, car);
		return car;

	}

	@Override
	public Car findCar(Long id) {
		return cars.get(id);
	}

	@Override
	public void deleteCar(Long id) {
		cars.remove(id);
	}

	@Override
	public Car update(Car car) {
		Long id = car.getId();
		if (id == null) {
			return null;
		} else {
			this.cars.put(id, car);
		}
		return car;

	}

}
