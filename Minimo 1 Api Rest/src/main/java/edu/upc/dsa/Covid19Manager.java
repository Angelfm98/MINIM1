package edu.upc.dsa;

import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Vacuna;
import edu.upc.dsa.models.Usuari;

import java.util.List;

public interface Covid19Manager {


    public Vacuna addVacuna(String nombreVacuna, String fechaVacuna, String idUser);
    public Vacuna addVacuna(Vacuna t);
    public Vacuna getVacuna(String id);
    public List<Vacuna> findAllVacunas();
    public void deleteVacuna(String id);
    public Vacuna updateVacuna(Vacuna t);
    public int VacunaSize();

    public Seguimiento addSeguimiento(String nombreVacunado, String fechaVacunacion, String estadoPaciente);
    public Seguimiento addSeguimiento(Seguimiento a);
    public Seguimiento getSeguimiento(String id);
    public List<Seguimiento> findAllSeguimientos();
    public void deleteSeguimiento(String id);
    public Seguimiento updateSeguimiento(Seguimiento a);
    public int Seguimientosize();

    public Usuari addUsuari(String nom, String id, boolean vacunado);
    public Usuari addUsuari(Usuari u);
    public Usuari getUsuari(String id);
    public List<Usuari> findAllUsuaris();
    public void deleteUsuari(String id);
    public Usuari updateUsuari(Usuari u);
    public int usuarisize();


   // public List<Seguimiento> Vacunación();
   // public List<Seguimiento> SeguimientosPorUsuario(String nombreVacunado);


}
