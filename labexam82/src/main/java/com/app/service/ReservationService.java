package com.app.service;

import java.util.List;

//ReservationService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ReservationRepository;
import com.app.dao.RoomRepository;
import com.app.models.Reservation;
import com.app.models.Room;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private RoomRepository roomRepository;
	

	public Reservation createReservation(Reservation reservation) {
		// Check if the room is available for the specified dates
		if (isRoomAvailable(reservation)) {
			Room room = reservation.getRoom();
			room.setAvailability(false); // Set room as unavailable
			roomRepository.save(room);

			return reservationRepository.save(reservation);
		} else {
			throw new IllegalArgumentException("Room not available for the specified dates");
		}
	}

	public List<Room> getAvailableRooms() {
		return roomRepository.findByAvailabilityTrue();
	}

	public String cancelReservation(Long reservationId) {
		reservationRepository.findById(reservationId).ifPresent(reservation -> {
			Room room = reservation.getRoom();
			room.setAvailability(true); // Set room as available
			roomRepository.save(room);

			reservationRepository.delete(reservation);
		});

		return "Reservation canceled successfully!";
	}

	private boolean isRoomAvailable(Reservation newReservation) {
		return reservationRepository.findByRoomAndCheckInDateBetweenOrRoomAndCheckOutDateBetween(
				newReservation.getRoom(), newReservation.getCheckInDate(), newReservation.getCheckOutDate(),
				newReservation.getRoom(), newReservation.getCheckInDate(), newReservation.getCheckOutDate()).isEmpty();
	}
}
