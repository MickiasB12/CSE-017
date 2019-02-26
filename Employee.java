
public abstract class Employee{
    private String fname;
    private String lname;
    private String ssn;
    protected int hours;

    
    public Employee(String fname, String lname, String ssn, int hours){
        this.fname = fname;
        this.lname = lname;
        this.ssn = ssn;
        this.hours = hours;


    }
    public String getFname(){
        return this.fname;
    }
    public String getLname(){
        return this.lname;
    }
    public String getSSN(){
        return this.ssn;
    }
    public int getHours(){
        return this.hours;
    }
    abstract String getType();
    abstract double totalPay();
    public static Employee factory(String fname, String lname, String ssn, int type, int hours, double wage, double salary){
        Employee hourly;
        Employee sal;
        if(type == 1){
            hourly = new HourlyEmployee(fname, lname, ssn, hours, wage);
            return hourly;
        }
        else if(type ==2){
            sal = new SalariedEmployee(fname, lname, ssn, hours, salary);
            return sal;
        }
        else{
            throw new IllegalArgumentException();

        }

    }




}//end of employee class