import Menu.Menu;

import java.util.Scanner;

public class RepairAndDelete {
    public void repair(Scanner scanner, OfficerManager officerManager)  {
        System.out.print("Nhập mã code cán bộ cần sửa :");
        String officerCode = scanner.nextLine();
        Menu.menuRepairYesOrNo();
        String choose = scanner.nextLine();

        if (choose.equals("Yes")) {
            System.out.print("Số thứ tự mới : ");
            int number = Integer.parseInt(scanner.nextLine());
            System.out.print("Tên cán bộ mới: ");
            String name = scanner.nextLine();
            System.out.print("Tuổi cán bộ mới: ");
            String age = scanner.nextLine();
            System.out.print("Giới tính(Nam/Nữ/Khác) mới : ");
            String gender = scanner.nextLine();
            System.out.print("Địa chỉ mới : ");
            String address = scanner.nextLine();
            System.out.println("Lương cơ bản mới");
            double basicSalary = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập công việc mới (nếu có) mới: ");
            String job = scanner.nextLine();
            System.out.print("Nhập bậc mới (nếu có) mới: ");
            int wage = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhập ngành đào tạo mới (nếu có) mới: ");
            String trainingIndustry = scanner.nextLine();
            officerManager.repairOfficer(officerCode, number, name, age, gender, address,basicSalary, job, wage, trainingIndustry);

        }
        if (choose.equals("No")) {
            System.out.println("Trả về màn hình chính");
        }
    }
    public void delete(Scanner scanner, OfficerManager officerManager) {
        System.out.print("Nhập mã code cán bộ cần sửa :");
        String officerCode = scanner.nextLine();
        Menu.menuRepairYesOrNo();
        String choose = scanner.nextLine();

        if (choose.equals("Yes")) {
            officerManager.remoteOfficer(officerCode);
        }
    }

}