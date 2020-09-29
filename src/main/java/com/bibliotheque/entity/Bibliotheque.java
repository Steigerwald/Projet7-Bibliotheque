package com.bibliotheque.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "TBL_BIBLIOTHEQUE")
@Data
public class Bibliotheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_BIBLIOTHEQUE")
    private int idBibliotheque;

    @Column(name="NOM_BIBLIOTHEQUE")
    private String nomBibliotheque;

    @Column(name="LIEU")
    private String lieu;

    @Column(name="ADRESSE")
    private String adresse;

    @OneToMany(mappedBy="bibliotheque",fetch=FetchType.LAZY,orphanRemoval=true)
    @Nullable
    private List<Livre> livres;
}
