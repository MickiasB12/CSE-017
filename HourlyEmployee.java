public class HourlyEmployee extends Employee{
    private double wage;
    public HourlyEmployee(String fname, String lname, String ssn, int hours, double wage) {
        super(fname, lname, ssn, hours);
        this.wage = wage;


    }
    public double getWage(){
        return this.wage;
    }
    public String getType(){
        String hour = "HOURLY";
        return hour;

    }
    public double totalPay(){
        double totPay = hours * wage;
        return totPay;

    }

}