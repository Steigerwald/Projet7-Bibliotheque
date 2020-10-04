package com.bibliotheque.controller;

import com.bibliotheque.entity.Role;
import com.bibliotheque.entity.User;
import com.bibliotheque.entity.dto.RoleDTO;
import com.bibliotheque.entity.dto.UserDTO;
import com.bibliotheque.entity.mapper.RoleMapper;
import com.bibliotheque.entity.mapper.UserMapper;
import com.bibliotheque.exception.RecordNotFoundException;
import com.bibliotheque.service.CustomUserDetailsService;
import com.bibliotheque.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public UserService userService;

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    public RoleMapper roleMapper;

    @PostMapping("login")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        User userConnecte = new User();
        userConnecte.setMailUser(username);
        userConnecte.setMotDePasse(pwd);
        //userConnecte.setToken(token);
        return userConnecte;
    }


    @PostMapping("userConnecte")


    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer " + token;
    }

    /* controller pour avoir tous les users*/
    @RequestMapping(path="users/",method=RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> listOfUsers() {
        List<User> tousLesUsers= userService.getAllUsers();
        return new ResponseEntity<>(userMapper.toDto(tousLesUsers), HttpStatus.OK);
    }


    /* controller pour obtenir un user */
    @RequestMapping(path="user/{id}",method=RequestMethod.GET)
    public ResponseEntity<UserDTO> userId(@PathVariable int id) throws RecordNotFoundException {
        User leUser=userService.getUserById(id);
        return new ResponseEntity<>(userMapper.toDto(leUser), HttpStatus.OK);
    }

    /* controller pour ajouter un user */
    @RequestMapping(path = "user/addUser",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<UserDTO> newUser(@RequestBody UserDTO userDTO) throws RecordNotFoundException {
        System.out.println("user => " + userMapper.toEntity(userDTO));
        User userCree =userService.saveUser(userMapper.toEntity(userDTO));
        return new ResponseEntity<>(userMapper.toDto(userCree), HttpStatus.OK);
    }

    /* controller pour modifier un user */
    @RequestMapping(path = "user",method = RequestMethod.PUT,produces = "application/json")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userModifieDTO) throws RecordNotFoundException {
        User userModifie = userMapper.toEntity(userModifieDTO);
        User user=userService.updateUser(userModifie);
        UserDTO dto = userMapper.toDto(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /* controller pour effacer un user de la base de données */
    @RequestMapping(path = "user/{id}",method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") int id) throws RecordNotFoundException{
        userService.deleteUserById(id);
    }

    /* controller pour désactiver un user de la base de données */
    @RequestMapping(path = "user/desactiverUser/{id}",method = RequestMethod.PUT)
    public void desactiverUserById(@PathVariable("id") int id) throws RecordNotFoundException{
        userService.desactiveUserById(id);
    }

    /* controller pour réactiver un user de la base de données */
    @RequestMapping(path = "user/reactiverUser/{id}",method = RequestMethod.PUT)
    public void reactiverUserById(@PathVariable("id") int id) throws RecordNotFoundException{
        userService.reactiveUserById(id);
    }

    /* controller pour avoir tous les roles*/
    @RequestMapping(path="roles/",method=RequestMethod.GET)
    public ResponseEntity<List<RoleDTO>> listOfRoles() {
        List<Role> tousLesRoles= userService.getAllRoles();
        return new ResponseEntity<>(roleMapper.toDto(tousLesRoles), HttpStatus.OK);
    }

    /* controller pour obtenir un role */
    @RequestMapping(path="role/{id}",method=RequestMethod.GET)
    public ResponseEntity<RoleDTO> roleId(@PathVariable int id) throws RecordNotFoundException {
        Role leRole=userService.getRoleById(id);
        return new ResponseEntity<>(roleMapper.toDto(leRole), HttpStatus.OK);
    }

}
