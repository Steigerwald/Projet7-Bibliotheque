package com.bibliotheque.entity.dto;

import lombok.Data;
import java.util.Date;

@Data
public class LivreDTO {
    public int idLivre;
    public String titre;
    public String auteur;
    public Date publication;
    public String resume;
    public String nombrePages;
    public String nomCategorie;
    public Date dateAchat;
    public int prixLocation;
    public String etatLivre;
    public Boolean disponibilite;

}
