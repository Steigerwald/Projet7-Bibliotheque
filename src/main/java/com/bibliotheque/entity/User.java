package com.bibliotheque.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "TBL_USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_USER")
    private int idUser;

    @Column(name="NOM_USER")
    @NotNull
    private String nomUser;

    @Column(name="PRENOM_USER")
    @NotNull
    private String prenomUser;

    @Column(nullable=false, unique=true,name="MAIL_USER")
    @NotNull
    private String mailUser;

    @Column(name="MOT_PASSE")
    @NotNull
    private String motDePasse;

    @Column(name="ACTIF_USER")
    private Boolean actifUser;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy="user",fetch=FetchType.LAZY,orphanRemoval=true)
    @Nullable
    private Collection<Reservation> reservations;


}
