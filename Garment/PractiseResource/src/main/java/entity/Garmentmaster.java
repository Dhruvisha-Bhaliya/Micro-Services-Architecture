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
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author root
 */
@Entity
@Table(name = "garmentmaster")
@NamedQueries({
    @NamedQuery(name = "Garmentmaster.findAll", query = "SELECT g FROM Garmentmaster g"),
    @NamedQuery(name = "Garmentmaster.findByGarmentid", query = "SELECT g FROM Garmentmaster g WHERE g.garmentid = :garmentid"),
    @NamedQuery(name = "Garmentmaster.findByGarmentname", query = "SELECT g FROM Garmentmaster g WHERE g.garmentname = :garmentname"),
    @NamedQuery(name = "Garmentmaster.findBySize", query = "SELECT g FROM Garmentmaster g WHERE g.size = :size"),
    @NamedQuery(name = "Garmentmaster.findByCategory", query = "SELECT g FROM Garmentmaster g WHERE g.category = :category"),
    @NamedQuery(name = "Garmentmaster.findByDescription", query = "SELECT g FROM Garmentmaster g WHERE g.description = :description"),
    @NamedQuery(name = "Garmentmaster.findByPrice", query = "SELECT g FROM Garmentmaster g WHERE g.price = :price"),
    @NamedQuery(name = "Garmentmaster.findByStock", query = "SELECT g FROM Garmentmaster g WHERE g.stock = :stock")})
public class Garmentmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "garmentid")
    private Integer garmentid;
    @Size(max = 100)
    @Column(name = "garmentname")
    private String garmentname;
    @Size(max = 20)
    @Column(name = "size")
    private String size;
    @Size(max = 50)
    @Column(name = "category")
    private String category;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "stock")
    private Integer stock;

    public Garmentmaster() {
    }

    public Garmentmaster(Integer garmentid) {
        this.garmentid = garmentid;
    }

    public Integer getGarmentid() {
        return garmentid;
    }

    public void setGarmentid(Integer garmentid) {
        this.garmentid = garmentid;
    }

    public String getGarmentname() {
        return garmentname;
    }

    public void setGarmentname(String garmentname) {
        this.garmentname = garmentname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (garmentid != null ? garmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garmentmaster)) {
            return false;
        }
        Garmentmaster other = (Garmentmaster) object;
        if ((this.garmentid == null && other.garmentid != null) || (this.garmentid != null && !this.garmentid.equals(other.garmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Garmentmaster[ garmentid=" + garmentid + " ]";
    }
    
}
