package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.ReglementRepository;

public class ReglementServiceImplTest {

    @InjectMocks
    private ReglementServiceImpl reglementService;

    @Mock
    private FactureRepository factureRepository;

    @Mock
    private ReglementRepository reglementRepository;

    private Facture facture;
    private Reglement reglement;
    private List<Reglement> reglements;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        facture = new Facture();
        facture.setIdFacture(1L);

        reglement = new Reglement();
        reglement.setIdReglement(1L);
        reglement.setDateReglement(new Date());
        reglement.setMontantPaye(1000);
        reglement.setMontantRestant(0);
        reglement.setPayee(true);
        reglement.setFacture(facture);

        reglements = new ArrayList<>();
        reglements.add(reglement);

        Mockito.when(reglementRepository.findAll()).thenReturn(reglements);
        Mockito.when(reglementRepository.save(reglement)).thenReturn(reglement);
        Mockito.when(reglementRepository.findById(reglement.getIdReglement())).thenReturn(Optional.of(reglement));
        Mockito.when(reglementRepository.retrieveReglementByFacture(facture.getIdFacture())).thenReturn(reglements);
        Mockito.when(reglementRepository.getChiffreAffaireEntreDeuxDate(Mockito.any(), Mockito.any())).thenReturn(1000f);
    }

    @Test
    public void testRetrieveAllReglements() {
        List<Reglement> result = reglementService.retrieveAllReglements();

        assertEquals(1, result.size());
        assertEquals(reglement, result.get(0));
    }

    @Test
    public void testAddReglement() {
        Reglement result = reglementService.addReglement(reglement);

        assertEquals(reglement, result);
    }

    @Test
    public void testRetrieveReglement() {
        Reglement result = reglementService.retrieveReglement(reglement.getIdReglement());

        assertEquals(reglement, result);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        List<Reglement> result = reglementService.retrieveReglementByFacture(facture.getIdFacture());

        assertEquals(1, result.size());
        assertEquals(reglement, result.get(0));
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        float result = reglementService.getChiffreAffaireEntreDeuxDate(new Date(), new Date());

        assertEquals(1000f, result);
    }

}
