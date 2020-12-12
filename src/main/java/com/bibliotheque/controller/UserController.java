package com.bibliotheque.controller;

import com.bibliotheque.entity.Role;
import com.bibliotheque.entity.User;
import com.bibliotheque.entity.dto.RoleDTO;
import com.bibliotheque.entity.dto.UserDTO;
import com.bibliotheque.entity.mapper.RoleMapper;
import com.bibliotheque.entity.mapper.UserMapper;
import com.bibliotheque.exception.RecordNotFoundException;
import com.bibliotheque.form.LoginForm;
import com.bibliotheque.service.CustomUserDetailsService;
import com.bibliotheque.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;
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


    /* controller login pour se connecter*/
    @RequestMapping(path="login",method=RequestMethod.PUT)
    @ResponseBody
    public String login(@RequestBody LoginForm user) {
        customUserDetailsService.loadUserByUsername(user.getUserName());
        User userTrouve = userService.getUserByMail(user.getUserName());
        if (userTrouve != null) {
            String token = getJWTToken(user.getUserName());
            User userConnecte = new User();
            userConnecte.setMailUser(user.getUserName());
            return token;
        } else {
            return "not found";
        }
    }

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
                .setExpiration(new Date(System.currentTimeMillis() + 600000000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer " + token;
    }

    @RequestMapping(path="user/me",method=RequestMethod.POST)
    public ResponseEntity<UserDTO> userConnecte(@RequestParam("username") String username) {
        User userConcerne = userService.getUserByMail(username);
        if (userConcerne==null){
            return new ResponseEntity<>(userMapper.toDto(userConcerne), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(userMapper.toDto(userConcerne), HttpStatus.OK);
        }
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
        if (leUser==null){
            return new ResponseEntity<>(userMapper.toDto(leUser), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(userMapper.toDto(leUser), HttpStatus.OK);
        }
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

    /* controller pour avoir le user connecté */
    @RequestMapping(path="getLogedUser",method=RequestMethod.GET)
    public Map<String,Object> getLogedUser (HttpSession session){
        SecurityContext securityContext = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
        String username =securityContext.getAuthentication().getName();
        List<String> roles=new ArrayList<>();
        for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()){
        roles.add(ga.getAuthority());
        }
        Map<String,Object> params=new HashMap<>();
        params.put("username",username);
        params.put("roles",roles);
        return params;
    }




}
