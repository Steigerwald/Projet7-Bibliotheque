package com.bibliotheque.service;

import com.bibliotheque.entity.Livre;
import com.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LivreService {

    @Autowired
    LivreRepository livreRepository;

    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    public Livre findById(int id) {
        return  livreRepository.findById(id).get();
    }

    public void save(Livre livre) {
        livreRepository.save(livre);
    }
}
