package com.bibliotheque.entity.dto;


import com.bibliotheque.entity.Livre;
import com.bibliotheque.entity.User;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class ReservationDTO {

    private int idReservation;
    private String etatReservation;
    private Date dateReservation;
    private Date dateDeRetrait;
    private int delaiDeLocation;
    private Boolean isactif;
    private User user;
}
