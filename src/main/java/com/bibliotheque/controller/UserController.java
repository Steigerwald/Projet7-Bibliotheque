package com.bibliotheque.controller;


import com.bibliotheque.entity.User;
import com.bibliotheque.entity.dto.UserDTO;
import com.bibliotheque.entity.mapper.UserMapper;
import com.bibliotheque.exception.RecordNotFoundException;
import com.bibliotheque.service.CustomUserDetailsService;
import com.bibliotheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public UserService userService;

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    /* Controller pour un login d'un user */
    @RequestMapping(path="login",method = RequestMethod.POST)
    public ResponseEntity<UserDTO> loginSite(@RequestBody UserDTO userConnecteDTO) {
        User userConnecte = userMapper.toEntity(userConnecteDTO);
        customUserDetailsService.loadUserByUsername(userConnecte.getMailUser());
        // comment rentrer le mot de passe et mail
        UserDTO dto = userMapper.toDto(userConnecte);
        return new ResponseEntity<>(dto, HttpStatus.OK); //userConnecte
    }

     /*
    @PostMapping("/login")
    String login(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        return authentication
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }
    */


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
    @RequestMapping(path = "user/updateUser",method = RequestMethod.PUT,produces = "application/json")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userModifieDTO) throws RecordNotFoundException {
        User userModifie = userMapper.toEntity(userModifieDTO);
        User user=userService.updateUser(userModifie);
        UserDTO dto = userMapper.toDto(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /* controller pour effacer un user de la base de données */
    @RequestMapping(path = "user/deleteUser/{id}",method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") int id) throws RecordNotFoundException{
        userService.deleteUserById(id);
    }

    /* controller pour désactiver un user de la base de données */
    @RequestMapping(path = "user/desactiverUser/{id}",method = RequestMethod.PUT)
    public void desactiverUserById(@PathVariable("id") int id) throws RecordNotFoundException{
        userService.desactiveUserById(id);
    }


}
