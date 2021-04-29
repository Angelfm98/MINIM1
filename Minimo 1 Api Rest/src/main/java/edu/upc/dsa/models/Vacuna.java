package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Vacuna {

    String nombreVacuna;
    String fechaVacuna;
    String idUser;
    int numVacunas =0;
    static int lastId;

    public Vacuna() {
        this.nombreVacuna = RandomUtils.getId();
    }

    public Vacuna(String fechaVacuna, String nombreVacuna, String idUser) {
        this();
        this.setNombreVacuna(nombreVacuna);
        this.setFechaVacuna(fechaVacuna);
        this.setIdUser(idUser);
        this.numVacunas =0;
    }

    public String getNombreVacuna() {
        return this.nombreVacuna;
    }
    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }


    public String getFechaVacuna() {
        return fechaVacuna;
    }
    public void setFechaVacuna(String fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public String getIdUser() { return idUser; }
    public void setIdUser(String idUser) { this.idUser = idUser; }



    @Override
    public String toString() {
        return "Vacuna [nombreVacuna="+ nombreVacuna +", fechaVacuna=" + fechaVacuna + "]";
    }

}