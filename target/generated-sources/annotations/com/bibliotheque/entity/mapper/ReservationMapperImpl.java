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
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public Reservation toEntity(ReservationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setIdReservation( dto.getIdReservation() );
        reservation.setEtatReservation( dto.getEtatReservation() );
        reservation.setDateReservation( dto.getDateReservation() );
        reservation.setDateDeRetrait( dto.getDateDeRetrait() );
        reservation.setDelaiDeLocation( dto.getDelaiDeLocation() );
        reservation.setIsactif( dto.getIsactif() );
        reservation.setUser( userDTOToUser( dto.getUser() ) );
        reservation.setLivres( livreDTOListToLivreList( dto.getLivres() ) );

        return reservation;
    }

    @Override
    public ReservationDTO toDto(Reservation entity) {
        if ( entity == null ) {
            return null;
        }

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setIdReservation( entity.getIdReservation() );
        reservationDTO.setEtatReservation( entity.getEtatReservation() );
        reservationDTO.setDateReservation( entity.getDateReservation() );
        reservationDTO.setDateDeRetrait( entity.getDateDeRetrait() );
        reservationDTO.setDelaiDeLocation( entity.getDelaiDeLocation() );
        reservationDTO.setIsactif( entity.getIsactif() );
        reservationDTO.setUser( userToUserDTO( entity.getUser() ) );
        reservationDTO.setLivres( livreListToLivreDTOList( entity.getLivres() ) );

        return reservationDTO;
    }

    @Override
    public List<Reservation> toEntity(List<ReservationDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Reservation> list = new ArrayList<Reservation>( dtoList.size() );
        for ( ReservationDTO reservationDTO : dtoList ) {
            list.add( toEntity( reservationDTO ) );
        }

        return list;
    }

    @Override
    public List<ReservationDTO> toDto(List<Reservation> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReservationDTO> list = new ArrayList<ReservationDTO>( entityList.size() );
        for ( Reservation reservation : entityList ) {
            list.add( toDto( reservation ) );
        }

        return list;
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

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setIdRole( roleDTO.getIdRole() );
        role.setNomRole( roleDTO.getNomRole() );
        role.setActifRole( roleDTO.getActifRole() );
        role.setUsers( userDTOListToUserList( roleDTO.getUsers() ) );

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
        user.setReservations( toEntity( userDTO.getReservations() ) );

        return user;
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
        livre.setReservation( toEntity( livreDTO.getReservation() ) );

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

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setIdRole( role.getIdRole() );
        roleDTO.setNomRole( role.getNomRole() );
        roleDTO.setActifRole( role.getActifRole() );
        roleDTO.setUsers( userListToUserDTOList( role.getUsers() ) );

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
        userDTO.setReservations( toDto( user.getReservations() ) );

        return userDTO;
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
        livreDTO.setReservation( toDto( livre.getReservation() ) );

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
}
