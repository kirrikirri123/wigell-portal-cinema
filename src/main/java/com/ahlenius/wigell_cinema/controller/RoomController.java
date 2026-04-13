package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.roomDto.CreateRoomDto;
import com.ahlenius.wigell_cinema.dto.roomDto.RoomResponse;
import com.ahlenius.wigell_cinema.dto.roomDto.UpdateRoomDto;
import com.ahlenius.wigell_cinema.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService roomService) {
        this.service = roomService;
    }

    @GetMapping("/rooms")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<RoomResponse>> findAllRooms() {
        return ResponseEntity.ok(service.findAllRooms());
    }

    @GetMapping("rooms/{roomId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomResponse> findRoomById(@PathVariable("roomId") Long id) {
        RoomResponse found = service.findRoomById(id);
        return ResponseEntity.ok(found);
    }

    @PostMapping("/rooms")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomResponse> createRoom(@RequestBody @Valid CreateRoomDto dto) {
        var saved = service.saveRoom(dto);
        var uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.id().toString()).toUri();
        return ResponseEntity.created(uriLocation).body(saved);
    }

    @PutMapping("/rooms/{roomId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomResponse> updateRoom(@PathVariable("roomId") Long id, @RequestBody @Valid UpdateRoomDto dto) {
        RoomResponse updated = service.updateRoom(id, dto);
        return ResponseEntity.ok().body(updated);
    }

}
