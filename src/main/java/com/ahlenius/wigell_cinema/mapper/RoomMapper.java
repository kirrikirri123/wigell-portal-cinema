package com.ahlenius.wigell_cinema.mapper;


import com.ahlenius.wigell_cinema.dto.customerDto.UpdateCustomerDto;
import com.ahlenius.wigell_cinema.dto.roomDto.CreateRoomDto;
import com.ahlenius.wigell_cinema.dto.roomDto.RoomResponse;
import com.ahlenius.wigell_cinema.dto.roomDto.UpdateRoomDto;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.model.Room;

public class RoomMapper {

    private RoomMapper() {
    }

    public static RoomResponse toDto(Room r) {
        return new RoomResponse(r.getId(), r.getName(), r.getMaxGuest(), r.getEquipment());
    }

    public static Room toEntity(CreateRoomDto dto) {
        return new Room(dto.name(), dto.maxGuest(), dto.equipment());
    }

    // skriver över objektet. Men vad händer om man vill behålla ett värde? sk amn ta det i beaktning.
    public static Room applyUpdate(Room r, UpdateRoomDto dto) {
        r.setName(dto.name());
        r.setMaxGuest(dto.maxGuest());
        r.setEquipment(dto.equipment());
        return r;
    }

}
