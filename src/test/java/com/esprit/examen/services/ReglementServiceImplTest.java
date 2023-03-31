package com.esprit.examen.services;
import java.util.Date;
import java.util.List;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.ReglementRepository;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReglementServiceImplTest {

        @Autowired
        private IReglementService reglementService;

        @Autowired
        private ReglementRepository reglementRepository;

        @Autowired
        private FactureRepository factureRepository;

        @Test
        public void testAddReglement() {
            Facture facture = new Facture();
            facture.setDateCreationFacture(new Date());
            facture.setMontantFacture(1000);
            factureRepository.save(facture);

            Reglement reglement = new Reglement();
            reglement.setDateReglement(new Date());
            reglement.setMontantPaye(500);
            reglement.setPayee(false);
            reglement.setFacture(facture);
            reglementService.addReglement(reglement);

            List<Reglement> reglements = (List<Reglement>) reglementRepository.findAll();
            //assertThat(reglements.size()).hasSize(1);
           // assertThat(reglements.get(0)).isEqualTo(reglement);
        }

        @Test
        public void testRetrieveReglementByFacture() {
            Facture facture = new Facture();

            facture.setDateCreationFacture(new Date());
            facture.setMontantFacture(1000);
            factureRepository.save(facture);

            Reglement reglement1 = new Reglement();
            reglement1.setDateReglement(new Date());
            reglement1.setMontantPaye(500);
            reglement1.setPayee(false);
            reglement1.setFacture(facture);
            reglementService.addReglement(reglement1);

            Reglement reglement2 = new Reglement();
            reglement2.setDateReglement(new Date());
            reglement2.setMontantPaye(400);
            reglement2.setPayee(false);
            reglement2.setFacture(facture);
            reglementService.addReglement(reglement2);

            List<Reglement> reglements = reglementService.retrieveReglementByFacture(facture.getIdFacture());
            //assertThat(reglements).hasSize(2);
            //assertThat(reglements).containsExactlyInAnyOrder(reglement1, reglement2);
        }

        @Test
        public void testGetChiffreAffaireEntreDeuxDate() {
            Facture facture1 = new Facture();
            facture1.setDateCreationFacture(DateUtils.addDays(new Date(), -10));
            facture1.setMontantFacture(1000);
            factureRepository.save(facture1);

            Facture facture2 = new Facture();
            facture2.setDateCreationFacture(DateUtils.addDays(new Date(), -5));
            facture2.setMontantFacture(500);
            factureRepository.save(facture2);

            Reglement reglement1 = new Reglement();
            reglement1.setDateReglement(DateUtils.addDays(new Date(), -10));
            reglement1.setMontantPaye(500);
            reglement1.setPayee(true);
            reglement1.setFacture(facture1);
            reglementService.addReglement(reglement1);

            Reglement reglement2 = new Reglement();
            reglement2.setDateReglement(DateUtils.addDays(new Date(), -5));
            reglement2.setMontantPaye(300);
            reglement2.setPayee(true);
            reglement2.setFacture(facture2);
            reglementService.addReglement(reglement2);

            //float chiffreAffaire = reglementService.getChiffreAffaireEntreDeuxDate(DateUtils.addDays(new Date()));


        }
}