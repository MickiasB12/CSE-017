
/*Mickias Bekele, mib222@lehigh.edu, Prog 1 */
/*The purpose of this program is to create a program that calculate
 the sum of each row in an array*/

import java.util.Scanner; //import Scanner object or there will be a compiler error

public class Square { // main method required for every Java program
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // creating new Scanner object
        final int NUM_ELEMENTS = 5;
        int[][] array = new int[NUM_ELEMENTS][NUM_ELEMENTS]; // declaring a new array
        System.out.println("Enter numbers");
        for (int i = 0; i < 5; ++i) { // iterating throughout the array and filling out the numbers
            for (int j = 0; j < 5; ++j) {
                array[i][j] = scnr.nextInt();
            }
        }
        System.out.println();
        sumrowsandcols(array); // calling sumrowsandcols method

        scnr.close(); // closing the Scanner object
    }

    private static void sumrowsandcols(int[][] a) { // sumrowsandcols method
        // it is to find the sum of the rows and columns and output it in a two row
        // array
        int sum = 0; // initializing the sum to 0
        int[][] array = new int[2][5]; // declaring a new array
        for (int b = 0; b < 1; ++b) { // iterarting through the array for the sum of the rows

            for (int i = 0; i < 5; ++i) {
                sum = 0; // it will initialize back to 0 whenever the loop happens againg
                for (int j = 0; j < 5; ++j) {
                    sum += a[i][j]; // adding up the rows
                }
                array[b][i] = sum; // assinging the value of the sum to the array
            }
        }
        for (int b = 1; b < 2; ++b) { // for columns

            for (int i = 0; i < 5; ++i) {
                sum = 0; // it will initialize to 0 whenever the loop happens
                for (int j = 0; j < 5; ++j) {
                    sum += a[j][i]; // adding up the columns
                }
                array[b][i] = sum; // assigning the sum of the columns to the array
            }
        }
        for (int f = 0; f < 2; ++f) { // iteration through arra
            for (int c = 0; c < 5; ++c) {
                System.out.print(array[f][c] + " "); // printing out the array
            }
            System.out.println();
        }
    }// end of main method

}// end of class
