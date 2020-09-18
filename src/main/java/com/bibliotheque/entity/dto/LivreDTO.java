package com.bibliotheque.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LivreDTO {
    private int id;
    public String title;
    public String author;
    public Date publication;
    public String resume;
}
