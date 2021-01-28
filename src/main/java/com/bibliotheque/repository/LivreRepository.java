package com.bibliotheque.repository;

import com.bibliotheque.entity.Livre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

    List<Livre> findByTitre(String titre);
    List<Livre> findAllByTitre(String titre);
    List<Livre> findAllLivresByTitreStartsWith(String titre);
    List<Livre> findAllLivresByAuteurStartsWith(String auteur);
    List<Livre> findAllLivresByNomCategorie(String nomCategorie);
    List<Livre> findAllLivresByTitreOrAuteurOrNomCategorie(String titre, String auteur, String nomCategorie);
    List<Livre> findAllLivresByTitreLikeOrAuteurLikeOrNomCategorieLike(String titre, String auteur, String nomCategorie);
    List<Livre> findAllLivresByTitreStartingWithOrAuteurStartingWithOrNomCategorieStartingWith(String titre, String auteur, String nomCategorie);
    List<Livre> findAllLivresByTitreContainingOrAuteurContainingOrNomCategorieContaining(String titre, String auteur, String nomCategorie);
    List<Livre> findAllLivresByTitreStartsWithOrAuteurOrNomCategorie(String titre, String auteur, String nomCategorie);
}
