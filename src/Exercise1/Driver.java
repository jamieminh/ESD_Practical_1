/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise1;
import Exercise3.Customer;
import Exercise3.LandL_bank;
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
        
        
    }
    
    
    
}
