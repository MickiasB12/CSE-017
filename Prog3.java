/*CSE 17
Mickias Bekele
MIB222
Program Description: is to represent payroll records for a company that has
several different types of employees. 
Program 3
*/

import java.util.*; //importing the necessary objects
import java.io.*;
import java.util.ArrayList;


public class Prog3
	//main method created for every java program

    public static void main(String[] args) throws IOException{
        String name = args[0];
        Scanner sc; //initializing scanner object
        BufferedReader in = new BufferedReader(new FileReader(name)); //declaring bufferedreader 
        String check;
        check = in.readLine();
        ArrayList<Employee> array = new ArrayList<Employee>();
        while(check != null){
        sc = new Scanner(check);
        String fname = sc.next();
        String lname = sc.next();
        String ssn = sc.next();
        int type = sc.nextInt();
        int hours = sc.nextInt();
        double wage = sc.nextDouble(); 
        double salary = sc.nextDouble();
        
        check = in.readLine();
        array.add(Employee.factory(fname, lname, ssn, type, hours, wage, salary));
        }
        in.close();

        System.out.print("Name SSN  Type  Hours  Total Payment \n");

        for(int i = 0; i < array.size(); ++i){ //looping through every element in the array and printing the output
            System.out.printf("%3s ", array.get(i).getFname());
            System.out.printf("%3s ", array.get(i).getLname());
            System.out.printf("%11.11s ", array.get(i).getSSN());
            System.out.printf("%6s ", array.get(i).getType());
            System.out.printf("%2d ", array.get(i).getHours());
            System.out.printf("%3.2f ", array.get(i).totalPay());
            System.out.println();





        }/*end of for loop*/
           
    

    }
}/*end of Prog3*/

