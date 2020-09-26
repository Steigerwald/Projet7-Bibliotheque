package com.bibliotheque.entity.mapper;

import com.bibliotheque.entity.Reservation;
import com.bibliotheque.entity.dto.ReservationDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-26T23:06:45+0200",
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
}
