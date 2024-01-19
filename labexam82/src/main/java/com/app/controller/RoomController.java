package com.app.controller;

import java.util.List;

//RoomController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Room;
import com.app.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

 @Autowired
 private RoomService roomService;

 @GetMapping
 public ResponseEntity<List<Room>> getAvailableRooms() {
     List<Room> availableRooms = roomService.getAvailableRooms();
     return ResponseEntity.ok(availableRooms);
 }

 @PostMapping
 public ResponseEntity<Room> addRoom(@RequestBody Room room) {
     Room addedRoom = roomService.addRoom(room);
     return ResponseEntity.ok(addedRoom);
 }
}
