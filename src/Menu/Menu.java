package Menu;

public class Menu {
    public static void menuSelect() {
        System.out.println("Quản lý cán bộ");
        System.out.println("Chọn chức năng theo số (tiếp tục) :");
        System.out.println("1,Thêm mới cán bộ.");
        System.out.println("2,Sửa cán bộ");
        System.out.println("3,Xóa cán bộ");
        System.out.println("4,Tìm kiếm theo mã từng cán bộ.");
        System.out.println("5,Hiển thị thông tin về danh sách các cán bộ.");
        System.out.println("6,Tính lương đi công tác");
        System.out.println("7,Hiển thị lương cũng như tổng lương đã kiếm được ");
        System.out.println("8,Thoát khỏi chương trình.");
        System.out.println("Chọn chức năng");
    }
    public static void menuSelectOfficer() {
        System.out.println("Chon 1 trong 3 thêm mới cán bộ vào ds");
        System.out.println("1,Công nhân");
        System.out.println("2,Kỹ sư");
        System.out.println("3,Nhân viên");
        System.out.print("Chọn : ");
    }
    public static void menuRepairYesOrNo() {
        System.out.println("Bạn đồng ý chỉnh sửa chứ(Yes/No)");

    }
}
