package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CategorieProduitServiceImpl.class})
@MockBean({CategorieProduitRepository.class})
@SpringBootTest
public class CategorieProduitServiceImplTest {

    @MockBean
    CategorieProduitRepository categorieProduitRepository;

    @Autowired
    CategorieProduitServiceImpl categorieProduitService;

    CategorieProduit categorieProduit = new CategorieProduit(1L, "", "", new HashSet<Produit>());

    public CategorieProduitServiceImplTest() {
    }

    @Test
    public void retrieveAllCategorieProduitsTest(){
        CategorieProduit categorieProduit = new CategorieProduit();
        CategorieProduit categorieProduit1 = new CategorieProduit();
        CategorieProduit categorieProduit2 = new CategorieProduit();
        CategorieProduit categorieProduit3 = new CategorieProduit();
        List<CategorieProduit> categorieProduits = new ArrayList<>();
        categorieProduits.add(categorieProduit);
        categorieProduits.add(categorieProduit1);
        categorieProduits.add(categorieProduit2);
        categorieProduits.add(categorieProduit3);
        Mockito.when(categorieProduitRepository.findAll()).thenReturn(categorieProduits);
        assertTrue(categorieProduitService.retrieveAllCategorieProduits().size()==categorieProduits.size());
    }

    @Test
    public void addCategorieProduitTest(){
//        Mockito.when(categorieProduitRepository.save((CategorieProduit)any()).th.thenReturn(categorieProduits);
        CategorieProduit categorieProduit1 = categorieProduitService.addCategorieProduit(categorieProduit);
        assertTrue(categorieProduit.equals(categorieProduit1));
    }

    @Test
    public void deleteCategorieProduit(){
//        cate
    }

}