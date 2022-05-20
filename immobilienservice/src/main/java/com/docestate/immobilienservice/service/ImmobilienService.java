package com.docestate.immobilienservice.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.docestate.immobilienservice.exceptions.EntityAlreadyExistsException;
import com.docestate.immobilienservice.model.Immobilie;
import com.docestate.immobilienservice.repositories.ImmobilienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Klasse der Immobilien
 */
@Service
public class ImmobilienService {

    @Autowired
    private ImmobilienRepository immobilienRepository;

    /**
     * holt alle Eintrage aus der Datenbank und liefert als Liste von Immobilien zurueck
     * @return Liste von allen Eintraegen aus der Datenbank
     */
    public List<Immobilie> getImmobilien() {
        return immobilienRepository.findAll();
    }

    /**
     * sucht mit der uebergebenen id die immobilie aus der Liste
     * @param id id der gesuchten Immobilie
     * @return falls Immobilie mit gesuchter id existiert Immobilienobjekt zurueck sonst EntityNotFoundException
     */
    public Immobilie getImmobilieById(int id) {
        return immobilienRepository.findById(id).get();
    }

    /**
     * fuegt falls Immobilie noch nicht vorhanden Immobilie in die Liste hinzu
     * @param immobilie Objekt das hinzugefuegt werden soll
     * @return gibt hinzugefuegtes Objekt zurueck falls noch nicht vorhanden, sonst EntityAlreadyExistsException
     */
    public Immobilie addImmobilie(Immobilie immobilie) {
        try {
            checkImmobilie(immobilie);
            immobilienRepository.save(immobilie);
            return immobilie;
        } catch (EntityAlreadyExistsException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * loescht anhand id die immobilie aus der Liste
     * @param id id der Immobilie die geloescht werden soll
     */
    public void deleteImmobilie(int id) {
        if(immobilienRepository.findById(id).isPresent()) {
            immobilienRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(String.format("Immobilie mit gesuchter id %d nicht gefuden",id));
        }
    }

    /**
     * checkt ob Immobilie mit gleicher Bezeichnung und gleicher Addresse bereits existiert
     * @param immobilie
     */
    private void checkImmobilie(Immobilie immobilie) {
        List<Immobilie> immobilien = immobilienRepository.findAll();
        immobilien.stream()
            .filter(x -> x.getBezeichnung().equals(immobilie.getBezeichnung()))
            .filter(x -> x.getAddresse().equals(immobilie.getAddresse()))
            .findFirst()
            .ifPresent(x -> {
                throw new EntityAlreadyExistsException(String.format(
                "Immobilie mit bezeichnung = %s und adresse = %s gibt es schon", immobilie.getBezeichnung(), immobilie.getAddresse()));
            });
    }
}
