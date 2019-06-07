package co.uk.jdreamer.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.uk.jdreamer.controller.ReservationService;
import co.uk.jdreamer.model.domain.RoomReservation;
import co.uk.jdreamer.model.entity.Guest;
import co.uk.jdreamer.model.entity.Room;
import co.uk.jdreamer.service.GuestRepository;
import co.uk.jdreamer.service.RoomRepository;

@RestController
@RequestMapping(value="/api/")
public class ReservationServiceController {

	@Autowired
    @Qualifier(value = "roomRepository")
    private RoomRepository roomRepository;
	
	@Autowired
    @Qualifier(value = "reservationService")
    private ReservationService reservationService;    
	
	@Autowired
    @Qualifier(value = "guestRepository")
    private GuestRepository guestRepository;
    
/*  @Autowired
    public ReservationServiceController(RoomRepository roomRepository, ReservationService reservationService) {
        this.roomRepository = roomRepository;
        this.reservationService = reservationService;
    } */
    
    @GetMapping("reservations/{date}")
    public List<RoomReservation> getAllReservationsForDate(@PathVariable(value="date") String dateString){
        return this.reservationService.getRoomReservationsForDate(dateString);
    }
    
    
    @GetMapping("roomrepository")
    public List<Room> getAllRoom(){
		return this.roomRepository.findAll();
    }
    
    @GetMapping("guest")
    public List<Guest> getAllGuests(){
		return (List<Guest>) this.guestRepository.findAll();
    }
}
