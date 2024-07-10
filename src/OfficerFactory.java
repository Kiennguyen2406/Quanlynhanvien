import Officer.Officer;
import Officer.*;

import java.util.Scanner;

public class OfficerFactory {
    public void creatOfficer(Scanner scanner, OfficerManager officerManager) throws Exception{
        Menu.menuSelectOfficer();

        int chooseOfficer = Integer.parseInt(scanner.nextLine());
        if (chooseOfficer != 1 && chooseOfficer != 2 && chooseOfficer != 3) {
            throw new Exception("Lựa chọn ko hợp lệ");
        }else {
            System.out.println("Nhập thông tin");
        System.out.print("Số thứ tự : ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.print("Mã cán bộ : ");
        String officerCode = scanner.nextLine();
        System.out.print("Tên cán bộ : ");
        String name = scanner.nextLine();
        System.out.print("Tuổi cán bộ : ");
        String age = scanner.nextLine();
        System.out.print("Giới tính(Nam/Nữ/Khác) : ");
        String gender = scanner.nextLine();
        System.out.print("Địa chỉ : ");
        String address = scanner.nextLine();
            System.out.println("Lương cơ bản");
            double basicSalary = Double.parseDouble(scanner.nextLine());
        if (chooseOfficer == 1) {
            System.out.println("Bậc lương");
            int wage = Integer.parseInt(scanner.nextLine());
            Officer workers = new Workers(number, officerCode, name, age, gender, address,basicSalary, wage);
            officerManager.addOfficer(workers);
            System.out.println("Thêm mới  công nhân thành công");
        } else if (chooseOfficer == 2) {
            System.out.println("Ngành đào tạo");
            String trainingIndustry = scanner.nextLine();
            Officer engineer = new Engineer(number, officerCode, name, age, gender, address,basicSalary, trainingIndustry);
            officerManager.addOfficer(engineer);
            System.out.println("Thêm mới Kỹ sư thành công");
        } else {
                System.out.println("Công việc (Văn phòng/Ngoài trời)");
                String job = scanner.nextLine();
                Officer staff = new Staff(number, officerCode, name, age, gender, address,basicSalary, job);
                officerManager.addOfficer(staff);
            System.out.println("Thêm mới nhân viên thành công");

        }
        }
        }
    }

