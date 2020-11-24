package com.bibliotheque.entity.mapper;

import com.bibliotheque.entity.Bibliotheque;
import com.bibliotheque.entity.Livre;
import com.bibliotheque.entity.dto.BibliothequeDTO;
import com.bibliotheque.entity.dto.LivreDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-24T22:41:16+0100",
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
        livre.setBibliotheque( bibliothequeDTOToBibliotheque( dto.getBibliotheque() ) );

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
        livreDTO.setBibliotheque( bibliothequeToBibliothequeDTO( entity.getBibliotheque() ) );

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

    protected Bibliotheque bibliothequeDTOToBibliotheque(BibliothequeDTO bibliothequeDTO) {
        if ( bibliothequeDTO == null ) {
            return null;
        }

        Bibliotheque bibliotheque = new Bibliotheque();

        bibliotheque.setIdBibliotheque( bibliothequeDTO.getIdBibliotheque() );
        bibliotheque.setNomBibliotheque( bibliothequeDTO.getNomBibliotheque() );
        bibliotheque.setLieu( bibliothequeDTO.getLieu() );
        bibliotheque.setAdresse( bibliothequeDTO.getAdresse() );

        return bibliotheque;
    }

    protected BibliothequeDTO bibliothequeToBibliothequeDTO(Bibliotheque bibliotheque) {
        if ( bibliotheque == null ) {
            return null;
        }

        BibliothequeDTO bibliothequeDTO = new BibliothequeDTO();

        bibliothequeDTO.setIdBibliotheque( bibliotheque.getIdBibliotheque() );
        bibliothequeDTO.setNomBibliotheque( bibliotheque.getNomBibliotheque() );
        bibliothequeDTO.setLieu( bibliotheque.getLieu() );
        bibliothequeDTO.setAdresse( bibliotheque.getAdresse() );

        return bibliothequeDTO;
    }
}
