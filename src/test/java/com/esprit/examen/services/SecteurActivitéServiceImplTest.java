package com.esprit.examen.services;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SecteurActivitéServiceImplTest {

       @Autowired
        private SecteurActiviteRepository secteurActiviteRepository;

        @Autowired
        private ISecteurActiviteService secteurActiviteService;

        @Test
        public void testAddSecteurActivite() {
            // Création d'un nouveau SecteurActivite
            SecteurActivite sa = new SecteurActivite();
            sa.setCodeSecteurActivite("SA01");
            sa.setLibelleSecteurActivite("Secteur d'activité 01");

            // Ajout du SecteurActivite dans la base de données
            SecteurActivite addedSa = secteurActiviteService.addSecteurActivite(sa);

            // Vérification si le SecteurActivite a été ajouté correctement
            assertThat(addedSa.getIdSecteurActivite()).isNotNull();
            assertThat(addedSa.getCodeSecteurActivite()).isEqualTo("SA01");
            assertThat(addedSa.getLibelleSecteurActivite()).isEqualTo("Secteur d'activité 01");
        }

        @Test
        public void testRetrieveAllSecteurActivite() {
            // Récupération de tous les SecteurActivite de la base de données
            List<SecteurActivite> secteurActivites = secteurActiviteService.retrieveAllSecteurActivite();

            // Vérification si la liste est non vide
            assertThat(secteurActivites).isNotNull();
        }

        @Test
        public void testRetrieveSecteurActivite() {
            // Création d'un nouveau SecteurActivite
            SecteurActivite sa = new SecteurActivite();
            sa.setCodeSecteurActivite("SA02");
            sa.setLibelleSecteurActivite("Secteur d'activité 02");
            SecteurActivite addedSa = secteurActiviteRepository.save(sa);

            // Récupération du SecteurActivite ajouté
            SecteurActivite retrievedSa = secteurActiviteService.retrieveSecteurActivite(addedSa.getIdSecteurActivite());

            // Vérification si le SecteurActivite a été récupéré correctement
            assertThat(retrievedSa).isNotNull();
            assertThat(retrievedSa.getCodeSecteurActivite()).isEqualTo("SA02");
            assertThat(retrievedSa.getLibelleSecteurActivite()).isEqualTo("Secteur d'activité 02");
        }

        @Test
        public void testUpdateSecteurActivite() {
            // Création d'un nouveau SecteurActivite
            SecteurActivite sa = new SecteurActivite();
            sa.setCodeSecteurActivite("SA03");
            sa.setLibelleSecteurActivite("Secteur d'activité 03");
            SecteurActivite addedSa = secteurActiviteRepository.save(sa);

            // Modification du SecteurActivite
            addedSa.setLibelleSecteurActivite("Secteur d'activité 03 modifié");
            SecteurActivite updatedSa = secteurActiviteService.updateSecteurActivite(addedSa);

            // Vérification si le SecteurActiv

        }
}
