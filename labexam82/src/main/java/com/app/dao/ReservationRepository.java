package com.app.dao;

import java.time.LocalDate;
import java.util.Optional;

//ReservationRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Reservation;
import com.app.models.Room;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

 Optional<Reservation> findByRoomAndCheckInDateBetweenOrRoomAndCheckOutDateBetween(
         Room room,
         LocalDate checkInDate,
         LocalDate checkOutDate,
         Room otherRoom,
         LocalDate otherCheckInDate,
         LocalDate otherCheckOutDate
 );
}
