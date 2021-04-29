package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Vacuna;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/vacunas", description = "Endpoint to Vacuna Service")
@Path("/vacunas")
public class VacunasService {

    private Covid19Manager tm;

    public VacunasService() {
        this.tm = Covid19ManagerImpl.getInstance();
        if (tm.VacunaSize()==0) {
            this.tm.addVacuna("Pfizer", "29/04", "Franco Martos");
            this.tm.addVacuna("Moderna", "27/03", "Fàbrega Roig");
            this.tm.addVacuna("Astrazeneca", "23/04", "Pancorbo Garrido");
        }


    }

    @GET
    @ApiOperation(value = "get all Vacuna", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Vacuna.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacunas() {

        List<Vacuna> vacunas = this.tm.findAllVacunas();

        GenericEntity<List<Vacuna>> entity = new GenericEntity<List<Vacuna>>(vacunas) {};
        return Response.status(201).entity(entity).build()  ;
    }

    @GET
    @ApiOperation(value = "get a Vacuna", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Vacuna.class),
            @ApiResponse(code = 404, message = "Vacuna not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Vacuna t = this.tm.getVacuna(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Vacuna", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Vacuna not found")
    })
    @Path("/{id}")
    public Response deleteVacuna(@PathParam("id") String id) {
        Vacuna t = this.tm.getVacuna(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteVacuna(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Vacuna", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Vacuna not found")
    })
    @Path("/")
    public Response updateTrack(Vacuna vacuna) {

        Vacuna t = this.tm.updateVacuna(vacuna);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Vacuna", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Vacuna.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Vacuna vacuna) {

        if (vacuna.getNombreVacuna()==null || vacuna.getFechaVacuna()==null)  return Response.status(500).entity(vacuna).build();
        this.tm.addVacuna(vacuna);
        return Response.status(201).entity(vacuna).build();
    }

}