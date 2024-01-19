package com.app.service;

import java.util.List;

//RoomService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RoomRepository;
import com.app.models.Room;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	public List<Room> getAvailableRooms() {
		return roomRepository.findByAvailabilityTrue();
	}

	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}
}
