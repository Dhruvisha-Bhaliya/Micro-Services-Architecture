/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author root
 */

public class Garmentmaster {

   
    private Integer garmentid;
   
    private String garmentname;
   
    private String size;
  
    private String category;
   
    private String description;
  
    private Double price;
   
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

   
    
}
