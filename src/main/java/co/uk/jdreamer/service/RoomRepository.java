package co.uk.jdreamer.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.uk.jdreamer.model.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    Room findByRoomNumber(String roomNumber);
}
