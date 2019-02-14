
/*
CSE 17
Mickias Bekele
mib222
The purpose of the program is to create two classes that can take in information
and outputs the first and monthly payment of house rent
Prog2
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Prog2 {
    /* main method required for every Java Program */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int x;
        boolean check = true;
        ArrayList<Tenant> tenantObj = new ArrayList<Tenant>();
        String firstName = "";
        String last = "";
        String aptNum = "";
        String dk = "";
        double yearlyRent = 2.0;
        System.out.println("Enter the number of tenants");
        check = scnr.hasNextInt();
        while (!(check)) {
            System.out.println("Enter again. Invalid number");
            scnr.next();
            check = scnr.hasNextInt();

        } /* end of while loop */
        x = scnr.nextInt();
        System.out.println();
        for (int a = 0; a < x; ++a) {
            System.out.println();
            dk = scnr.nextLine();
            System.out.println("Enter the first name");
            firstName = scnr.nextLine();
            System.out.println("Enter the last name");
            last = scnr.nextLine();
            System.out.println("Enter apt number");
            aptNum = scnr.nextLine();
            System.out.println("Enter yearly rent");
            check = scnr.hasNextDouble();
            while (!(check)) {
                System.out.println("Enter again.");
                scnr.next();
                check = scnr.hasNextDouble();
            }
            yearlyRent = scnr.nextDouble();
            System.out.println();
            Tenant tenantO = new Tenant(firstName, last, aptNum, yearlyRent);
            tenantObj.add(tenantO);

        }
        for (int j = 0; j < tenantObj.size(); ++j) {
            System.out.println(tenantObj.get(j).fullName());
            System.out.println("Apt " + tenantObj.get(j).getAptNumber());
            System.out.printf("First Payment $%5.2f \n", tenantObj.get(j).firstPayment());
            System.out.printf("Monthly Payment $%5.2f \n", tenantObj.get(j).monthlyPayment());
            System.out.println();
        } /* end of for loop */

    }/* end of main method */
}/* end of Prog2 class */