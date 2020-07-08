/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Mu Di
 */
public class Book {
    private String name;
    private String auther;
    private String price;
    private int quantity;
    private String description;
    private String status; 
    private String category;
    
    public Book(){
        
    }
    public Book(String name,String auther,String price,int quantity,String description,String status, String category){
        this.name=name;
        this.auther=auther;
        this.price=price;
        this.quantity=quantity;
        this.description=description;
        this.status=status;
        this.category=category;
    }
    public void solidBook(){
        this.quantity-=1;
    }
    public void setStatusUnavailable(){
        status="Unavailable";
    }

    public String getName() {
        return name;
    }

    public String getAuther() {
        return auther;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
