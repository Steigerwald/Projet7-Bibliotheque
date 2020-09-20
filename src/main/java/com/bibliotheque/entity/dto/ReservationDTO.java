package com.bibliotheque.entity.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ReservationDTO {

    public int idReservation;
    public String etatReservation;
    public Date dateReservation;
    public Date dateDeRetrait;
    public int delaiDeLocation;
    public Boolean isactif;
}
