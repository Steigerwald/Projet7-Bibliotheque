package com.bibliotheque.entity.dto;

import lombok.Data;

@Data
public class BibliothequeDTO {

    private int idBibliotheque;
    private String nomBibliotheque;
    private String lieu;
    private String adresse;
}
