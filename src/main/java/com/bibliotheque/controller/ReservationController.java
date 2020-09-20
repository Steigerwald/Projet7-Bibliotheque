package com.bibliotheque.controller;

import com.bibliotheque.entity.Reservation;
import com.bibliotheque.entity.dto.ReservationDTO;
import com.bibliotheque.entity.mapper.ReservationMapper;
import com.bibliotheque.exception.RecordNotFoundException;
import com.bibliotheque.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationMapper reservationMapper;

    /* controller pour avoir toutes les reservations*/
    @RequestMapping("/")
    public List<Reservation> listOfReservations() {
        return reservationService.findAll();
    }

    /* controller pour obtenir une reservation */
    @RequestMapping("/{id}")
    public Reservation reservationId(@PathVariable int id) {
        return reservationService.findById(id);
    }

    /* controller pour ajouter une reservation */
    @RequestMapping(path = "/addReservation",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<ReservationDTO> newBReservation(@RequestBody ReservationDTO reservationDTO) throws RecordNotFoundException {
        System.out.println("reservation => " + reservationMapper.toEntity(reservationDTO));
        Reservation reservation =reservationService.createReservation(reservationMapper.toEntity(reservationDTO));
        return new ResponseEntity<>(reservationMapper.toDto(reservation), HttpStatus.OK);
    }

    /* controller pour modifier une reservation */
    @RequestMapping(path = "/updateReservation",method = RequestMethod.PUT,produces = "application/json")
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationDTO reservationModifieDTO) throws RecordNotFoundException {
        Reservation reservationModifie = reservationMapper.toEntity(reservationModifieDTO);
        Reservation reservation=reservationService.updateReservation(reservationModifie);
        ReservationDTO dto = reservationMapper.toDto(reservation);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /* controller pour effacer une reservation de la base de données */
    @RequestMapping(path = "/deleteReservation/{id}",method = RequestMethod.DELETE)
    public void deleteReservationById(Model model, @PathVariable("id") int id) throws RecordNotFoundException{
       reservationService.deleteReservationById(id);
    }

    /* controller pour annuler une reservation */
    @RequestMapping(path = "/annulerReservation",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<ReservationDTO> annulerReservation(@RequestBody ReservationDTO reservationAnnuleeDTO) throws RecordNotFoundException {
        Reservation reservationAnnulee = reservationMapper.toEntity(reservationAnnuleeDTO);
        ReservationDTO dto = reservationMapper.toDto(reservationService.annulerReservation(reservationAnnulee));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
