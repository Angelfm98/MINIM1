package edu.upc.dsa;

import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Vacuna;
import java.util.LinkedList;
import java.util.List;
import edu.upc.dsa.models.Usuari;
import org.apache.log4j.Logger;
import org.w3c.dom.Text;

import java.util.*;
import java.util.Collections;
import java.util.HashMap;

public class Covid19ManagerImpl implements Covid19Manager {


    private static Covid19Manager instance;
    protected ArrayList<Vacuna> vacunas;
    protected List<Seguimiento> seguimientos;
    protected List<Usuari> usuaris;

    HashMap<String, Usuari> hmUsers=new HashMap<String, Usuari>();


    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);


    private Covid19ManagerImpl() {
        this.vacunas = new ArrayList<>();
        this.seguimientos = new LinkedList<>();
        this.usuaris= new LinkedList<>();
    }

    public static Covid19Manager getInstance() {
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }
                                    //vacunas
    public int VacunaSize() {
        int ret = this.vacunas.size();
        logger.info("size " + ret);

        return ret;
    }

    public Vacuna addVacuna(Vacuna t) {
        logger.info("new Vacuna " + t);

        this.vacunas.add (t);
        logger.info("new Vacuna added");
        return t;
    }

    public Vacuna addVacuna(String nombreVacuna , String fechaVacuna, String idUser) {
        return this.addVacuna(new Vacuna(nombreVacuna, fechaVacuna, idUser));
    }

    public Vacuna getVacuna(String id) {
        logger.info("getVacuna("+id+")");

        for (Vacuna t: this.vacunas) {
            if (t.getNombreVacuna().equals(id)) {
                logger.info("getVacuna("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Vacuna> findAllVacunas() {
        return this.vacunas;
    }

    @Override
    public void deleteVacuna(String id) {

        Vacuna t = this.getVacuna(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.vacunas.remove(t);

    }

    @Override
    public Vacuna updateVacuna(Vacuna p) {
        Vacuna t = this.getVacuna(p.getNombreVacuna());

        if (t!=null) {
            logger.info(p+" received ");

            t.setNombreVacuna(p.getNombreVacuna());
            t.setFechaVacuna(p.getFechaVacuna());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }

    public int Vacunasize() {
        int ret = this.vacunas.size();
        logger.info("size " + ret);

        return ret;
    }

                                                        // Seguimientos
    public Seguimiento addSeguimiento(Seguimiento a) {
        logger.info("new Seguimiento " + a);

        this.seguimientos.add (a);
        logger.info("new Seguimiento added");
        return a;
    }

    public Seguimiento addSeguimiento(String nombreVacunado, String fechaVacunacion, String estadoPaciente) {
        return this.addSeguimiento(new Seguimiento(nombreVacunado, fechaVacunacion, estadoPaciente));
    }

    public Seguimiento getSeguimiento(String id) {
        logger.info("getSeguimiento("+id+")");

        for (Seguimiento a: this.seguimientos) {
            if (a.getId().equals(id)) {
                logger.info("getSeguimiento("+id+"): "+a);

                return a;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Seguimiento> findAllSeguimientos() {
        return this.seguimientos;
    }

    @Override
    public void deleteSeguimiento(String id) {

        Seguimiento a = this.getSeguimiento(id);
        if (a==null) {
            logger.warn("not found " + a);
        }
        else logger.info(a+" deleted ");

        this.seguimientos.remove(a);

    }

    @Override
    public Seguimiento updateSeguimiento(Seguimiento s) {
        Seguimiento seguimiento = this.getSeguimiento(s.getId());

        if (seguimiento !=null) {
            logger.info(s+" received ");

            seguimiento.setFechaVacunacion(s.getFechaVacunacion());
            seguimiento.setNombreVacunado(s.getNombreVacunado());

            logger.info(seguimiento +" updated ");
        }
        else {
            logger.warn("not found "+s);
        }

        return seguimiento;
    }

    public int Seguimientosize() {
        int ret = this.seguimientos.size();
        logger.info("size " + ret);

        return ret;
    }
                                                 //users
    public Usuari addUsuari(Usuari u) {
        logger.info("new Usuari " + u);

        this.usuaris.add (u);
        logger.info("new User added");
        return u;
    }

    public Usuari addUsuari(String nom, String id, boolean vacunado) {
        return this.addUsuari(new Usuari(nom, id, vacunado));
    }

    public Usuari getUsuari(String id) {
        logger.info("getUsuari("+id+")");

        for (Usuari u: this.usuaris) {
            if (u.getId().equals(id)) {
                logger.info("getUsuari("+id+"): "+u);

                return u;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Usuari> findAllUsuaris() {
        return this.usuaris;
    }

    @Override
    public void deleteUsuari(String id) {

        Usuari u = this.getUsuari(id);
        if (u==null) {
            logger.warn("not found " + u);
        }
        else logger.info(u+" deleted ");

        this.usuaris.remove(u);

    }

    @Override
    public Usuari updateUsuari(Usuari s) {
        Usuari usuari = this.getUsuari(s.getId());

        if (usuari!=null) {
            logger.info(s+" received ");

            usuari.setId(s.getId());
            usuari.setNom(s.getNom());

            logger.info(usuari +" updated ");
        }
        else {
            logger.warn("not found "+s);
        }

        return usuari;
    }

    public int usuarisize() {
        int ret = this.usuaris.size();
        logger.info("size " + ret);

        return ret;
    }





}