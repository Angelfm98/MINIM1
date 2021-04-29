package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Seguimiento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/seguimientos", description = "Endpoint to Seguimiento Service")
@Path("/seguimientos")
public class SeguimientosService {

    private Covid19Manager tm;

    public SeguimientosService() {
        this.tm = Covid19ManagerImpl.getInstance();
        if (tm.VacunaSize()==0) {
            this.tm.addSeguimiento("Angel", "29/04", "bien");
            this.tm.addSeguimiento("Maria", "27/03", "cefalea y fiebre, habrá más seguimiento");
            this.tm.addSeguimiento("Trinidad", "23/04", "después de una noche de fiebre, perfecta");
        }
    }

    @GET
    @ApiOperation(value = "get all Seguimientos", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Seguimiento.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSeguimientos() {

        List<Seguimiento> seguimientos = this.tm.findAllSeguimientos();

        GenericEntity<List<Seguimiento>> entity = new GenericEntity<List<Seguimiento>>(seguimientos) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get an Seguimiento", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Seguimiento.class),
            @ApiResponse(code = 404, message = "Vacuna not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlbum(@PathParam("id") String id) {
        Seguimiento a = this.tm.getSeguimiento(id);
        if (a == null) return Response.status(404).build();
        else  return Response.status(201).entity(a).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Seguimiento", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Vacuna not found")
    })
    @Path("/{id}")
    public Response deleteAlbum(@PathParam("id") String id) {
        Seguimiento a = this.tm.getSeguimiento(id);
        if (a == null) return Response.status(404).build();
        else this.tm.deleteSeguimiento(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update an Seguimiento", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Vacuna not found")
    })
    @Path("/")
    public Response updateAlbum(Seguimiento seguimiento) {

        Seguimiento a = this.tm.updateSeguimiento(seguimiento);

        if (a == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Seguimiento", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Seguimiento.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newSeguimiento(Seguimiento seguimiento) {

        if (seguimiento.getFechaVacunacion()==null || seguimiento.getNombreVacunado()==null)  return Response.status(500).entity(seguimiento).build();
        this.tm.addSeguimiento(seguimiento);
        return Response.status(201).entity(seguimiento).build();
    }

}
