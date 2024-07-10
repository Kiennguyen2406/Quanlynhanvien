import Officer.Officer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Officer.*;

public class OfficerManager implements InterOfficer {
    List<Officer> officers;
    List<String> businessTripSalaries;

    public OfficerManager() {
        officers = new ArrayList<>();

        businessTripSalaries = new ArrayList<>();
        loadToFile();
        loadWorkSalaryFromFile();
    }

    File file = new File("data.txt");
    File fileWorkSalary = new File("workSalary.txt");


    public void addOfficer(Officer officer) {
        if(searchOfficeByCode(officer.getOfficerCode()) != -1) {
            System.out.println("Mã cán bộ đã tồn tại, không thể thêm mới.");
        }else {
            officers.add(officer);
            savetoFile();
        }
    }

    @Override
    public void savetoFile() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Officer officer : officers) {
                bufferedWriter.write(officer.recordInformation());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void loadToFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length < 8) {
                    System.err.println("Dữ liệu không hợp lệ: " + line);
                    continue;
                }

                String officerType = parts[0]; // Loại Officer: "Staff", "Worker", "Engineer"
                int number = Integer.parseInt(parts[1]);
                String officerCode = parts[2];
                String name = parts[3];
                String age = parts[4];
                String gender = parts[5];
                String address = parts[6];
                double basicSalary = Double.parseDouble(parts[7]);

                Officer officer = null;
                switch (officerType) {
                    case "Staff":
                        if (parts.length >= 9) {
                            String job = parts[8];
                            officer = new Staff(number, officerCode, name, age, gender, address, basicSalary, job);
                        } else {
                            System.err.println("Dữ liệu không hợp lệ cho Staff: " + line);
                        }
                        break;
                    case "Workers":
                        if (parts.length >= 9) {
                            int wage = Integer.parseInt(parts[8]);
                            officer = new Workers(number, officerCode, name, age, gender, address, basicSalary, wage);
                        } else {
                            System.err.println("Dữ liệu không hợp lệ cho Workers: " + line);
                        }
                        break;
                    case "Engineer":
                        if (parts.length >= 9) {
                            String trainingIndustry = parts[8];
                            officer = new Engineer(number, officerCode, name, age, gender, address, basicSalary, trainingIndustry);
                        } else {
                            System.err.println("Dữ liệu không hợp lệ cho Engineer: " + line);
                        }
                        break;
                    default:
                        System.err.println("Loại Officer không hợp lệ: " + officerType);
                }

                if (officer != null) {
                    officers.add(officer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void repairOfficer(String officerCode, int number, String name, String age, String gender, String address, double basicSalary, String job, int wage, String trainingIndustry) {
        int index = searchOfficeByCode(officerCode);
        if (index == -1) {
            System.out.println("khong tim thay cho sua");
        } else {
            Officer officer = officers.get(index);

            officer.setAge(age);
            officer.setNumber(number);
            officer.setName(name);
            officer.setGender(gender);
            officer.setAddress(address);
            officer.setBasicSalary(basicSalary);
            if (officer instanceof Staff) {
                ((Staff) officer).setJob(job);
                savetoFile();
                System.out.println("Sửa cán bộ nhân viên thành công");
            }
            if (officer instanceof Workers) {
                ((Workers) officer).setWage(wage);
                savetoFile();
                System.out.println("Sửa cán bộ công nhân thành công");
            }
            if (officer instanceof Engineer) {
                ((Engineer) officer).setTrainingIndustry(trainingIndustry);
                savetoFile();
                System.out.println("Sửa cán bộ kĩ sư thành công");
            }

        }
    }


    public int searchOfficeByCode(String officerCode) {
        for (int i = 0; i < officers.size(); i++) {
            Officer officer = officers.get(i);
            if (officer.getOfficerCode().equals(officerCode)) {
                return i;
            }
        }
        return -1;
    }


    public void remoteOfficer(String officerCode) {
        int index = searchOfficeByCode(officerCode);

        if (index == -1) {
            System.out.println("khong tim thay cho xoa");
        } else {
            officers.remove(index);
            savetoFile();
            System.out.println("Xóa thành công");
        }
    }

    @Override
    public void searchOfficeByName(String name) {
        for (Officer officer : officers) {
            if (officer.getName().equals(name)) {
                System.out.println("Hiển thị thông tin tìm kiếm là ");
                System.out.println(officer.toString());
            }
        }
    }

    public void calculateSalaryForBusinessTripsByName(String name, int day) throws IllegalArgumentException {
        boolean found = false;
        for (Officer officer : officers) {
            if (officer.getName().equals(name)) {
                double workSalary = officer.dailySalaryForBusinessTrips(day);
                double totalSalary = officer.getBasicSalary() + workSalary;
                System.out.println("Họ tên cán bộ: " + name + ", " + "lương thưởng đi công tác là : " + workSalary);
                System.out.println("Tổng lương của cán bộ là :" + totalSalary);
                found = true;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Không có tên phù hợp trong danh sách");
        }
    }

    public void saveToFileWorkSalary(int day) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWorkSalary))) {
            for (Officer officer : officers) {
                double basicSalary = officer.getBasicSalary();
                double businessTripSalary = officer.dailySalaryForBusinessTrips(day);
                double totalSalary = basicSalary + businessTripSalary;
                String salaryInfo = officer.getName() + "," + basicSalary + "," + businessTripSalary + "," + totalSalary;
                businessTripSalaries.add(salaryInfo);
                bufferedWriter.write(salaryInfo);
                bufferedWriter.newLine();
            }
            System.out.println("Successfully saved work salaries to file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving work salaries to file: " + e.getMessage());
        }
    }

    @Override
    public void showOfficer() {
        for (Officer officer : officers) {
            System.out.println(officer);
        }
    }

    @Override
    public void displayAllBusinessTripSalaries() {
        for (String salaryInfo : businessTripSalaries) {
            System.out.println(salaryInfo);
        }
    }

    @Override
    public void loadWorkSalaryFromFile() {
        businessTripSalaries.clear(); // Xóa danh sách hiện tại trước khi tải dữ liệu từ file
        try {
            FileReader fileReader = new FileReader(fileWorkSalary);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                businessTripSalaries.add(line); // Lưu dữ liệu vào danh sách
            }
            bufferedReader.close();
            System.out.println("Successfully loaded work salaries from file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading work salaries from file: " + e.getMessage());
        }
    }
}

