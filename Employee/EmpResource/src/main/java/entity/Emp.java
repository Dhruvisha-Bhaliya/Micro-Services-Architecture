/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "emp")
@NamedQueries({
    @NamedQuery(name = "Emp.findAll", query = "SELECT e FROM Emp e"),
    @NamedQuery(name = "Emp.findById", query = "SELECT e FROM Emp e WHERE e.id = :id"),
    @NamedQuery(name = "Emp.findByName", query = "SELECT e FROM Emp e WHERE e.name = :name"),
    @NamedQuery(name = "Emp.findByPassword", query = "SELECT e FROM Emp e WHERE e.password = :password"),
    @NamedQuery(name = "Emp.findBySalary", query = "SELECT e FROM Emp e WHERE e.salary = :salary"),
    @NamedQuery(name = "Emp.findByDateofjoin", query = "SELECT e FROM Emp e WHERE e.dateofjoin = :dateofjoin"),
    @NamedQuery(name = "Emp.findByMobileno", query = "SELECT e FROM Emp e WHERE e.mobileno = :mobileno")})
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private double salary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateofjoin")
    @Temporal(TemporalType.DATE)
    private Date dateofjoin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobileno")
    private int mobileno;

    public Emp() {
    }

    public Emp(Integer id) {
        this.id = id;
    }

    public Emp(Integer id, String name, String password, double salary, Date dateofjoin, int mobileno) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salary = salary;
        this.dateofjoin = dateofjoin;
        this.mobileno = mobileno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(Date dateofjoin) {
        this.dateofjoin = dateofjoin;
    }

    public int getMobileno() {
        return mobileno;
    }

    public void setMobileno(int mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Emp[ id=" + id + " ]";
    }
    
}
