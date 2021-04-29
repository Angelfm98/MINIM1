package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Seguimiento {

    String id;
    String nombreVacunado;
    String fechaVacunacion;
    String nombreVacuna;

    String estadoPaciente;
    int numeroSeguimientos;

    static int lastId;

    public Seguimiento() {
        this.id = RandomUtils.getId();//se genera random la 1a vez
    }

    public Seguimiento(String nombreVacunado, String fechaVacunacion, String estadoPaciente) {
        this();
        this.setFechaVacunacion(fechaVacunacion);
        this.setNombreVacunado(nombreVacunado);
        this.setEstadoPaciente(estadoPaciente);
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }


    public String getNombreVacunado() {
        return this.nombreVacunado;
    }
    public void setNombreVacunado(String nombreVacunado) {
        this.nombreVacunado = nombreVacunado;
    }

    public String getFechaVacunacion() {
        return this.fechaVacunacion;
    }
    public void setFechaVacunacion(String fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public String getEstadoPaciente() {
        return estadoPaciente;
    }
    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public String getNombreVacuna() { return nombreVacuna; }
    public void setNombreVacuna(String nombreVacuna) { this.nombreVacuna = nombreVacuna; }


    public int getNumeroSeguimientos() { return this.numeroSeguimientos; }

    public void setNumeroSeguimientos(int numeroSeguimientos) { this.numeroSeguimientos = numeroSeguimientos; }


    @Override
    public String toString() {
        return "Seguimiento [apellidos="+id+", nombre=" + nombreVacunado + ", fechaVacuna=" + fechaVacunacion +
                "estado del seguimiento"+estadoPaciente+"]";
    }

}