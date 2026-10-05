/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import client.EmpClient;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Emp;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author DELL
 */
@WebServlet(name = "EmpServlet", urlPatterns = {"/EmpServlet"})
public class EmpServlet extends HttpServlet {

    @Inject
    @RestClient
    EmpClient empClient;

    @Inject
    @ConfigProperty(name = "jwt.token")
    String token;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String op = request.getParameter("op");

            if ("del".equals(op)) {
                empClient.deleteEmp(token, Integer.parseInt(request.getParameter("id")));
            }

            if ("add".equals(op) || "upd".equals(op)) {
                Emp e = new Emp();
                e.setName((request.getParameter("name")));
                e.setPassword((request.getParameter("password")));
                e.setDateofjoin(new java.util.Date());
                e.setSalary((Double.parseDouble(request.getParameter("salary"))));
                e.setMobileno(Integer.parseInt(request.getParameter("mobileno")));

                if ("add".equals(op)) {
                    empClient.addEmp(token, e);
                } else {
                    e.setId(Integer.parseInt(request.getParameter("id")));
                    empClient.updateEmp(token, e);
                }
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='EmpServlet'>");
            out.println("ID (For Update): <input name='id'><br>");
            out.println("Name: <input name='name'><br>");
            out.println("Password: <input type='password' name='password'><br>");
            out.println("Salary: <input name='salary'><br>");
            out.println("Mobile No: <input name='mobileno'><br><br>");
            out.println("<button name='op' value='add'>Add</button>");
            out.println("<button name='op' value='upd'>Update</button>");
            out.println("</form><hr>");

            out.println("<table border='1'>");
            for (Emp e : empClient.getAllEmp(token)) {
                out.println("<tr>");
                out.println("<td>" + e.getId() + "</td>");
                out.println("<td>" + e.getName() + "</td>");
                out.println("<td>" + e.getSalary() + "</td>");
                out.println("<td>" + e.getMobileno() + "</td>");
                out.println("<td><a href='EmpServlet?op=del&id=" + e.getId() + "'>Delete</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<h1>Servlet EmpServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
