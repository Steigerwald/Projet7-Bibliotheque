package com.bibliotheque.entity.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private int idUser;
    private String nomUser;
    private String prenomUser;
    private String mailUser;
    private String motDePasse;
    private Boolean actifUser;
    private RoleDTO role;
}
