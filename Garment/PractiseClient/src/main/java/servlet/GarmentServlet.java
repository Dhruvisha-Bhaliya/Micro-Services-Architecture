/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Client.GarmentClient;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;
import model.Garmentmaster;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author root
 */
@WebServlet(name = "GarmentServlet", urlPatterns = {"/GarmentServlet"})
public class GarmentServlet extends HttpServlet {

    @Inject
    @RestClient
    private GarmentClient garmentClient;

    @Inject
    @ConfigProperty(name = "jwt.token")
    private String jwtToken;

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GarmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GarmentServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String category = request.getParameter("category");
        String priceRange = request.getParameter("priceRange");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Garment Search</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // 1. Render Search Form
        out.println("<h2>Garment Category & Price Search</h2>");
        out.println("<form action='GarmentServlet' method='GET'>");

        out.println("<label for='category'>Category: </label>");
        out.println("<select name='category' id='category' required>");
        out.println("<option value='mens wear' " + ("mens wear".equals(category) ? "selected" : "") + ">Mens Wear</option>");
        out.println("<option value='women wear' " + ("women wear".equals(category) ? "selected" : "") + ">Women Wear</option>");
        out.println("<option value='children wear' " + ("children wear".equals(category) ? "selected" : "") + ">Children Wear</option>");
        out.println("</select> ");

        out.println("<label for='priceRange'>Price Range: </label>");
        out.println("<select name='priceRange' id='priceRange' required>");
        out.println("<option value='500-1000' " + ("500-1000".equals(priceRange) ? "selected" : "") + ">500 - 1000</option>");
        out.println("<option value='1001-1500' " + ("1001-1500".equals(priceRange) ? "selected" : "") + ">1001 - 1500</option>");
        out.println("<option value='>1500' " + (">1500".equals(priceRange) ? "selected" : "") + ">&gt; 1500</option>");
        out.println("</select> ");

        out.println("<input type='submit' value='Search Garments'>");
        out.println("</form>");

        // 2. Process REST API Call & Display Output Table when Form is Submitted
        if (category != null && priceRange != null) {
            try {
                Collection<Garmentmaster> garments = garmentClient.getGarments(jwtToken, category, priceRange);

                out.println("<h3>Available Garments</h3>");
                if (garments == null || garments.isEmpty()) {
                    out.println("<p>No available in-stock garments found for the selected criteria.</p>");
                } else {
                    out.println("<table>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>Name</th>");
                    out.println("<th>Size</th>");
                    out.println("<th>Description</th>");
                    out.println("<th>Price</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");

                    for (Garmentmaster g : garments) {
                        out.println("<tr>");
                        out.println("<td>" + g.getGarmentname() + "</td>");
                        out.println("<td>" + g.getSize() + "</td>");
                        out.println("<td>" + g.getDescription() + "</td>");
                        out.println("<td>₹" + g.getPrice() + "</td>");
                        out.println("</tr>");
                    }

                    out.println("</tbody>");
                    out.println("</table>");
                }
            } catch (jakarta.ws.rs.WebApplicationException e) {
                int status = e.getResponse().getStatus();
                out.println("<p style='color:red;'>HTTP Error Status: <b>" + status + "</b> (" + e.getMessage() + ")</p>");
                e.printStackTrace();
            } catch (Exception e) {
                out.println("<p style='color:red;'>Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage() + "</p>");
                e.printStackTrace();
            }
        }

        out.println("</body>");
        out.println("</html>");
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
