package com.bibliotheque.controller;

import com.bibliotheque.entity.Livre;
import com.bibliotheque.entity.dto.LivreDTO;
import com.bibliotheque.entity.mapper.LivreMapper;
import com.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livre")
public class LivreController {

    @Autowired
    LivreService livreService;

    @Autowired
    LivreMapper livreMapper;

    @RequestMapping("/")
    public List<Livre> listOfBooks() {
        List<Livre> livre = this.livreService.findAll();
        return livre;
    }

    @RequestMapping("/{id}")
    public Livre bookId(@PathVariable int id) {
        Livre livre = this.livreService.findById(id);
        return livre;
    }

    @PostMapping("/new")
    public ResponseEntity<LivreDTO> newBook(@RequestBody LivreDTO livreDTO) {
        System.out.println("livre => " + livreMapper.toEntity(livreDTO));
        return new ResponseEntity<>(livreDTO, HttpStatus.OK);
    }
}
