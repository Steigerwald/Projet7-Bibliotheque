package com.bibliotheque.entity.dto;


import lombok.Data;
import java.util.Date;

@Data
public class ReservationDTO {

    private int idReservation;
    private String etatReservation;
    private Date dateReservation;
    private Date dateDeRetrait;
    private int delaiDeLocation;
    private Boolean isactif;
    private UserDTO user;
}
