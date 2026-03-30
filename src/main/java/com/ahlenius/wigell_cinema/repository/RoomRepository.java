package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
