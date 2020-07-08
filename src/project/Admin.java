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
public class Admin extends User{

    
    public Admin(String username, String email, String password) {
        super(username, email, password);
    }

    Admin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void AddNewBook(String name,String auther,String price,int quantity,String description,String status,String cat)
    {
        Book b=new Book(name, auther, price, quantity, description, status,cat);
    }
    public void EditBook(String name,String auther,String price,int quantity,String description,String status)
    {
        Book b=new Book();
        b.setName(name);
        b.setAuther(auther);
        b.setPrice(price);
        b.setQuantity(quantity);
        b.setDescription(description);
        b.setStatus(status);
    }
    
    
    
    
}
