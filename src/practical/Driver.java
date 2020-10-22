/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 *
 * @author WIN 10
 */
public class Driver {
    public static void main(String[] args) {
        // Exercise 1:
        Scanner input = new Scanner(System.in);
        System.out.println("Enter triangle lengths, separated by a space: ");
        String lengths = input.nextLine();
        
        int[] lens = Arrays.stream(lengths.split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Triangle triangle1 = new Triangle(lens[0], lens[1], lens[2]);
        System.out.println(triangle1.evalTriangle());
        
        // Exercise 2:
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int[] rangeOccur = new int[10];
        
        try {
            File myFile = new File("src/practical/grades.txt");
            Scanner fileReader = new Scanner(myFile);
            while (fileReader.hasNextLine()) {
                int data = Integer.parseInt(fileReader.nextLine());
                nums.add(data);
            }
            fileReader.close();
        }
        catch(FileNotFoundException e) {
            System.err.println(e);
        }
        System.out.println(Arrays.toString(nums.toArray()));
        
        for (int i=0; i<nums.size(); i++) {
            int range = nums.get(i) / 10;;
            if (nums.get(i) % 10 == 0) {
                range-- ;
            }
            rangeOccur[range] += 1;
        }
        
        System.out.println(Arrays.toString(rangeOccur));
        
        for (int i=0; i<10; i++) {
//            char[] chars = new char[rangeOccur[i]];
//            Arrays.fill(chars, '*');
//            String str = new String(chars);
            String str = new String(new char[rangeOccur[i]]).replace("\0", "*");
            System.out.println( i+"1 - " + (i+1) + "0   | " + str);
        }
        
        
        // Exercise 3
        LandL_bank bank = new LandL_bank();

        try {
            File accounts = new File("src/practical/accounts.txt");
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
