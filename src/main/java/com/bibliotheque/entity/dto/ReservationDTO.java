package com.bibliotheque.entity.dto;

import com.bibliotheque.entity.Livre;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ReservationDTO {

    private int idReservation;
    private String etatReservation;
    private Date dateReservation;
    private Date dateDeRetrait;
    private Date dateDeRetour;
    private int delaiDeLocation;
    private Boolean prolongation;
    private Boolean isactif;
    private UserDTO user;
    private LivreDTO livre;
}
