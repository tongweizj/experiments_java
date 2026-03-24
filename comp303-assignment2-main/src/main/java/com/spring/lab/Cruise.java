package com.spring.lab;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Cruise")
public class Cruise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cruise_id;

	@NotBlank(message = "Cruise name is required")
	private String cruise_name;

	private LocalTime departure_time;
	private LocalTime arrival_time;

	@NotBlank(message = "Origin port is required")
	private String origin;

	@NotBlank(message = "Destination is required")
	private String destination;

	@Positive(message = "Price must be greater than zero")
	private double price;

	@OneToMany(mappedBy = "cruise")
	private List<Booking> bookings;

	// Getters and Setters
	public int getCruise_id() {
		return cruise_id;
	}

	public void setCruise_id(int cruise_id) {
		this.cruise_id = cruise_id;
	}

	public String getCruise_name() {
		return cruise_name;
	}

	public void setCruise_name(String cruise_name) {
		this.cruise_name = cruise_name;
	}

	public LocalTime getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(LocalTime departure_time) {
		this.departure_time = departure_time;
	}

	public LocalTime getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(LocalTime arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
}