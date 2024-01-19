package com.app.dao;

import java.util.List;

//RoomRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

 List<Room> findByAvailabilityTrue();
}
