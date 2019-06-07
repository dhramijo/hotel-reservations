package co.uk.jdreamer.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.uk.jdreamer.controller.ReservationService;
import co.uk.jdreamer.model.domain.RoomReservation;

@Controller
@RequestMapping(value="/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String getReservations(@RequestParam(value="date", required=false)String dateString, Model model){
        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsForDate(dateString);
        model.addAttribute("roomReservations", roomReservationList);
        return "reservations";
    }
}
