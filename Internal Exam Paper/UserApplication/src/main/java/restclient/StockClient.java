/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;
import model.Stocks;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author DELL
 */
@ApplicationScoped
@RegisterRestClient(configKey = "stockClient")
public interface StockClient {

    @GET
    @Path("/example")
    @ClientHeaderParam(name = "Authorization", value = "{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Stocks> getStocks(
            @QueryParam("category") String category,
            @QueryParam("fromDate") String fromDate,
            @QueryParam("toDate") String toDate);

    default String generateJWTToken() {
        Config config = ConfigProvider.getConfig();
        String token = "Bearer " + config.getValue("jwt-string", String.class);
        return token;
    }
}
