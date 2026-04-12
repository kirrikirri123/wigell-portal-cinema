package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.roomDto.CreateRoomDto;
import com.ahlenius.wigell_cinema.dto.roomDto.RoomResponse;
import com.ahlenius.wigell_cinema.dto.roomDto.UpdateRoomDto;
import com.ahlenius.wigell_cinema.exception.NoRoomFoundException;
import com.ahlenius.wigell_cinema.mapper.RoomMapper;
import com.ahlenius.wigell_cinema.model.Room;
import com.ahlenius.wigell_cinema.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomService {

    private static final Logger log = LoggerFactory.getLogger(RoomService.class);
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
        log.info("Lokal skapad med ID: {} ", room.getId());
         return RoomMapper.toDto(room);
    }

    @Transactional
    public RoomResponse updateRoom(Long id, UpdateRoomDto dto) {
        Room room = repo.findById(id).orElseThrow(()-> new NoRoomFoundException("id :"+ id));
        RoomMapper.applyUpdate(room, dto);
        repo.save(room);
        log.info("Lokal med ID: {} är uppdaterad.", id);
        return RoomMapper.toDto(room);
    }


}
