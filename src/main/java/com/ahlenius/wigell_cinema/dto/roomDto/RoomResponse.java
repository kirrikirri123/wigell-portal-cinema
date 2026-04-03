package com.ahlenius.wigell_cinema.dto.roomDto;

public record RoomResponse(
        Long id,
        String name,
        int maxGuest,
        String equipment) {
}
