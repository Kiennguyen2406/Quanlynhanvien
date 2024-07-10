package Officer;

public class Workers extends Officer {
    private int wage;

    public Workers(int number, String officerCode, String name, String age, String gender, String address,double BasicSalary, int wage) {
        super(number, officerCode, name, age, gender, address,BasicSalary);
        this.wage = wage;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String recordInformation() {
        return "Workers,"+getNumber()+","+
                getOfficerCode() +","+
                getName()+","+
                getAge() +","+
                getGender()+","+
                getAddress()+","+
                getBasicSalary()+"," +
                getWage();
    }

    @Override
    public double dailySalaryForBusinessTrips(int day) {
        double oneDaySalary = 20000;
        return oneDaySalary*day;
    }

    @Override
    public String toString() {
        return "Officer.Workers{" + super.toString()+
                ", wage=" + wage +
                '}';
    }
}


