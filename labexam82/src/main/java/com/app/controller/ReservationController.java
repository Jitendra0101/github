package com.app.controller;

import java.util.List;

//ReservationController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Reservation;
import com.app.models.Room;
import com.app.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@PostMapping
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
		Reservation createdReservation = reservationService.createReservation(reservation);
		return ResponseEntity.ok(createdReservation);
	}

	
	@GetMapping("/rooms")
	public ResponseEntity<List<Room>> getAvailableRooms() {
		List<Room> availableRooms = reservationService.getAvailableRooms();
		return ResponseEntity.ok(availableRooms);
	}

	@DeleteMapping("/{reservationId}")
	public ResponseEntity<String> cancelReservation(@PathVariable Long reservationId) {
		String cancellationResult = reservationService.cancelReservation(reservationId);
		return ResponseEntity.ok(cancellationResult);
	}
}
