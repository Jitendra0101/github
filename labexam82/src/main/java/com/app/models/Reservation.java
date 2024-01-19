package com.app.models;

//Reservation.java
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String guestName;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	private double totalPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Reservation(Long id, String guestName, LocalDate checkInDate, LocalDate checkOutDate, Room room,
			double totalPrice) {
		super();
		this.id = id;
		this.guestName = guestName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", guestName=" + guestName + ", checkInDate=" + checkInDate + ", checkOutDate="
				+ checkOutDate + ", room=" + room + ", totalPrice=" + totalPrice + "]";
	}

	public Reservation() {
		super();
	}

}
