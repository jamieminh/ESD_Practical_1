/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical;
import practical.Customer;
import java.util.ArrayList;


/**
 *
 * @author WIN 10
 */
public class LandL_bank {
    private ArrayList<Customer> customers;
    
    public LandL_bank() {
        this.customers = new ArrayList<Customer>();
    }
    
    public void addCustomer(String name, double balance) {
        this.customers.add(new Customer(randAccNo(), name, balance));
    }

    
    public String deposit(int accNo, double amount) {
        Customer found = findCustomer(accNo);
        if ( found == null) {
            return "Account Not Found";
        }
        
        found.deposit(amount);
        return "Deposit Sucessful. Balance is now " + found.getBalance();
    }
    
    public String withdrawal(int accNo, double amount) {
        Customer found = findCustomer(accNo);
        if ( found == null) {
            return "Account Not Found";
        }
        
        if (!found.withdrawal(amount)) 
            return "Invalid Transaction. Balance Not Enough.";
        
        return "Withdrawl Sucessful. Balance is now " + found.getBalance();
    }
    
    private int randAccNo() {
        return (int) (Math.random() * 5000) + 1;    // random num from 1 to 1000
    }
    
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }
    
    public Customer findCustomer(int accNo) {
        for (Customer cust : this.customers) {
            if (accNo == cust.getAccNo()) {
                return cust;
            }
        }
        return null;
    }
    
    
    
}
