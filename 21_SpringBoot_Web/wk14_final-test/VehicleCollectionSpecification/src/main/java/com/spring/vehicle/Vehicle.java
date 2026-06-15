package com.spring.vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(collection = "vehicle")
public class Vehicle {
	@Id
	private String id;
	
	@NotBlank(message = "Require vin number")
	private String vinNumber;
	
	@NotBlank(message = "Require brand")
	private String brand;
	
	@NotBlank(message = "Require model")
	private String model;
	
	@NotNull(message = "Require year")
	private int year;
	
	@NotNull(message = "Require price")
	private double price;
	
	@NotNull(message = "Require Add Date")
	private LocalDate addedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}
	
	

}
