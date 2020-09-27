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
    date = "2020-09-27T23:39:27+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setIdUser( dto.getIdUser() );
        user.setNomUser( dto.getNomUser() );
        user.setPrenomUser( dto.getPrenomUser() );
        user.setMailUser( dto.getMailUser() );
        user.setMotDePasse( dto.getMotDePasse() );
        user.setActifUser( dto.getActifUser() );
        user.setRole( roleDTOToRole( dto.getRole() ) );
        user.setReservations( reservationDTOListToReservationList( dto.getReservations() ) );

        return user;
    }

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser( entity.getIdUser() );
        userDTO.setNomUser( entity.getNomUser() );
        userDTO.setPrenomUser( entity.getPrenomUser() );
        userDTO.setMailUser( entity.getMailUser() );
        userDTO.setMotDePasse( entity.getMotDePasse() );
        userDTO.setActifUser( entity.getActifUser() );
        userDTO.setRole( roleToRoleDTO( entity.getRole() ) );
        userDTO.setReservations( reservationListToReservationDTOList( entity.getReservations() ) );

        return userDTO;
    }

    @Override
    public List<User> toEntity(List<UserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserDTO userDTO : dtoList ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDto(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
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
        role.setUsers( toEntity( roleDTO.getUsers() ) );

        return role;
    }

    protected Livre livreDTOToLivre(LivreDTO livreDTO) {
        if ( livreDTO == null ) {
            return null;
        }

        Livre livre = new Livre();

        livre.setIdLivre( livreDTO.getIdLivre() );
        livre.setTitre( livreDTO.getTitre() );
        livre.setAuteur( livreDTO.getAuteur() );
        livre.setPublication( livreDTO.getPublication() );
        livre.setResume( livreDTO.getResume() );
        livre.setNombrePages( livreDTO.getNombrePages() );
        livre.setNomCategorie( livreDTO.getNomCategorie() );
        livre.setDateAchat( livreDTO.getDateAchat() );
        livre.setPrixLocation( livreDTO.getPrixLocation() );
        livre.setEtatLivre( livreDTO.getEtatLivre() );
        livre.setDisponibilite( livreDTO.getDisponibilite() );
        livre.setReservation( reservationDTOToReservation( livreDTO.getReservation() ) );

        return livre;
    }

    protected List<Livre> livreDTOListToLivreList(List<LivreDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Livre> list1 = new ArrayList<Livre>( list.size() );
        for ( LivreDTO livreDTO : list ) {
            list1.add( livreDTOToLivre( livreDTO ) );
        }

        return list1;
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
        reservation.setUser( toEntity( reservationDTO.getUser() ) );
        reservation.setLivres( livreDTOListToLivreList( reservationDTO.getLivres() ) );

        return reservation;
    }

    protected List<Reservation> reservationDTOListToReservationList(List<ReservationDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Reservation> list1 = new ArrayList<Reservation>( list.size() );
        for ( ReservationDTO reservationDTO : list ) {
            list1.add( reservationDTOToReservation( reservationDTO ) );
        }

        return list1;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setIdRole( role.getIdRole() );
        roleDTO.setNomRole( role.getNomRole() );
        roleDTO.setActifRole( role.getActifRole() );
        roleDTO.setUsers( toDto( role.getUsers() ) );

        return roleDTO;
    }

    protected LivreDTO livreToLivreDTO(Livre livre) {
        if ( livre == null ) {
            return null;
        }

        LivreDTO livreDTO = new LivreDTO();

        livreDTO.setIdLivre( livre.getIdLivre() );
        livreDTO.setTitre( livre.getTitre() );
        livreDTO.setAuteur( livre.getAuteur() );
        livreDTO.setPublication( livre.getPublication() );
        livreDTO.setResume( livre.getResume() );
        livreDTO.setNombrePages( livre.getNombrePages() );
        livreDTO.setNomCategorie( livre.getNomCategorie() );
        livreDTO.setDateAchat( livre.getDateAchat() );
        livreDTO.setPrixLocation( livre.getPrixLocation() );
        livreDTO.setEtatLivre( livre.getEtatLivre() );
        livreDTO.setDisponibilite( livre.getDisponibilite() );
        livreDTO.setReservation( reservationToReservationDTO( livre.getReservation() ) );

        return livreDTO;
    }

    protected List<LivreDTO> livreListToLivreDTOList(List<Livre> list) {
        if ( list == null ) {
            return null;
        }

        List<LivreDTO> list1 = new ArrayList<LivreDTO>( list.size() );
        for ( Livre livre : list ) {
            list1.add( livreToLivreDTO( livre ) );
        }

        return list1;
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
        reservationDTO.setUser( toDto( reservation.getUser() ) );
        reservationDTO.setLivres( livreListToLivreDTOList( reservation.getLivres() ) );

        return reservationDTO;
    }

    protected List<ReservationDTO> reservationListToReservationDTOList(List<Reservation> list) {
        if ( list == null ) {
            return null;
        }

        List<ReservationDTO> list1 = new ArrayList<ReservationDTO>( list.size() );
        for ( Reservation reservation : list ) {
            list1.add( reservationToReservationDTO( reservation ) );
        }

        return list1;
    }
}
