package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

public class SecteurActiviteServiceImplTest {

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void retrieveAllSecteurActivite() {
        List<SecteurActivite> secteurActivites = new ArrayList<>();
        secteurActivites.add(new SecteurActivite(1L, "CODE1", "Libelle1", null));
        secteurActivites.add(new SecteurActivite(2L, "CODE2", "Libelle2", null));

        when(secteurActiviteRepository.findAll()).thenReturn(secteurActivites);

        List<SecteurActivite> retrievedSecteurActivites = secteurActiviteService.retrieveAllSecteurActivite();

        assertThat(retrievedSecteurActivites.size()).isEqualTo(2);
        assertThat(retrievedSecteurActivites.get(0).getCodeSecteurActivite()).isEqualTo("CODE1");
        assertThat(retrievedSecteurActivites.get(1).getCodeSecteurActivite()).isEqualTo("CODE2");
    }

    @Test
    public void addSecteurActivite() {
        SecteurActivite sa = new SecteurActivite(1L, "CODE1", "Libelle1", null);

        when(secteurActiviteRepository.save(sa)).thenReturn(sa);

        SecteurActivite addedSa = secteurActiviteService.addSecteurActivite(sa);

        assertThat(addedSa).isEqualTo(sa);
    }

    @Test
    public void deleteSecteurActivite() {
        Long id = 1L;

        secteurActiviteService.deleteSecteurActivite(id);

        verify(secteurActiviteRepository, times(1)).deleteById(id);
    }

    @Test
    public void updateSecteurActivite() {
        SecteurActivite sa = new SecteurActivite(1L, "CODE1", "Libelle1", null);

        when(secteurActiviteRepository.save(sa)).thenReturn(sa);

        SecteurActivite updatedSa = secteurActiviteService.updateSecteurActivite(sa);

        assertThat(updatedSa).isEqualTo(sa);
    }

    @Test
    public void retrieveSecteurActivite() {
        Long id = 1L;
        SecteurActivite sa = new SecteurActivite(1L, "CODE1", "Libelle1", null);

        when(secteurActiviteRepository.findById(id)).thenReturn(Optional.of(sa));

        SecteurActivite retrievedSa = secteurActiviteService.retrieveSecteurActivite(id);

        assertThat(retrievedSa).isEqualTo(sa);
    }
}
