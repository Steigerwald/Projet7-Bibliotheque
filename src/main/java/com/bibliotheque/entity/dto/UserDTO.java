package com.bibliotheque.entity.dto;


import com.bibliotheque.entity.Reservation;
import com.bibliotheque.entity.Role;
import lombok.Data;

import java.util.Collection;

@Data
public class UserDTO {
    private int idUser;
    private String nomUser;
    private String prenomUser;
    private String mailUser;
    private String motDePasse;
    private Boolean actifUser;
    private Role role;
}
