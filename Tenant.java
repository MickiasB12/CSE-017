/*
CSE 17
Mickias Bekele
mib222
The purpose of the program is to create two classes that can take in information
and outputs the first and monthly payment of house rent
Prog2
*/

public class Tenant {
    private String firstName;
    private String lastName;
    private String aptNumber;
    private double yearlyRent;

    public Tenant(String firstName, String lastName, String aptNumber, double yearlyRent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.aptNumber = aptNumber;
        this.yearlyRent = yearlyRent;
    }/* end of Tenant constructor */

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public double yearlyRent() {
        return yearlyRent;
    }

    public double firstPayment() {
        double monthlyRent = yearlyRent / 12;
        double monthlyRent2 = monthlyRent * 3;
        return monthlyRent2;

    }/* end of firstPayment method */

    public double monthlyPayment() {
        double monthlyDep = yearlyRent / 12;
        double monthlyPay = (yearlyRent - (2 * monthlyDep)) / 11;
        return monthlyPay;

    }/* end of monthlyPayment method */

    public String fullName() {
        firstName = firstName.concat(" " + lastName);
        return firstName;
    }

}/* end of Tenant class */