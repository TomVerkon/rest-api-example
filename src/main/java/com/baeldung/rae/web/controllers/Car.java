package com.baeldung.rae.web.controllers;

public class Car {

	private Long id;
	private String mfg;
	private String model;
	private String color;

	public Car(String mfg, String model, String color) {
		this.mfg = mfg;
		this.model = model;
		this.color = color;
	}

	public String getMfg() {
		return mfg;
	}

	public void setMfg(String mfg) {
		this.mfg = mfg;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
