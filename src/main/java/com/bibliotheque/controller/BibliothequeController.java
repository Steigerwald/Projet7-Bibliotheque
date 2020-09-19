package com.bibliotheque.controller;

import com.bibliotheque.entity.Bibliotheque;
import com.bibliotheque.entity.Livre;
import com.bibliotheque.entity.dto.BibliothequeDTO;
import com.bibliotheque.entity.dto.LivreDTO;
import com.bibliotheque.entity.mapper.BibliothequeMapper;
import com.bibliotheque.exception.RecordNotFoundException;
import com.bibliotheque.service.BibliothequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotheque")
public class BibliothequeController {

    @Autowired
    BibliothequeService bibliothequeService;

    @Autowired
    BibliothequeMapper bibliothequeMapper;

    /* controller pour avoir toutes les bibliotheques*/
    @RequestMapping("/")
    public List<Bibliotheque> listOfBibliotheques() {
        List<Bibliotheque> bibliotheque = this.bibliothequeService.findAll();
        return bibliotheque;
    }

    /* controller pour obtenir une bibliotheque */
    @RequestMapping("/{id}")
    public Bibliotheque bibliothequeId(@PathVariable int id) {
        Bibliotheque bibliotheque = this.bibliothequeService.findById(id);
        return bibliotheque;
    }

    /* controller pour ajouter une bibliotheque */
    @PostMapping("/addBibliotheque")
    public ResponseEntity<BibliothequeDTO> newBibliotheque(@RequestBody BibliothequeDTO bibliothequeDTO) throws RecordNotFoundException {
        System.out.println("bibliotheque => " + bibliothequeMapper.toEntity(bibliothequeDTO));
        Bibliotheque bibliotheque =bibliothequeService.createBibliotheque(bibliothequeMapper.toEntity(bibliothequeDTO));
        return new ResponseEntity<>(bibliothequeMapper.toDto(bibliotheque), HttpStatus.OK);
    }

    /* controller pour modifier une bibliotheque */
    @RequestMapping(path = "/updateBibliotheque",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<BibliothequeDTO> updateBibliotheque(@RequestBody BibliothequeDTO bibliothequeModifieDTO) throws RecordNotFoundException {
        Bibliotheque bibliothequeModifie = bibliothequeMapper.toEntity(bibliothequeModifieDTO);
        Bibliotheque bibliotheque=bibliothequeService.updateBibliotheque(bibliothequeModifie);
        BibliothequeDTO dto = bibliothequeMapper.toDto(bibliotheque);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    /* controller pour effacer un livre de la base de données */
    @RequestMapping(path = "/deleteBibliotheque/{id}",method = RequestMethod.POST)
    public void deleteBibliothequeById(Model model, @PathVariable("id") int id) throws RecordNotFoundException{
        bibliothequeService.deleteBibliothequeById(id);
    }
}
