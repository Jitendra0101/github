package com.app.models;

//Room.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String roomNumber;
	private String type;
	private double price;
	private boolean availability;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Room(Long id, String roomNumber, String type, double price, boolean availability) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.availability = availability;
	}

	public Room() {
		super();
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", type=" + type + ", price=" + price
				+ ", availability=" + availability + "]";
	}

	// getters, setters, etc.

}
