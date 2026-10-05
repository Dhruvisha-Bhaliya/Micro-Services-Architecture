/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.sql.Date;
import java.util.Collection;
import model.Stocks;

/**
 *
 * @author DELL
 */
@Stateless
public class StockBean implements StockBeanLocal {

    @PersistenceContext(unitName = "StockPU")
    EntityManager em;

    @Override
    public Collection<Stocks> getStocks(String category, String fromDate, String toDate) {
        String jpql = "SELECT s FROM Stocks s WHERE s.catid.catname = :cat "
                + "AND s.stockdate BETWEEN :fromDate AND :toDate";

        return em.createQuery(jpql, Stocks.class)
                .setParameter("cat", category)
                .setParameter("fromDate", Date.valueOf(fromDate))
                .setParameter("toDate", Date.valueOf(toDate))
                .getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
