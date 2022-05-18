package com.docestate.immobilienservice.model;

import javax.validation.constraints.NotBlank;

/**
 * Immobilien Model Klasse
 */
public class Immobilie {
    private int id;
    @NotBlank
    private String bezeichnung;
    @NotBlank
    private String addresse;
    private int flaeche;

    
    public Immobilie() {
    }

    public Immobilie(String bezeichnung, String addresse, int flaeche) {
        this.bezeichnung = bezeichnung;
        this.addresse = addresse;
        this.flaeche = flaeche;
    }

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
