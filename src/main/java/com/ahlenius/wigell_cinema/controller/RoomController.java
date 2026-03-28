package com.ahlenius.wigell_cinema.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

    @GetMapping("/rooms")
    @PreAuthorize("hasRole('ADMIN')")
    public List<RoomDto> findAllRooms() {
        return null;
        //Lista lokaler
    }

    @GetMapping("rooms/{roomId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<RoomDto> findRoomById(@PathVariable("roomId") Long id) {
        return null;
//Hämta lokal GET /api/v1/rooms/{roomId}
    }

    @PutMapping("/rooms")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<RoomDto> createRoom(@RequestBody CreateRoomDto dto) {
        return null;
        //Lägg till lokal POST /api/v1/rooms
    }

    @PutMapping("/rooms/{roomId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<RoomDto> updateRoom(@PathVariable("roomId") Long id, @RequestBody UpdateRoomDto dto) {
        return null;
//  Uppdatera lokal PUT /api/v1/rooms/{roomId}
    }

}
