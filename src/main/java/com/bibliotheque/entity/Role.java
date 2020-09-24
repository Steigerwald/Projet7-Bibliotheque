package com.bibliotheque.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table (name = "TBL_ROLE")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ROLE")
    private int idRole;

    @Column(name="NOM_ROLE")
    private String nomRole;

    @Column(name="ACTIF_ROLE")
    private Boolean actifRole;
}
