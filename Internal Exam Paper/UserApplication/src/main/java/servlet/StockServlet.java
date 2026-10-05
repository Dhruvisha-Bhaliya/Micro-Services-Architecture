/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;
import model.Stocks;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import restclient.StockClient;

/**
 *
 * @author DELL
 */
@WebServlet(name = "StockServlet", urlPatterns = {"/StockServlet"})
public class StockServlet extends HttpServlet {

    @Inject
    @RestClient
    StockClient stockclient;

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
        PrintWriter out = response.getWriter();

        String cat = request.getParameter("category");
        String from = request.getParameter("fromDate");
        String to = request.getParameter("toDate");

        out.println("<!DOCTYPE html><html><body>");

        // Step 1: Dynamic Input Form
        if (cat == null || from == null || to == null) {
            out.println("<h2>Search Stock Records</h2>");
            out.println("<form action='StockServlet' method='GET'>");
            out.println("Category: <input type='text' name='category' placeholder='Enter Category' required><br><br>");
            out.println("From Date: <input type='date' name='fromDate' required><br><br>");
            out.println("To Date: <input type='date' name='toDate' required><br><br>");
            out.println("<input type='submit' value='Search'>");
            out.println("</form>");
        } // Step 2: Fetch and Display Results dynamically
        else {
            out.println("<h2>Stock Results for " + cat + "</h2>");

            try {
                Collection<Stocks> stocks = stockclient.getStocks(cat, from, to);

                if (stocks != null && !stocks.isEmpty()) {
                  out.println("<table border='1' cellpadding='8'>");
                    out.println("<tr>");
                    out.println("<th>Stock ID</th>");
                    out.println("<th>Company</th>");
                    out.println("<th>Stock Date</th>");
                    out.println("<th>Closing Price</th>");
                    out.println("<th>Category ID</th>");
                    out.println("<th>Sensex Value</th>");
                    out.println("</tr>");
                  for (Stocks s : stocks) {
                        out.println("<tr>");
                        out.println("<td>" + s.getStockid() + "</td>");
                        out.println("<td>" + s.getCompany() + "</td>");
                        out.println("<td>" + s.getStockdate() + "</td>");
                        out.println("<td>" + s.getClosingprice() + "</td>");
                        out.println("<td>" + s.getCatid() + "</td>");
                        out.println("<td>" + s.getSensexClosingValue() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } else {
                    out.println("<p style='color:red;'>No stock records found for: " + cat + "</p>");
                }
            } catch (Exception e) {
                out.println("<p style='color:red;'>Error fetching data: " + e.getMessage() + "</p>");
            }

            out.println("<br><a href='StockServlet'>Back to Search</a>");
        }

        out.println("</body></html>");
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
