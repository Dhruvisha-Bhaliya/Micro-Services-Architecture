/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Emp;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
@Stateless
public class EmpBean implements EmpBeanLocal {
    
    @PersistenceContext(unitName = "EMPPU")
    EntityManager em;
    
    @Override
    public void addEmp(int empid, String name, String password, double salary, Date dateofjoining, int mobileno) {
        Emp e = new Emp();
        e.setName(name);
        e.setPassword(password);
        e.setMobileno(mobileno);
        e.setSalary(salary);
        e.setDateofjoin(dateofjoining);
        em.persist(e);
    }
    
    @Override
    public void updateEmp(String name, String password, double salary, Date dateofjoining, int mobileno, int empid) {
        Emp e = em.find(Emp.class, empid);
        if (e != null) {
            e.setName(name);
            e.setPassword(password);
            e.setDateofjoin(dateofjoining);
            e.setSalary(salary);
            e.setMobileno(mobileno);
            em.merge(e);
        }
    }
    
    @Override
    public List<Emp> getAllEmp() {
        return em.createQuery("Select e FROM Emp e", Emp.class).getResultList();
    }
    
    @Override
    public void DeleteEmp(int empid, String name, String password, double salary, Date dateofjoining, int mobileno) {
        Emp e = em.find(Emp.class, empid);
        if (e != null) {
            em.remove(e);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
