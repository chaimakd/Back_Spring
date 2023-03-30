package com.esprit.examen.services;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Test
    public void retrieveAllFournisseursTest() {
        List<Fournisseur> list = new ArrayList<>();
        list.add(new Fournisseur());
        when(fournisseurRepository.findAll()).thenReturn(list);
        fournisseurService.retrieveAllFournisseurs();
    }

    @Test
    public void addFournisseurTest() {
        Fournisseur f = new Fournisseur();
        f.setIdFournisseur(1L);
        DetailFournisseur df = new DetailFournisseur();
        df.setDateDebutCollaboration(new Date());
        f.setDetailFournisseur(df);
        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(f);
        fournisseurService.addFournisseur(f);
    }

    @Test
    public void updateFournisseurTest() {
        Fournisseur f = new Fournisseur();
        f.setIdFournisseur(1L);
        DetailFournisseur df = new DetailFournisseur();
        df.setDateDebutCollaboration(new Date());
        f.setDetailFournisseur(df);
        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(f);
        when(detailFournisseurRepository.save(any(DetailFournisseur.class))).thenReturn(df);
        fournisseurService.updateFournisseur(f);
    }

    @Test
    public void deleteFournisseurTest() {
        Long id = 1L;
        fournisseurService.deleteFournisseur(id);
    }

    @Test
    public void retrieveFournisseurTest() {
        Long id = 1L;
        Fournisseur f = new Fournisseur();
        f.setIdFournisseur(id);
        Optional<Fournisseur> opt = Optional.of(f);
        when(fournisseurRepository.findById(id)).thenReturn(opt);
        fournisseurService.retrieveFournisseur(id);
    }

}
