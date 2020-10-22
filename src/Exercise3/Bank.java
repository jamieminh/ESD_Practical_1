/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author zZMerciZz
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Exercise 3
        LandL_bank bank = new LandL_bank();

        try {
            File accounts = new File("src/Exercise3/accounts.txt");
            Scanner reader = new Scanner(accounts);
            while (reader.hasNextLine()) {
                String[] info = reader.nextLine().split(" ");
                bank.addCustomer(info[0], Double.parseDouble(info[1]));
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        
        
        Scanner scanner = new Scanner(System.in);
        int option;
        int accNo;
        double amount;
        do {
            System.out.println("---------------------------------"
                    + "\nMain Menu"
                    + "\n0. Exit"
                    + "\n1. Display all Accounts"
                    + "\n2. Search By Account"
                    + "\n3. Account Deposit"
                    + "\n4. Account Withdrawal"
                    + "\n5. Add New Account");
            System.out.print("What do you want to do? ");
            option = scanner.nextInt();
            
            switch(option) {
                case 1:
                    bank.getCustomers().forEach((customer) -> System.out.println(customer.toString()));
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = scanner.nextInt();
                    Customer found = bank.findCustomer(accNo);
                    if (found == null) 
                        System.out.println("Account Not Found.");
                    else 
                        System.out.println(found.toString());
                    
                    break;
                case 3: 
                    System.out.print("Enter Account Number: ");
                    accNo = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    amount = scanner.nextDouble();
                    System.out.print(bank.deposit(accNo, amount));
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    amount = scanner.nextDouble();
                    System.out.print(bank.withdrawal(accNo, amount));
                    break;
                case 5:
                    System.out.print("Enter Account Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Account Balance: ");
                    amount = scanner.nextDouble();
                    bank.addCustomer(name, amount);
                    System.out.print("Account Added");
                    break;
                default:
                    System.out.print("See You Later....");
            }
            
        }
        while (option != 0);
    }
    
}
