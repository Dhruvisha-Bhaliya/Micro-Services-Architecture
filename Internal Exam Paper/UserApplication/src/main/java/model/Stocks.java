/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "stocks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stocks.findAll", query = "SELECT s FROM Stocks s"),
    @NamedQuery(name = "Stocks.findByStockid", query = "SELECT s FROM Stocks s WHERE s.stockid = :stockid"),
    @NamedQuery(name = "Stocks.findByCompany", query = "SELECT s FROM Stocks s WHERE s.company = :company"),
    @NamedQuery(name = "Stocks.findByStockdate", query = "SELECT s FROM Stocks s WHERE s.stockdate = :stockdate"),
    @NamedQuery(name = "Stocks.findByClosingprice", query = "SELECT s FROM Stocks s WHERE s.closingprice = :closingprice"),
    @NamedQuery(name = "Stocks.findBySensexClosingValue", query = "SELECT s FROM Stocks s WHERE s.sensexClosingValue = :sensexClosingValue")})
public class Stocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stockid")
    private Integer stockid;
    @Size(max = 100)
    @Column(name = "company")
    private String company;
    @Column(name = "stockdate")
    @Temporal(TemporalType.DATE)
    private Date stockdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "closingprice")
    private Double closingprice;
    @Column(name = "sensexClosingValue")
    private Double sensexClosingValue;
    @JoinColumn(name = "catid", referencedColumnName = "catid")
    @ManyToOne
    private Category catid;

    public Stocks() {
    }

    public Stocks(Integer stockid) {
        this.stockid = stockid;
    }

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getStockdate() {
        return stockdate;
    }

    public void setStockdate(Date stockdate) {
        this.stockdate = stockdate;
    }

    public Double getClosingprice() {
        return closingprice;
    }

    public void setClosingprice(Double closingprice) {
        this.closingprice = closingprice;
    }

    public Double getSensexClosingValue() {
        return sensexClosingValue;
    }

    public void setSensexClosingValue(Double sensexClosingValue) {
        this.sensexClosingValue = sensexClosingValue;
    }

    public Category getCatid() {
        return catid;
    }

    public void setCatid(Category catid) {
        this.catid = catid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockid != null ? stockid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stocks)) {
            return false;
        }
        Stocks other = (Stocks) object;
        if ((this.stockid == null && other.stockid != null) || (this.stockid != null && !this.stockid.equals(other.stockid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Stocks[ stockid=" + stockid + " ]";
    }
    
}
