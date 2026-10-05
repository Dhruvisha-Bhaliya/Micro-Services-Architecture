/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Emp;
import jakarta.ejb.Local;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
@Local
public interface EmpBeanLocal {

    void addEmp(int empid, String name, String password, double salary, Date dateofjoining, int mobileno);

    void updateEmp(String name, String password, double salary, Date dateofjoining, int mobileno,int empid);

    List<Emp> getAllEmp();

    void DeleteEmp(int empid, String name, String password, double salary, Date dateofjoining, int mobileno);

}
