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
import static java.lang.Math.pow;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Bob extends Alice{
    Scanner S = new Scanner(System.in);
    public int p, g, x;
    public double y;
    //function for checking if a number is a prime number
    public static boolean notPrime(int p){
        int x=p;
        int k=0;
        for(int i=1;i<=p;i++){
            if (x%i==0){
                k=k+1;
             }
        }
        return k!=2;
    }
    Bob(){
        //Bob constructor of Class Bob, we prompt Bob for every required variable
        System.out.println("=====================Bob=====================");
        boolean z=true;
        while(z){
         System.out.print("enter a large prime number, greater than 100 ");
         p=S.nextInt();
         if(notPrime(p)){
             System.out.println("\\nWRONG INPUT (This number is not Prime. A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself)\\n\"");
         }
         else{
             z=false;
         }
        }
        z=true;
        while(z){
         System.out.print("enter a generator g: ");
         g=S.nextInt();
         if(g>p){
             System.out.println("WRONG INPUT, g must be less than p"+"\n");
         }
         else{
             z=false;
         }
        }
    }
    public int generate_X(){
        Random rn = new Random();
        //x=rn.nextInt(p-2);    //getting Bob's private key generated randomly basing on documentation, we can even prompt for x
        x = 43;
        return x;
    }
    //function for calculating variable y to be sent to Alice
    public double compute_y(){
        double ans = 1;
        if(g>p){
            g=(g%p);
        }
        for(int i=0; i<x; i++){
            ans = (ans * (g%p))%p;
        }
        return ans;
    }
    public String Decrypt_Msg(double a, double[] b){
        //empty string for copying every decrypted character
        String Msg="";
        //loop for iteration of every character in message
        for(int i=0;i<msg.length();i++){
            double M; //variable M stores the value of a character after decryption
            char c;
            int ans = 1;
            //we use a loop to calculate powers for the sake of computing very large powers
            //normally the formula for decryption is M=(a^p-1-x)%p
            for(int j=0; j<p-1-x; j++){
            ans = (int) ((ans * (a%p))%p);
        }
            M=(b[i]* ans)%p;;
            if(M>26){
                //for 'a-z' characters
                c=(char)M;
                Msg=Msg+c;
            }
            else{
                //for upper case characters and symbols
                M = M + 97;
                c=(char)M;
                Msg=Msg+c;
            }
        }
        return Msg;
        
    }
    public static void main(String args[]){
        String s1 = new String("String 1");
        String s2 = "String 1";
        if (s1 == s2) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
        /*Bob bo = new Bob();  //creating an instance of class Bob
        bo.generate_X();     //calling methods of generating Bob's private key x and calculating variable y;
        bo.compute_y();
        bo.getValues(bo.p, bo.g, bo.compute_y());    //passing p,g and y parameters to Alice
        System.out.println("encrypted message is "+Arrays.toString(bo.B()));    //getting the message from Alice but encrypted
        System.out.println("The decrypted message is: "+bo.Decrypt_Msg(bo.A(),bo.B())); */ //printing the decrypted message by Decrypt message method
    }
}
