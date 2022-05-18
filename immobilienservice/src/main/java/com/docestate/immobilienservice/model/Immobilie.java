package com.docestate.immobilienservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Immobilien Model Klasse
 */

@Entity
@Table(name= "immobilien")
public class Immobilie {
    
    private int id;
    @NotNull
    @Column(name="bezeichnung")
    private String bezeichnung;
    @NotNull
    @Column(name="addresse")
    private String addresse;
    @Column(name="flaeche")
    private int flaeche;

    
    public Immobilie() {
    }

    public Immobilie(String bezeichnung, String addresse, int flaeche) {
        this.bezeichnung = bezeichnung;
        this.addresse = addresse;
        this.flaeche = flaeche;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="id", unique = true)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBezeichnung() {
        return bezeichnung;
    }
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    public String getAddresse() {
        return addresse;
    }
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
    public int getFlaeche() {
        return flaeche;
    }
    public void setFlaeche(int flaeche) {
        this.flaeche = flaeche;
    }
    @Override
    public String toString() {
        return "Immobilie [id=" + id + ", bezeichnung=" + bezeichnung + ", adresse=" + addresse + ", flaeche="
                + flaeche + " qm]";
    }

    
}
