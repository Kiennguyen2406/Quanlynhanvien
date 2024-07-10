package Officer;

public class Engineer extends Officer {
    String trainingIndustry;

    public Engineer(int number, String officerCode, String name, String age, String gender, String address,double BasicSalary, String trainingIndustry) {
        super(number, officerCode, name, age, gender, address,BasicSalary);
        this.trainingIndustry = trainingIndustry;
    }

    public String getTrainingIndustry() {
        return trainingIndustry;
    }

    public void setTrainingIndustry(String trainingIndustry) {
        this.trainingIndustry = trainingIndustry;
    }

    @Override
    public String recordInformation() {
        return "Engineer,"+getNumber()+","+
                getOfficerCode() +","+
                getName()+","+
                getAge() +","+
                getGender()+","+
                getAddress()+","+
                getBasicSalary()+","+
                getTrainingIndustry();
    }

    @Override
    public double dailySalaryForBusinessTrips(int day) {
        double oneDaySalary = 55000;
        return oneDaySalary*day;
    }

    @Override
    public String toString() {
        return "Officer.Engineer{" + super.toString() +
                ", trainingIndustry='" + trainingIndustry + '\'' +
                '}';
    }
}
