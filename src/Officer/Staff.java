package Officer;


public class Staff extends Officer {
    String job;

    public Staff(int number, String officerCode, String name, String age, String gender, String address,double BasicSalary, String job ) {
        super(number, officerCode, name, age, gender, address,BasicSalary);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public double dailySalaryForBusinessTrips(int day) {
        double oneDaySalary = 40000;
        return oneDaySalary*day;
    }

    @Override
    public String recordInformation() {
        return "Staff," + getNumber() + "," +
                getOfficerCode() + "," +
                getName() + "," +
                getAge() + "," +
                getGender() + "," +
                getAddress() + "," +
                getBasicSalary() +"," +
                getJob();
    }

    @Override
    public String toString() {
        return "Officer.Staff{" + super.toString() +
                ", job='" + job + '\'' +
                '}';
    }
}

