package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Usuari {

    String id;
    String nom;
    String pwd;

    static int lastId;

    public Usuari() {
        this.id = RandomUtils.getId();//al igual que en album, solo random la 1a vz
    }

    public Usuari(String nom, String pwd) {
        this();
        this.setPwd(pwd);
        this.setNom(nom);
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Usuari [id="+id+", nom=" + nom + ", pwd=" + pwd +"]";
    }

}