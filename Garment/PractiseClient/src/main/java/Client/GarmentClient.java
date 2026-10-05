/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;
import model.Garmentmaster;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author root
 */
@Path("/garments")
@RegisterRestClient(configKey = "garmentClient")
public interface GarmentClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Collection<Garmentmaster> getGarments(@HeaderParam("Authorization") String token,
            @QueryParam("category") String category,
            @QueryParam("priceRange") String priceRange);

}
