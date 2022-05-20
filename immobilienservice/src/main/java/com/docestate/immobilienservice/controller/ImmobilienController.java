package com.docestate.immobilienservice.controller;

import java.util.List;
import javax.validation.Valid;
import com.docestate.immobilienservice.model.Immobilie;
import com.docestate.immobilienservice.service.ImmobilienService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller der Immobilien
 */

@RestController
@RequestMapping("/immobilien")
public class ImmobilienController {

    private final ImmobilienService immobilienService;
    
    public ImmobilienController(ImmobilienService immobilienService) {
        this.immobilienService = immobilienService;
    }

    /**
     * GET-Anfrage auf '/immobilien'
     * @return Liste aller Immobilien + Status 200
     */
    @GetMapping
    public ResponseEntity<List<Immobilie>> getImmobilien() {
        List<Immobilie> immobilien = immobilienService.getImmobilien();
        return new ResponseEntity<>(immobilien, HttpStatus.OK);
    }

    /**
     * GET-Anfrage auf '/immobilien/{id}''
     * @param id gesuchte id der immobilie
     * @return immobile wenn vorhanden mit 302 FOUND, sonst EntityNotFoundException mit 404 NOT_FOUND
     */
    @GetMapping("/{id}")
    public ResponseEntity<Immobilie> getImmobilieById(@PathVariable int id) {
        Immobilie immobilie = immobilienService.getImmobilieById(id);
        return new ResponseEntity<>(immobilie, HttpStatus.FOUND);
    }

    /**
     * POST-Anfrage auf '/immobilien'
     * fuegt Immobilien Objekt in die Liste
     * @param immobilie RequestBody der Immobile
     * @return gibt die hinzugefuegte Immobiilie und 201 zurueck, wenn schon vorhanden EntityAlreadyExistsException mit 409 CONFLICT
     */
    @PostMapping
    public ResponseEntity<Immobilie> addImmobilie(@Valid @RequestBody Immobilie immobilie) {
        Immobilie hinzugefuegt = immobilienService.addImmobilie(immobilie);
        return new ResponseEntity<>(hinzugefuegt, HttpStatus.CREATED);
    }

    /**
     * DELETE-Anfrage auf '/immobilien'
     * loescht anhand der id die immobilie aus der Liste
     * @param id id der zu loeschenden Immobilie
     * @return null Objekt und 200 Status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Immobilie> deleteImmobilie(@PathVariable int id) {
        immobilienService.deleteImmobilie(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
