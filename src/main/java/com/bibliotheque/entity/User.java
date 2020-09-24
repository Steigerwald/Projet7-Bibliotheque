package com.bibliotheque.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

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

}
