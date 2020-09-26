package com.bibliotheque.entity.mapper;

import com.bibliotheque.entity.User;
import com.bibliotheque.entity.dto.UserDTO;
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
}
