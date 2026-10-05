/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Garmentmaster;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.Collection;

/**
 *
 * @author root
 */
@Stateless
public class GarmentBean implements GarmentBeanLocal {

    @PersistenceContext(unitName = "com.mycompany_PractiseResource_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Override
    public Collection<Garmentmaster> getGarments(String category, String priceRange) {

        double minPrice = 0.0;
        double maxPrice = Double.MAX_VALUE;

        if (priceRange != null) {
            if (priceRange.equals("500-1000")) {
                minPrice = 500.0;
                maxPrice = 1000.0;
            } else if (priceRange.equals("1001-1500")) {
                minPrice = 1001.0;
                maxPrice = 1500.0;
            } else if (priceRange.equals(">1500")) {
                minPrice = 1501.0;
                maxPrice = Double.MAX_VALUE;
            }

        }
        String jpql = "SELECT g FROM Garmentmaster g WHERE g.category = :category AND g.price >= :minPrice AND g.price <= :maxPrice AND g.stock > 0";
        TypedQuery<Garmentmaster> query = em.createQuery(jpql, Garmentmaster.class);
        query.setParameter("category", category);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);

        return query.getResultList();
    }
}
