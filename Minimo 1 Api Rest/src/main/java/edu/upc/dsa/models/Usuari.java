package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Usuari {

    String id;
    String nom;
    boolean vacunado;
    String nombreVacuna;


    static int lastId;

    public Usuari() {
        this.id = RandomUtils.getId();//cogeremos el primer vacunado al azar
    }

    public Usuari(String nom, String id, boolean vacunado) {
        this();
        this.setId(id);
        this.setNom(nom);
        this.setVacunado(vacunado);
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getVacunado() {
        return vacunado;
    }
    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public String getNombreVacuna() { return this.nombreVacuna; }
    public void setNombreVacuna(String nombreVacuna) { this.nombreVacuna = nombreVacuna; }




    @Override
    public String toString() {
        return "Usuari [nombreUsuario="+nom+", vacunado=" + vacunado + "nombre vacuna:"
        +nombreVacuna+"]";
    }

}