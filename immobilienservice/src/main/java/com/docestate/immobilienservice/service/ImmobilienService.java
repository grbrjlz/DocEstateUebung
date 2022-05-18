package com.docestate.immobilienservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.docestate.immobilienservice.exceptions.EntityAlreadyExistsException;
import com.docestate.immobilienservice.exceptions.EntityNotFoundException;
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

    private static List<Immobilie> immobilien;
    private static final AtomicInteger counter = new AtomicInteger();


    public List<Immobilie> getImmobilien() {
        initImmobilien();

        return immobilien;
    }
  
    /**
     * Liste von Immobilien initialisieren (Persistenz v1)
     */
    private void initImmobilien() {
        if (immobilien == null) {
            Immobilie i = new Immobilie();
            i.setId(counter.getAndIncrement());
            i.setBezeichnung("firmensitz");
            i.setAddresse("beispielstrasse");
            i.setFlaeche(150);

            immobilien = new ArrayList<>();
            immobilien.add(i);
        }
    }


    /**
     * sucht mit der uebergebenen id die immobilie aus der Liste
     * @param id id der gesuchten Immobilie
     * @return falls Immobilie mit gesuchter id existiert Immobilienobjekt zurueck sonst EntityNotFoundException
     */
    public Immobilie getImmobilieById(int id) {
        return immobilien.stream().filter(immobilie -> immobilie.getId() == id)
            .findFirst()
            .orElseThrow(() -> new EntityNotFoundException(String.format("Immobilie nicht gefunden: id = %d", id)));
    }

    /**
     * fuegt falls Immobilie noch nicht vorhanden Immobilie in die Liste hinzu
     * @param immobilie Objekt das hinzugefuegt werden soll
     * @return gibt hinzugefuegtes Objekt zurueck falls noch nicht vorhanden, sonst EntityAlreadyExistsException
     */
    public Immobilie addImmobilie(Immobilie immobilie) {

        checkImmobilie(immobilie );

        immobilie.setId(counter.getAndIncrement());
        immobilien.add(immobilie);

        return immobilie;
    }
    
    /**
     * loescht anhand id die immobilie aus der Liste
     * @param id id der Immobilie die geloescht werden soll
     */
    public void deleteImmobilie(int id) {
        immobilien = immobilien.stream()
            .filter(x -> x.getId() != id)
            .collect(Collectors.toList());
    }

    /**
     * checkt ob Immobilie mit gleicher Bezeichnung und gleicher Addresse bereits existiert
     * @param immobilie
     */
    private void checkImmobilie(Immobilie immobilie) {
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
