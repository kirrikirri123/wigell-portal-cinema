package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.roomDto.CreateRoomDto;
import com.ahlenius.wigell_cinema.dto.roomDto.RoomResponse;
import com.ahlenius.wigell_cinema.dto.roomDto.UpdateRoomDto;
import com.ahlenius.wigell_cinema.exception.NoRoomFoundException;
import com.ahlenius.wigell_cinema.mapper.RoomMapper;
import com.ahlenius.wigell_cinema.model.Room;
import com.ahlenius.wigell_cinema.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository repo;

    public RoomService(RoomRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public List<RoomResponse> findAllRooms() {
        return repo.findAll().stream()
                .map(RoomMapper::toDto)
                .toList();
    }
    @Transactional
    public RoomResponse findRoomById(Long id) {
        Room room = repo.findById(id).orElseThrow(()-> new NoRoomFoundException("id :"+ id));
        return RoomMapper.toDto(room);
    }

    @Transactional
    public RoomResponse saveRoom(CreateRoomDto dto) {
        Room room = repo.save(RoomMapper.toEntity(dto));
         return RoomMapper.toDto(room);
    }

    @Transactional
    public RoomResponse updateRoom(Long id, UpdateRoomDto dto) {
        Room room = repo.findById(id).orElseThrow(()-> new NoRoomFoundException("id :"+ id));
        RoomMapper.applyUpdate(room, dto);
        repo.save(room);
        return RoomMapper.toDto(room);
    }


}
