package com.example.anaiskhaldi.museo.models;

/**
 * Created by Adeline on 12/07/2017.
 */

class MuseumGetFieldsData {

    public String periode_ouverture;
    public String nom_du_musee;
    public String adr;
    public String ville;
    public String nomreg;
    public String ferme;
    public String siteweb;
    public String cp;
    public String nomdep;


    @Override
    public String toString() {
        return "MuseumGetFieldsData{" +
                "periode_ouverture='" + periode_ouverture + '\'' +
                ", nom_du_musee='" + nom_du_musee + '\'' +
                ", adr='" + adr + '\'' +
                ", ville='" + ville + '\'' +
                ", nomreg='" + nomreg + '\'' +
                ", ferme='" + ferme + '\'' +
                ", siteweb='" + siteweb + '\'' +
                ", cp='" + cp + '\'' +
                ", nomdep='" + nomdep + '\'' +
                '}';
    }

    public String getPeriode_ouverture() {
        return periode_ouverture;
    }

    public void setPeriode_ouverture(String periode_ouverture) {
        this.periode_ouverture = periode_ouverture;
    }

    public String getNom_du_musee() {
        return nom_du_musee;
    }

    public void setNom_du_musee(String nom_du_musee) {
        this.nom_du_musee = nom_du_musee;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNomreg() {
        return nomreg;
    }

    public void setNomreg(String nomreg) {
        this.nomreg = nomreg;
    }

    public String getFerme() {
        return ferme;
    }

    public void setFerme(String ferme) {
        this.ferme = ferme;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getNomdep() {
        return nomdep;
    }

    public void setNomdep(String nomdep) {
        this.nomdep = nomdep;
    }
}
