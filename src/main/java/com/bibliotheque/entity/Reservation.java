package com.bibliotheque.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Collection;
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

    @ManyToOne(cascade = {CascadeType.ALL})
    private User user;

    @OneToMany(mappedBy = "reservation",fetch=FetchType.LAZY,orphanRemoval=true)
    private Collection<Livre> livres;

    // Constructeur

    public Reservation() {
    }

}
