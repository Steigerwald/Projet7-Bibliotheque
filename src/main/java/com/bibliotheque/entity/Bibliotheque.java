package com.bibliotheque.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "TBL_BIBLIOTHEQUE")
@Data
public class Bibliotheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_BIBLIOTHEQUE")
    private int IdBibliotheque;

    @Column(name="NOM_BIBLIOTHEQUE")
    private String nomBibliotheque;

    @Column(name="LIEU")
    private String lieu;

    @Column(name="ADRESSE")
    private String adresse;


    // Constructeur
    public Bibliotheque() {
    }


    // getters
    public int getIdBibliotheque() {
        return IdBibliotheque;
    }

    public String getNomBibliotheque() {
        return nomBibliotheque;
    }

    public String getLieu() {
        return lieu;
    }

    public String getAdresse() {
        return adresse;
    }


    // setters
    public void setIdBibliotheque(int idBibliotheque) {
        IdBibliotheque = idBibliotheque;
    }

    public void setNomBibliotheque(String nomBibliotheque) {
        this.nomBibliotheque = nomBibliotheque;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
