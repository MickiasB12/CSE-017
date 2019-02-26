public class SalariedEmployee extends Employee{
    private double salary;

    public SalariedEmployee(String fname, String lname, String ssn, int hours, double salary){
        super(fname, lname, ssn, hours);
        this.salary = salary;
    }
    public double getSalary(){
        return this.salary;
    }

    public String getType(){
        String salary = "SALARIED";
        return salary;

    }
    public double totalPay(){
        double totPay =  salary/52;
        return totPay;
        
    }
}