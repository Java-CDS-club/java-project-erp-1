import java.util.Scanner;
import java.util.ArrayList;

/**
 * Normally I would have these things sorted in packages, but since this only needs one file to work...
 * Here is the video I used to understand the Sieve of Eratosthenes:
 * https://youtu.be/V08g_lkKj6Q
 * 
 * And Wikipedia article:
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Overview
 * 
 * Sieve class simply contains the main method as well as helper methods.
 *
 * @author Allison Mackenzie Johnson
 * @version August 11th, 2021
 */
public class Sieve {
    /**
     * main method takes no args and is ran in main. It has a Scanner object which will ask you to input a value 
     * for n, which is the value you enter as an integer because of input.nextInt(), then scanner is closed 
     * before preceeding onward as it isn't necessary, this variable is passed to findPrime which returns an ArrayList<Integer> 
     * for all prime numbers up to that value.
     * 
     * In a real world program, there would be error handling and sanitization for if the user tried to input 
     * something other than integers. I won't be doing that here though.
     * 
     * @param args
     */
    public static void main(String[] args) {
        int n = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Sieve of Eratostheses finds all prime numbers from 2 to n, inclusive. "
                + "Enter an integer value for n that is greater than 2: ");
        n = input.nextInt();
        
        input.close();

        if (n <= 2) {
            n = 2;
        }

        System.out.println("These numbers are prime from 2 to n: " + findPrime(n));
    }
    
    /**
     * findPrime has of course finds prime numbers from 2 to n. There are several ways this can be done, 
     * since there are inbuilt functions such as Math.sqrt for example, but I'll be doing it by hand.
     * 
     * @param n integer value for 2 up to n so you can find prime numbers up to this.
     * @return An ArrayList containing every number that is prime from 2 to n, inclusive.
     */
    public static ArrayList<Integer> findPrime(int n) {
        ArrayList<Integer> list = new ArrayList<>(); // ArrayList of Integers holds values that are prime
        boolean[] isPrime = new boolean[n + 1]; // Array of booleans is true/false for those values

        //Set all isPrime index values to be true so they can be set to false if they're not prime.
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        // Start array traversal at 2, since 1 can't be prime. 
        for (int i = 2; i <= n; i++) {
            // Only need to check this number if it is still as true
            if (isPrime[i] == true) {
                // 1i, 2i, 3i, 4i, 5i... etc
                for (int j = i; (i * j) <= n; j++) {
                    isPrime[(i * j)] = false;
                }                
            }
        }

        // Add those values to an ArrayList of integers then return them
        for (int k = 2; k < isPrime.length; k++) {
            if (isPrime[k] == true) {
                list.add(k);
            }
        }

        return list;
    }
}


