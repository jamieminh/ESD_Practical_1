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
public class Triangle {
    int x;
    int y;
    int z;
    
    public Triangle(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public String evalTriangle() {
        if (!checkTriangle()) {
            return "Not a Triangle";
        }
        if ( (x == y) & (y == z) & (x == z) ) {
            return "Equilateral";
        }
        if ( (x == y) || (y == z) || (x == z) ) {
            return "Isosceles";
        }
        return "Scalene";
    }
    
    public boolean checkTriangle() {
        if ( (x+y <= z) || (y+z <= x) || (x+z <= y) ) {
            return false;
        }
        return true;
    }
}
