package com.bibliotheque.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "tbl_livre")
@Data
public class Livre {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    public String title;
    public String author;
    public Date publication;
    public String resume;
}
