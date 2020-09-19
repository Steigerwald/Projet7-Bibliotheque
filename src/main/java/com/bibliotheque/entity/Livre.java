package com.bibliotheque.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "TBL_LIVRE")
@Data
public class Livre {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="ID_LIVRE")
    private int idLivre;

    @Column(name="TITRE")
    private String titre;

    @Column(name="AUTEUR")
    private String auteur;

    @Column(name="PUBLICATION")
    private Date publication;

    @Column(name="RESUME")
    private String resume;

    @Column(name="NOMBRE_PAGES")
    private String nombrePages;

    @Column(name="NOM_CATEGORIE")
    private String nomCategorie;

    @Column(name="DATE_ACHAT")
    private Date dateAchat;

    @Column(name="PRIX_LOCATION")
    private int prixLocation;

    @Column(name="ETAT_LIVRE")
    private String etatLivre;

    @Column(name="DISPONIBILITE")
    private Boolean disponibilite;



    // Constructeur
    public Livre() {
    }

    // getters

    public int getIdLivre() {
        return idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public Date getPublication() {
        return publication;
    }

    public String getResume() {
        return resume;
    }

    public String getNombrePages() {
        return nombrePages;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public int getPrixLocation() {
        return prixLocation;
    }

    public String getEtatLivre() {
        return etatLivre;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

// setters


    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setNombrePages(String nombrePages) {
        this.nombrePages = nombrePages;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setPrixLocation(int prixLocation) {
        this.prixLocation = prixLocation;
    }

    public void setEtatLivre(String etatLivre) {
        this.etatLivre = etatLivre;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
}
