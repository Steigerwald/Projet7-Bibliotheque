package com.bibliotheque.service;

import com.bibliotheque.entity.Livre;
import com.bibliotheque.entity.dto.LivreDTO;
import com.bibliotheque.exception.RecordNotFoundException;
import com.bibliotheque.form.Search;
import com.bibliotheque.repository.LivreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LivreService {

    Logger logger = (Logger) LoggerFactory.getLogger(LivreService.class);

    @Autowired
    LivreRepository livreRepository;

    /*Methode pour avoir tous les livres de la base de données*/
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    /*Methode pour trouver par son id un livre dans la base de données*/
    public Livre findById(int id) {
        return  livreRepository.findById(id).get();
    }

    /*Methode pour obtenir tous les Livres disponibles de la base de données*/
    public List<Livre> getAllLivresDisponibles() {
        List<Livre> result1 =(List<Livre>) livreRepository.findAll();
        List<Livre> result2=new ArrayList<Livre>();
        if(result1.size() > 0) {
            logger.info(" retour liste result1 de tous les livres de la BD avec getAllLivresDisponoibles si taille de result1 >0 ");
            for (int i=0;i<result1.size();i=i+1){
                if (result1.get(i).getDisponibilite()) {
                    result2.add(result1.get(i));
                }
            }
            return result2;
        } else {
            logger.info(" retour nouvelle liste des Livres Disponibles car pas d'élément dans la liste result1 ");
            return result2;
        }
    }

    /*Methode pour sauvegarder un livre dans la base de données*/
    public void save(Livre livre) {
        logger.info(" l'id de newLivre vaut: "+livre.getIdLivre());
        livreRepository.save(livre);
    }

    /*Methode pour creer un livre dans la base de données*/
    public Livre createLivre(Livre entity) throws RecordNotFoundException {
        logger.info(" retour de la valeur de l'entité entity de CreateLivre" + entity);
        entity.setDisponibilite(true);
        //enregistrement du livre dans la basse de données
        logger.info(" retour de l'entité newLivre de createLivre qui a été créée et sauvegardée");
        return livreRepository.save(entity);
    }


    /*Methode pour modifier un livre dans la base de données*/
    public Livre updateLivre(Livre entity) throws RecordNotFoundException {
        Livre livreAModifier = findById(entity.getIdLivre());
        if(livreAModifier!=null) {
            logger.info(" l'entité livre à modifier a été trouvée et peut être modifiée");
            logger.info(" retour de la nouvelle entité site de UpdateLivre qui a été sauvegardée et le livreAModifier était existant");
            return livreRepository.save(entity);
        } else {
            throw new RecordNotFoundException("Pas de livre trouvé avec l'id de l'entité et il ne peut être modifié");
        }
    }

    /*Methode pour effacer un livre dans la base de données*/
    public void deleteLivreById(int id) throws RecordNotFoundException {
        Optional<Livre> livreAEffacer = livreRepository.findById(id);
        if(livreAEffacer.isPresent()) {
            Livre livreTrouve = livreAEffacer.get();
            livreRepository.deleteById(livreTrouve.getIdLivre());
        } else {
            throw new RecordNotFoundException("Pas de livre enregistré avec cet Id");
        }
    }


    /*Methode pour une recherche de livres*/
    public List<Livre> getAllLivresBySearch(Search search){
        return livreRepository.findAllLivresByTitreOrAuteurOrNomCategorie(search.getTitre(),search.getAuteur(),search.getNomCategorie());
    }

    /*Methode pour obtenir tous les exemplaires disponibles d'un livre par titre */
    public List<Livre> getLivreDisponibleByTitre(String titre) throws RecordNotFoundException {
        List<Livre> listeLivresTrouves = livreRepository.findByTitre(titre);
        List<Livre> livresDisponibles =new ArrayList<>();
        if(listeLivresTrouves.size()>0) {
            logger.info(" retour du livre car la liste des livre trouvé n'est pas vide ");
            for (int i=0;i<listeLivresTrouves.size();i++){
                if (listeLivresTrouves.get(i).getDisponibilite()){
                    livresDisponibles.add(listeLivresTrouves.get(i));
                }
            }
            return livresDisponibles;
            // attention à prévoir le cas où livresDisponibles est null lorsque tous les exemplaires sont loués
        } else {
            throw new RecordNotFoundException("Pas de livre enregistré avec cet Id");
        }
    }



}
