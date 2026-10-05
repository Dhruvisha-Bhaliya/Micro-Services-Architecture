/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practiseresource.service;

import ejb.GarmentBeanLocal;
import entity.Garmentmaster;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;

/**
 *
 * @author root
 */
@Path("/garments")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GarmentService {

    @Inject
    private GarmentBeanLocal garmentBean;

    @GET
    @RolesAllowed({"OWNER"})
    public Collection<Garmentmaster> getGarments(
            @HeaderParam("Authorization") String token,
            @QueryParam("category") String category,
            @QueryParam("priceRange") String priceRange) {
        return garmentBean.getGarments(category, priceRange);
    }

}
