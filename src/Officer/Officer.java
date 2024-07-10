package Officer;

public abstract class Officer {
        private int number;
        private String officerCode;
        private String name;
        private String age;
        private String gender;
        private String address;
        private double basicSalary;

        public Officer(int number, String officerCode, String name, String age, String gender, String address,double basicSalary) {
                this.number = number;
                this.officerCode = officerCode;
                this.name = name;
                this.age = age;
                this.gender = gender;
                this.address = address;
                this.basicSalary=basicSalary;
        }
        public abstract String recordInformation();
        public abstract double dailySalaryForBusinessTrips(int day);
        public int getNumber() {
                return number;
        }

        public void setNumber(int number) {
                this.number = number;
        }

        public String getOfficerCode() {
                return officerCode;
        }

        public void setOfficerCode(String officerCode) {
                this.officerCode = officerCode;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAge() {
                return age;
        }

        public void setAge(String age) {
                this.age = age;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public double getBasicSalary() {
                return basicSalary;
        }

        public void setBasicSalary(double basicSalary) {
                this.basicSalary = basicSalary;
        }


        @Override
        public String toString() {
                return
                        "number=" + number +
                        ", officerCode='" + officerCode + '\'' +
                        ", name='" + name + '\'' +
                        ", age='" + age + '\'' +
                        ", gender='" + gender + '\'' +
                        ", address='" + address + '\'' +
                        ", basicSalary='" + basicSalary + '\''
                        ;
        }
}

