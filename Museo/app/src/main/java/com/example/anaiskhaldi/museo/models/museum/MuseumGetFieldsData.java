package com.example.anaiskhaldi.museo.models.museum;

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

}
