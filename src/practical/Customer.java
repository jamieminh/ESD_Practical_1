/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical;


/**
 *
 * @author WIN 10
 */
public class Customer {
    private int accNo;
    private String name;
//    private String = last_name;
    private double balance;

    
//    public Customer (String name, double balance) {
//        this.name = name;
//        this.balance = Math.round((balance + invokeAccBonus(3, balance))*100);
//    }
    
    public Customer(int accNo, String name, double balance){
        this.accNo = accNo;
        this.name = name;
        this.balance = Math.round((balance + invokeAccBonus(3, balance))*100) / 100.0 ;
    }
    
    private double invokeAccBonus(double bonus, double balance) {
        return balance * bonus / 100;
    }
    
       
    public void deposit(double amount) {
        this.balance += amount;
    }
    
    public boolean withdrawal(double amount) {
        if (amount > this.balance) {
            return false;
        }
        this.balance += amount;
        return true;
    }
    
    public String toString() {
        return "Account No. " + getAccNo() + " - " + 
                getName() + " - Balance: " + getBalance();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }
    
    
}
