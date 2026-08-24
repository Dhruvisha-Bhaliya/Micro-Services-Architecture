/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author root
 */
@RegisterRestClient(configKey = "client")
@Path("/rest/example")
public interface MyRestClient {

    @GET
    @ClientHeaderParam(name = "Authorization", value = "{generateJWTToken}")
    @Produces(MediaType.TEXT_PLAIN)
    public String get();

    default String generateJWTToken() {
        Config config = ConfigProvider.getConfig();
        String token = "Bearer "
                + config.getValue("jwt-string", String.class);
        System.out.println("Sending Authorization header: " + token);
        return token;
    }
}
