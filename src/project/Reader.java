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
public class Reader extends User{

    private String phone;
    private String address;
    private String payment;
    
    public Reader(String username, String email, String password,String phone,String address,String payment) {
        super(username, email, password);
        this.phone=phone;
        this.address=address;
        this.payment=payment;
    }

    public Reader() {
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPayment() {
        return payment;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
    
    
    
}
