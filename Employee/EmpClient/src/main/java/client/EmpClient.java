/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;
import model.Emp;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author DELL
 */
@Path("/emp")
@RegisterRestClient(configKey = "empClient")
public interface EmpClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Collection<Emp> getAllEmp(@HeaderParam("Authorization") String token);

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmp(@HeaderParam("Authorization") String token, Emp e);

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmp(@HeaderParam("Authorization") String token, Emp e);

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteEmp(@HeaderParam("Authorization") String token, @PathParam("id") int id);

}
