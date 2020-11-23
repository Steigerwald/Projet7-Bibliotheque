package com.bibliotheque.repository;

import com.bibliotheque.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

    List<Livre> findByTitre(String titre);
    List<Livre> findAllByTitre(String titre);
    List<Livre> findAllLivresByTitreOrAuteurOrNomCategorie(String titre, String auteur, String nomCategorie);
}
