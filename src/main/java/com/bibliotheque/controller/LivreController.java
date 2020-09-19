package com.bibliotheque.controller;

import com.bibliotheque.entity.Livre;
import com.bibliotheque.entity.dto.LivreDTO;
import com.bibliotheque.entity.dto.SearchDTO;
import com.bibliotheque.entity.mapper.LivreMapper;
import com.bibliotheque.entity.mapper.SearchMapper;
import com.bibliotheque.exception.RecordNotFoundException;
import com.bibliotheque.form.Search;
import com.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livre")
public class LivreController {

    @Autowired
    LivreService livreService;

    @Autowired
    LivreMapper livreMapper;

    @Autowired
    SearchMapper searchMapper;


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

    /* Controller pour la liste de tous les livres disponibles */
    @RequestMapping(path ="/disponibles",method = RequestMethod.GET)
    public List<Livre> getAllLivresDisponibles() {
        return livreService.getAllLivresDisponibles();
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


    /* Controller pour chercher un livre par titre ou par auteur ou par nom de categorie */
    @RequestMapping(path = "/searchLivres", method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<List<LivreDTO> >searchLivresByTitreOrByAuteurOrByNomCategorie(@RequestBody SearchDTO searchDTO) {
        Search search=searchMapper.toEntity(searchDTO);
        List<Livre> listLivresTrouves = livreService.getAllLivresBySearch(search);
        if (listLivresTrouves.size()==0){
            return null;
        } else{
            return new ResponseEntity<>(livreMapper.toDto(listLivresTrouves),HttpStatus.OK);
        }
    }

    /* Controller pour chercher un livre par titre disponible et tous les exemplaires */
    @RequestMapping(path = "/exemplairesDisponibles", method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<List<LivreDTO> >searchExemplairesDisponibles(@RequestBody SearchDTO searchDTO) throws RecordNotFoundException {
        Search search=searchMapper.toEntity(searchDTO);
        List<Livre> listLivresTrouves =livreService.getLivreDisponibleByTitre(search.getTitre());
        if (listLivresTrouves.size()==0){
            return null;
        } else{
            return new ResponseEntity<>(livreMapper.toDto(listLivresTrouves),HttpStatus.OK);
        }
    }


}
