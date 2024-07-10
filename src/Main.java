import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OfficerManager officerManager = new OfficerManager();
        while (true) {
            Menu.menuSelect();

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    try {
                        OfficerFactory officerFactory = new OfficerFactory();
                        officerFactory.creatOfficer(scanner,officerManager);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    RepairAndDelete repairAndDelete=new RepairAndDelete();
                    repairAndDelete.repair(scanner,officerManager);
                    System.out.println(" ");
                    break;
                case 3:
                    RepairAndDelete repairAndDelete1=new RepairAndDelete();
                    repairAndDelete1.delete(scanner,officerManager);
                    break;
                case 4:
                    System.out.println("Điền tên cần tìm");
                    String name = scanner.nextLine();
                    officerManager.searchOfficeByName(name);
                    System.out.println(" ");
                    break;
                case 5:
                    officerManager.showOfficer();
                    break;
                case 6:
                    try {
                        System.out.print("Nhập tên : ");
                        String nameInList = scanner.nextLine();
                        System.out.println("Nhập số ngày đã đi công tác ngày");
                        int day =Integer.parseInt(scanner.nextLine());
                        officerManager.calculateSalaryForBusinessTripsByName(nameInList, day);
                        officerManager.saveToFileWorkSalary(day);
                    } catch (IllegalThreadStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7 :
                    officerManager.displayAllBusinessTripSalaries();
                    break;
                case 8:
                    System.out.println("End");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn  không phù hợp");
                    break;
            }
        }
    }

}
