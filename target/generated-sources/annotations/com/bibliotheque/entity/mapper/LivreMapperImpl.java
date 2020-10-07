package com.bibliotheque.entity.mapper;

import com.bibliotheque.entity.Livre;
import com.bibliotheque.entity.Reservation;
import com.bibliotheque.entity.Role;
import com.bibliotheque.entity.User;
import com.bibliotheque.entity.dto.LivreDTO;
import com.bibliotheque.entity.dto.ReservationDTO;
import com.bibliotheque.entity.dto.RoleDTO;
import com.bibliotheque.entity.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-07T02:19:01+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class LivreMapperImpl implements LivreMapper {

    @Override
    public Livre toEntity(LivreDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Livre livre = new Livre();

        livre.setIdLivre( dto.getIdLivre() );
        livre.setTitre( dto.getTitre() );
        livre.setAuteur( dto.getAuteur() );
        livre.setPublication( dto.getPublication() );
        livre.setResume( dto.getResume() );
        livre.setNombrePages( dto.getNombrePages() );
        livre.setNomCategorie( dto.getNomCategorie() );
        livre.setDateAchat( dto.getDateAchat() );
        livre.setPrixLocation( dto.getPrixLocation() );
        livre.setEtatLivre( dto.getEtatLivre() );
        livre.setDisponibilite( dto.getDisponibilite() );
        livre.setReservation( reservationDTOToReservation( dto.getReservation() ) );

        return livre;
    }

    @Override
    public LivreDTO toDto(Livre entity) {
        if ( entity == null ) {
            return null;
        }

        LivreDTO livreDTO = new LivreDTO();

        livreDTO.setIdLivre( entity.getIdLivre() );
        livreDTO.setTitre( entity.getTitre() );
        livreDTO.setAuteur( entity.getAuteur() );
        livreDTO.setPublication( entity.getPublication() );
        livreDTO.setResume( entity.getResume() );
        livreDTO.setNombrePages( entity.getNombrePages() );
        livreDTO.setNomCategorie( entity.getNomCategorie() );
        livreDTO.setDateAchat( entity.getDateAchat() );
        livreDTO.setPrixLocation( entity.getPrixLocation() );
        livreDTO.setEtatLivre( entity.getEtatLivre() );
        livreDTO.setDisponibilite( entity.getDisponibilite() );
        livreDTO.setReservation( reservationToReservationDTO( entity.getReservation() ) );

        return livreDTO;
    }

    @Override
    public List<Livre> toEntity(List<LivreDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Livre> list = new ArrayList<Livre>( dtoList.size() );
        for ( LivreDTO livreDTO : dtoList ) {
            list.add( toEntity( livreDTO ) );
        }

        return list;
    }

    @Override
    public List<LivreDTO> toDto(List<Livre> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LivreDTO> list = new ArrayList<LivreDTO>( entityList.size() );
        for ( Livre livre : entityList ) {
            list.add( toDto( livre ) );
        }

        return list;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setIdRole( roleDTO.getIdRole() );
        role.setNomRole( roleDTO.getNomRole() );
        role.setActifRole( roleDTO.getActifRole() );

        return role;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setIdUser( userDTO.getIdUser() );
        user.setNomUser( userDTO.getNomUser() );
        user.setPrenomUser( userDTO.getPrenomUser() );
        user.setMailUser( userDTO.getMailUser() );
        user.setMotDePasse( userDTO.getMotDePasse() );
        user.setActifUser( userDTO.getActifUser() );
        user.setRole( roleDTOToRole( userDTO.getRole() ) );

        return user;
    }

    protected Reservation reservationDTOToReservation(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setIdReservation( reservationDTO.getIdReservation() );
        reservation.setEtatReservation( reservationDTO.getEtatReservation() );
        reservation.setDateReservation( reservationDTO.getDateReservation() );
        reservation.setDateDeRetrait( reservationDTO.getDateDeRetrait() );
        reservation.setDelaiDeLocation( reservationDTO.getDelaiDeLocation() );
        reservation.setIsactif( reservationDTO.getIsactif() );
        reservation.setUser( userDTOToUser( reservationDTO.getUser() ) );

        return reservation;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setIdRole( role.getIdRole() );
        roleDTO.setNomRole( role.getNomRole() );
        roleDTO.setActifRole( role.getActifRole() );

        return roleDTO;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser( user.getIdUser() );
        userDTO.setNomUser( user.getNomUser() );
        userDTO.setPrenomUser( user.getPrenomUser() );
        userDTO.setMailUser( user.getMailUser() );
        userDTO.setMotDePasse( user.getMotDePasse() );
        userDTO.setActifUser( user.getActifUser() );
        userDTO.setRole( roleToRoleDTO( user.getRole() ) );

        return userDTO;
    }

    protected ReservationDTO reservationToReservationDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setIdReservation( reservation.getIdReservation() );
        reservationDTO.setEtatReservation( reservation.getEtatReservation() );
        reservationDTO.setDateReservation( reservation.getDateReservation() );
        reservationDTO.setDateDeRetrait( reservation.getDateDeRetrait() );
        reservationDTO.setDelaiDeLocation( reservation.getDelaiDeLocation() );
        reservationDTO.setIsactif( reservation.getIsactif() );
        reservationDTO.setUser( userToUserDTO( reservation.getUser() ) );

        return reservationDTO;
    }
}
