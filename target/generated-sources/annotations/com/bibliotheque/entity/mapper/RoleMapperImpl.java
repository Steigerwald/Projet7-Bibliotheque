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
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setIdRole( dto.getIdRole() );
        role.setNomRole( dto.getNomRole() );
        role.setActifRole( dto.getActifRole() );
        role.setUsers( userDTOListToUserList( dto.getUsers() ) );

        return role;
    }

    @Override
    public RoleDTO toDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setIdRole( entity.getIdRole() );
        roleDTO.setNomRole( entity.getNomRole() );
        roleDTO.setActifRole( entity.getActifRole() );
        roleDTO.setUsers( userListToUserDTOList( entity.getUsers() ) );

        return roleDTO;
    }

    @Override
    public List<Role> toEntity(List<RoleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( dtoList.size() );
        for ( RoleDTO roleDTO : dtoList ) {
            list.add( toEntity( roleDTO ) );
        }

        return list;
    }

    @Override
    public List<RoleDTO> toDto(List<Role> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( entityList.size() );
        for ( Role role : entityList ) {
            list.add( toDto( role ) );
        }

        return list;
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
        reservation.setUser( userDTOToUser( reservationDTO.getUser() ) );
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
        user.setRole( toEntity( userDTO.getRole() ) );
        user.setReservations( reservationDTOListToReservationList( userDTO.getReservations() ) );

        return user;
    }

    protected List<User> userDTOListToUserList(List<UserDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( UserDTO userDTO : list ) {
            list1.add( userDTOToUser( userDTO ) );
        }

        return list1;
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
        reservationDTO.setUser( userToUserDTO( reservation.getUser() ) );
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
        userDTO.setRole( toDto( user.getRole() ) );
        userDTO.setReservations( reservationListToReservationDTOList( user.getReservations() ) );

        return userDTO;
    }

    protected List<UserDTO> userListToUserDTOList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserDTO> list1 = new ArrayList<UserDTO>( list.size() );
        for ( User user : list ) {
            list1.add( userToUserDTO( user ) );
        }

        return list1;
    }
}
