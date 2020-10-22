/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author zZMerciZz
 */
public class ArrayINOUT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int[] rangeOccur = new int[10];
        try {
            File myFile = new File("src/Exercise2/grades.txt");
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
        
        
    }
    
}
