package com.bibliotheque.entity.mapper;

import com.bibliotheque.entity.Bibliotheque;
import com.bibliotheque.entity.dto.BibliothequeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-12T22:54:50+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class BibliothequeMapperImpl implements BibliothequeMapper {

    @Override
    public Bibliotheque toEntity(BibliothequeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Bibliotheque bibliotheque = new Bibliotheque();

        bibliotheque.setIdBibliotheque( dto.getIdBibliotheque() );
        bibliotheque.setNomBibliotheque( dto.getNomBibliotheque() );
        bibliotheque.setLieu( dto.getLieu() );
        bibliotheque.setAdresse( dto.getAdresse() );

        return bibliotheque;
    }

    @Override
    public BibliothequeDTO toDto(Bibliotheque entity) {
        if ( entity == null ) {
            return null;
        }

        BibliothequeDTO bibliothequeDTO = new BibliothequeDTO();

        bibliothequeDTO.setIdBibliotheque( entity.getIdBibliotheque() );
        bibliothequeDTO.setNomBibliotheque( entity.getNomBibliotheque() );
        bibliothequeDTO.setLieu( entity.getLieu() );
        bibliothequeDTO.setAdresse( entity.getAdresse() );

        return bibliothequeDTO;
    }

    @Override
    public List<Bibliotheque> toEntity(List<BibliothequeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Bibliotheque> list = new ArrayList<Bibliotheque>( dtoList.size() );
        for ( BibliothequeDTO bibliothequeDTO : dtoList ) {
            list.add( toEntity( bibliothequeDTO ) );
        }

        return list;
    }

    @Override
    public List<BibliothequeDTO> toDto(List<Bibliotheque> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BibliothequeDTO> list = new ArrayList<BibliothequeDTO>( entityList.size() );
        for ( Bibliotheque bibliotheque : entityList ) {
            list.add( toDto( bibliotheque ) );
        }

        return list;
    }
}
