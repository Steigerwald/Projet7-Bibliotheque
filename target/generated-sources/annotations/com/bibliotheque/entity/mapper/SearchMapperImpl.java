package com.bibliotheque.entity.mapper;

import com.bibliotheque.entity.dto.SearchDTO;
import com.bibliotheque.form.Search;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-24T21:22:35+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class SearchMapperImpl implements SearchMapper {

    @Override
    public Search toEntity(SearchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Search search = new Search();

        search.setAuteur( dto.getAuteur() );
        search.setNomCategorie( dto.getNomCategorie() );
        search.setTitre( dto.getTitre() );

        return search;
    }

    @Override
    public SearchDTO toDto(Search entity) {
        if ( entity == null ) {
            return null;
        }

        SearchDTO searchDTO = new SearchDTO();

        searchDTO.setAuteur( entity.getAuteur() );
        searchDTO.setNomCategorie( entity.getNomCategorie() );
        searchDTO.setTitre( entity.getTitre() );

        return searchDTO;
    }

    @Override
    public List<Search> toEntity(List<SearchDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Search> list = new ArrayList<Search>( dtoList.size() );
        for ( SearchDTO searchDTO : dtoList ) {
            list.add( toEntity( searchDTO ) );
        }

        return list;
    }

    @Override
    public List<SearchDTO> toDto(List<Search> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SearchDTO> list = new ArrayList<SearchDTO>( entityList.size() );
        for ( Search search : entityList ) {
            list.add( toDto( search ) );
        }

        return list;
    }
}
