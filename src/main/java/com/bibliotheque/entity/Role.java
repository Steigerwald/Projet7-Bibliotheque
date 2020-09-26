package com.bibliotheque.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Collection;


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

    @OneToMany(mappedBy = "role",fetch=FetchType.LAZY,orphanRemoval = true)
    @Nullable
    private Collection<User> users;

}
