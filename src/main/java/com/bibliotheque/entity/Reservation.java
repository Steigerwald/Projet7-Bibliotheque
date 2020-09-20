package com.bibliotheque.entity;


import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_RESERVATION")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RESERVATION")
    private int idReservation;

    @Column(name="ETAT_RESERVATION")
    private String etatReservation;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name="DATE_RESERVATION")
    private Date dateReservation;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name="DATE_RETRAIT")
    @Nullable
    private Date dateDeRetrait;

    @Column(name="DELAI_LOCATION")
    private int delaiDeLocation;

    @Column(name="ISACTIF")
    private Boolean isactif;

    // Constructeur

    public Reservation() {
    }

    // Getters
    public int getIdReservation() {
        return idReservation;
    }

    public String getEtatReservation() {
        return etatReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    @Nullable
    public Date getDateDeRetrait() {
        return dateDeRetrait;
    }

    public int getDelaiDeLocation() {
        return delaiDeLocation;
    }

    public Boolean getIsactif() {
        return isactif;
    }

    // Setters
    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setEtatReservation(String etatReservation) {
        this.etatReservation = etatReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setDateDeRetrait(@Nullable Date dateDeRetrait) {
        this.dateDeRetrait = dateDeRetrait;
    }

    public void setDelaiDeLocation(int delaiDeLocation) {
        this.delaiDeLocation = delaiDeLocation;
    }

    public void setIsactif(Boolean isactif) {
        this.isactif = isactif;
    }
}
