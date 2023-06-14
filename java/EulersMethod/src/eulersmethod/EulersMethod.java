/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulersmethod;
import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author David
 */
public class EulersMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x, y, h, y1;
        int n;
        System.out.println("x?");
        x = scan.nextDouble();
        System.out.println("y?");
        y = scan.nextDouble();
        System.out.println("h?");
        h = scan.nextDouble();
        System.out.println("n?");
        n = scan.nextInt();
        
        for(int count = 1; count <= n; count++){
            y1 = y;
            y = y+h*(y+Math.cos(x));
            x += h;  
            System.out.println("y'="+y+ " for x ="+x+" and n="+count);
                     

        }
        
    }
    
}
