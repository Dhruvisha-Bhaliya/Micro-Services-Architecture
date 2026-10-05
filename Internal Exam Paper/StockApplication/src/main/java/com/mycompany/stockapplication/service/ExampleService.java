package com.mycompany.stockapplication.service;

import ejb.StockBeanLocal;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;
import model.Stocks;

@Path("/example")
public class ExampleService {

    @EJB
    StockBeanLocal stockbean;

    @GET
    @RolesAllowed("STOCKUSER")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Stocks> getStocks(
            @QueryParam("category") String category,
            @QueryParam("fromDate") String fromDate,
            @QueryParam("toDate") String toDate) {
        return stockbean.getStocks(category, fromDate, toDate);
    }
}
