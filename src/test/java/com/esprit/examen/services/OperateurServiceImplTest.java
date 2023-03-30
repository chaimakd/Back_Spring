package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

public class OperateurServiceImplTest {

    @Mock
    private OperateurRepository operateurRepository;

    @InjectMocks
    private OperateurServiceImpl operateurService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllOperateurs() {
        Operateur operateur1 = new Operateur();
        operateur1.setIdOperateur(1L);
        operateur1.setNom("John");
        operateur1.setPrenom("Doe");

        Operateur operateur2 = new Operateur();
        operateur2.setIdOperateur(2L);
        operateur2.setNom("Jane");
        operateur2.setPrenom("Doe");

        List<Operateur> operateurs = Arrays.asList(operateur1, operateur2);

        when(operateurRepository.findAll()).thenReturn(operateurs);

        List<Operateur> retrievedOperateurs = operateurService.retrieveAllOperateurs();

        assertThat(retrievedOperateurs).isEqualTo(operateurs);
    }

    @Test
    public void testAddOperateur() {
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(1L);
        operateur.setNom("John");
        operateur.setPrenom("Doe");

        when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur addedOperateur = operateurService.addOperateur(operateur);

        assertThat(addedOperateur).isEqualTo(operateur);
    }

    @Test
    public void testDeleteOperateur() {
        Long operateurId = 1L;

        operateurService.deleteOperateur(operateurId);

        assertThat(operateurRepository.findById(operateurId)).isEmpty();
    }

    @Test
    public void testUpdateOperateur() {
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(1L);
        operateur.setNom("John");
        operateur.setPrenom("Doe");

        when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur updatedOperateur = operateurService.updateOperateur(operateur);

        assertThat(updatedOperateur).isEqualTo(operateur);
    }

    @Test
    public void testRetrieveOperateur() {
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(1L);
        operateur.setNom("John");
        operateur.setPrenom("Doe");

        when(operateurRepository.findById(1L)).thenReturn(Optional.of(operateur));

        Operateur retrievedOperateur = operateurService.retrieveOperateur(1L);

        assertThat(retrievedOperateur).isEqualTo(operateur);
    }

}