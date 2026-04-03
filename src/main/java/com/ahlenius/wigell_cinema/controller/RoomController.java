package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.roomDto.CreateRoomDto;
import com.ahlenius.wigell_cinema.dto.roomDto.RoomResponse;
import com.ahlenius.wigell_cinema.dto.roomDto.UpdateRoomDto;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

    @GetMapping("/rooms")
  //  @PreAuthorize("hasRole('ADMIN')")
    public List<RoomResponse> findAllRooms() {
        return null;
    }

    @GetMapping("rooms/{roomId}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomResponse> findRoomById(@PathVariable("roomId") Long id) {
        return null;
    }

    @PutMapping("/rooms")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomResponse> createRoom(@RequestBody CreateRoomDto dto) {
        return null;
    }

    @PutMapping("/rooms/{roomId}")
 //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomResponse> updateRoom(@PathVariable("roomId") Long id, @RequestBody UpdateRoomDto dto) {
        return null;
    }

}
