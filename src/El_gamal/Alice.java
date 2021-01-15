/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package El_gamal;

/**
 *
 * @author Student
 */
import java.lang.Math;
import static java.lang.Math.pow;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Alice {
    Scanner s = new Scanner(System.in);
    public String msg;
    int k, p, g;
    public double y, A;
    public double arr[];
    Alice(){
        //In Alice constructor, we prompt alice for message to be encrypted and her private key
        System.out.println("Welcome to El-Gamal encryption algorithm! ");
        System.out.println("=====================Alice=====================");
        System.out.print("Enter message to be encrypted: ");
        msg=s.nextLine();
        System.out.print("Alice, enter your secret key number: ");
        k=s.nextInt();
        arr = new double[msg.length()];
    }
    public void getValues(int pp, int gg, double yy){
        //three parameters are passed from Bob to Alice which are p,g and y as the algorithm goes
        p = pp;
        g = gg;
        y = yy;
    }
    //In return Alice returns A and an array B to Bob, below are how they are calculated
    public double A(){
        //A=(g^k)mod p
        A=(Math.pow(g, k))%p;
        return A;
    }
    //array B stores the encrypted message numerically for each character making the message
    //the formula is B=(((y^k)*Message)mod p)
    public double[] B(){
        for(int i=0;i<msg.length();i++){
            int ans = 1;
            int asciiCode=msg.charAt(i);
            if (asciiCode>97){
               for(int j=0; j<k; j++){
            ans = (int) ((ans * (y%p))%p);
        } 
               arr[i]=((asciiCode-97)*ans)%p;
            }
            else{
                //if asciicode is less than 97 for symbols and upper case characters
                for(int j=0; j<k; j++){
            ans = (int) ((ans * (y%p))%p);
        }
                arr[i]=(asciiCode*ans)%p;
            }
        }
        return arr;
    }
    
}
