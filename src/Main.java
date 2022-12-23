import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();

        while (true) {
            try {
                System.out.println("Menu");
                System.out.println("[1] Thêm sinh viên vào danh sách");
                System.out.println("[2] Hiển thị danh sách");
                System.out.println("[3] Sửa theo id");
                System.out.println("[4] Hiển thị sinh viên có điểm thấp nhất");
                System.out.println("[5] Hiển thị sinh viên có điểm cao nhất");

                System.out.println("[6] Xóa sinh viên theo ID");
                System.out.println("[7] Tìm sinh viên theo tên đã nhập");
                System.out.println("[8] Hiển thị theo giới tính");
                System.out.println("[9] Kiểm tra những học sinh học chung lớp");
                System.out.println("[10] Đăng ký môn học");
                System.out.println("[11] Đăng ký bài kiểm tra");
                System.out.println("Nhập lựa chọn");

                int a = Integer.parseInt(sc.nextLine());
                switch (a) {
                    case 1 -> managerStudent.Add();
                    case 2 -> managerStudent.show();
                    case 3 -> managerStudent.edit();
                    case 4 -> managerStudent.minDiem();
                    case 5 -> managerStudent.maxDiem();

                    case 6 -> managerStudent.delete();
                    case 7 -> managerStudent.search();
                    case 8 -> managerStudent.hienThiTheoGioiTinh();
                    case 9 -> managerStudent.checkClass();
                    case 10 -> managerStudent.dangKyMonHoc();
                    case 11 -> managerStudent.dangKyBaiKiemTra();
                }
            } catch (Throwable e) {
                System.out.println("Nhập lại");

            }
        }

    }
}