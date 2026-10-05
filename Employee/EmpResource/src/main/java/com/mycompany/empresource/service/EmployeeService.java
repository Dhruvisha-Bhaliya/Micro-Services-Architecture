/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empresource.service;

import ejb.EmpBeanLocal;
import entity.Emp;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
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

/**
 *
 * @author DELL
 */
@Path("/emp")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeService {

    @Inject
    private EmpBeanLocal empBean;

    @GET
    @RolesAllowed({"ADMIN", "EMPLOYEE"})
    public Collection<Emp> getAllEmp(@HeaderParam("Authorization") String token) {
        return empBean.getAllEmp();
    }

    @POST
    @Path("/add")
    @RolesAllowed({"ADMIN"})
    public void addEmp(@HeaderParam("Authorization") String token, Emp e) {
        empBean.addEmp(0, e.getName(), e.getPassword(), e.getSalary(), e.getDateofjoin(), e.getMobileno());
    }

    @PUT
    @Path("/update")
    @RolesAllowed({"ADMIN"})
    public void updateEmp(@HeaderParam("Authorization") String token, Emp e) {
        empBean.updateEmp(e.getName(), e.getPassword(), e.getSalary(), e.getDateofjoin(), e.getMobileno(), e.getId());
    }

    @DELETE
    @Path("/delete/{id}")
    @RolesAllowed({"ADMIN"})
    public void deleteEmp(@HeaderParam("Authorization") String token, @PathParam("id") int id) {
        empBean.DeleteEmp(id, "", "", 0, null, 0);
    }
}
