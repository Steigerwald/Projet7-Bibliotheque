package com.bibliotheque.controller;

import com.bibliotheque.entity.Livre;
import com.bibliotheque.entity.dto.LivreDTO;
import com.bibliotheque.entity.mapper.LivreMapper;
import com.bibliotheque.exception.RecordNotFoundException;
import com.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/livre")
public class LivreController {

    @Autowired
    LivreService livreService;

    @Autowired
    LivreMapper livreMapper;

    /* controller pour avoir tous les livres*/
    @RequestMapping("/")
    public List<Livre> listOfBooks() {
        List<Livre> livre = this.livreService.findAll();
        return livre;
    }

    /* controller pour obtenir un livre */
    @RequestMapping("/{id}")
    public Livre bookId(@PathVariable int id) {
        Livre livre = this.livreService.findById(id);
        return livre;
    }


    /* controller pour ajouter un livre */
    @PostMapping("/addLivre")
    public ResponseEntity<LivreDTO> newBook(@RequestBody LivreDTO livreDTO) throws RecordNotFoundException {
        System.out.println("livre => " + livreMapper.toEntity(livreDTO));
        Livre livre =livreService.CreateLivre(livreMapper.toEntity(livreDTO));
        return new ResponseEntity<>(livreMapper.toDto(livre), HttpStatus.OK);
    }

    /* controller pour modifier un livre */
    @RequestMapping(path = "/updateLivre",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<LivreDTO> updateLivre(@RequestBody LivreDTO livreModifieDTO) throws RecordNotFoundException {
        Livre livreModifie = livreMapper.toEntity(livreModifieDTO);
        Livre livre=livreService.updateLivre(livreModifie);
        LivreDTO dto = livreMapper.toDto(livre);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /* controller pour effacer un livre de la base de données */
    @RequestMapping(path = "/deleteLivre/{id}",method = RequestMethod.POST)
    public void deleteLivreById(Model model, @PathVariable("id") int id) throws RecordNotFoundException{
        livreService.deleteLivreById(id);
    }


}
