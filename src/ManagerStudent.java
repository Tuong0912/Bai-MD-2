import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagerStudent {
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    int id = 0;


    public void show() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public void Add() {// kiểm gia giống hết thuộc tính thì cho nhập lại //
        System.out.println("nhập tên ");
        String name = sc.nextLine();
        Pattern p = Pattern.compile("[a-zA-Z]{1,7}");
        do {
            if (p.matcher(name).matches()) {
                {
                    for (int i = 0; i < students.size(); i++) {
                        if (name.equals(students.get(i).ten())) {
                            System.out.println("Tên đã tồn tại , mời nhập lại");
                            name = sc.nextLine();
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Chỉ nhập chữ   -   Mời nhập lại");
                name = sc.nextLine();
            }
        } while (!p.matcher(name).matches());


        System.out.println("Nhập age");
        int age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập giới tính");
        String gender;
        System.out.println("1. Chọn nam");
        System.out.println("2. Chọn nữ");
        System.out.println("3. Khác");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1 -> gender = "Nam";
            case 2 -> gender = "Nữ";
            default -> gender = "Khác";
        }


        System.out.println("Nhập địa chỉ ");
        String diaChi = sc.nextLine();

        id++;

        String className;
        System.out.println("Chọn lớp để học");
        System.out.println("1. Lớp C10");
        System.out.println("2. Lớp C09");
        System.out.println("3. Lớp C08");
        System.out.println("4. Nhập để đăng ký lớp học");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1 -> className = "C10";
            case 2 -> className = "C09";
            case 3 -> className = "C08";
            case 4 -> className = sc.nextLine();
            default -> className = "Chọn linh tinh , đánh bome -.-";
        }

        Lop tenLop = new Lop(className);
//        Student demo = new Student(tenLop);
        double dtb = 0;
        String monhoc = "";
        Student student1 = new Student(id, name, age, gender, diaChi, dtb, tenLop, monhoc);
        students.add(student1);

    }


    public void maxDiem() {
        double max = students.get(0).dtb();
        Student student = students.get(0);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).dtb() > max) {
                max = students.get(i).dtb();
                student = students.get(i);
            }

        }
        System.out.println(student);
    }

    public void minDiem() {
        double min = students.get(0).dtb();
        Student student1 = students.get(0);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).dtb() < min) {
                student1 = students.get(i);
            }
        }
        System.out.println(student1);
    }

    public void delete() {
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(sc.nextLine());
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).id()) {
                index = i;

            }
        }
        students.remove(index);
    }

    public void search() {

        System.out.println("Nhập tên cần tìm");
        String name = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).ten().toLowerCase().contains(name.toLowerCase())) {
                check = true;
                System.out.println(students.get(i));
            }
//
//            if (name.toLowerCase().equals(students.get(i).ten().toLowerCase())) {
//                check = true;
//                System.out.println(students.get(i));
        }
        if (!check) {
            System.out.println("Không có tên tương ứng trong danh sách sinh viên");
        }
    }


    public void hienThiTheoGioiTinh() {
        System.out.println("Chọn giới tính ");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> {
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).gender().equals("Nam")) {
                        System.out.println(students.get(i));
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).gender().equals("Nữ")) {
                        System.out.println(students.get(i));
                    }
                }
            }
        }
    }

    public void edit() {
        System.out.println("Nhập id cần sửa");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).id()) {
                System.out.println("Nhập tên muốn sửa");
                String name = sc.nextLine();
                if (name.equals("")) {
                    System.out.println("không sửa");
                } else {
                    students.get(i).setTen(name);
                }

                System.out.println("Nhập tuổi muốn sửa");
                String age = sc.nextLine();
                if (age.equals("")) {
                    System.out.println("không sửa");
                } else {
                    students.get(i).setTuoi(Integer.parseInt(age));
                }

                System.out.println("Nhập giới tính muốn sửa");
                String gender = sc.nextLine();
                if (gender.equals("")) {
                    System.out.println("Không sửa");
                } else {
                    students.get(i).setGender(gender);
                }

                System.out.println("Nhập địa chỉ muốn sửa");
                String diaChi = sc.nextLine();
                if (diaChi.equals("")) {
                    System.out.println("Không sửa");
                } else {
                    students.get(i).setDiaChi(diaChi);
                }

                System.out.println("Nhập điểm trung bình muốn sửa");
                String dtb = sc.nextLine();
                if (dtb.equals("")) {
                    System.out.println("Không sửa");
                } else {
                    students.get(i).setDtb(Double.parseDouble(dtb));
                }


            }
        }
    }

    public void checkClass() {
        System.out.println("[1] C10");
        System.out.println("[2] C09");
        System.out.println("[3] C08");
        System.out.println("[4] Khác");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> {
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).tenLop().equalsIgnoreCase("C10")) {
                        System.out.println(students.get(i).toString());
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).tenLop().equalsIgnoreCase("C09")) {
                        System.out.println(students.get(i).toString());
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).tenLop().equalsIgnoreCase("C08")) {
                        System.out.println(students.get(i).toString());
                    }
                }
            }
            case 4 -> {
                String className = sc.nextLine();
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).tenLop().equalsIgnoreCase(className)) {
                        System.out.println(students.get(i).toString());
                    }

                }
            }
        }

//        String className = sc.nextLine();
//        for (int i = 0; i < students.size(); i++) {
//            if (className.toUpperCase().equals(students.get(i).tenLop())) {
//                System.out.println(students.get(i).toString());
//            }
//        }
    }

    public void dangKyMonHoc() {
        System.out.println("Nhập tên sinh viên muốn đăng ký ");
        String nameHocSinh = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (nameHocSinh.equalsIgnoreCase(students.get(i).ten())) {
                students.get(i).setMonHoc(chonMonHoc());
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Sinh viên không tồn tại");
        }
    }

    public String chonMonHoc() {
        String nameOject = null;
        System.out.println("Chọn môn học");
        System.out.println("1. Toán");
        System.out.println("2. Java");
        System.out.println("3. Anh");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> nameOject = "Toán";
            case 2 -> nameOject = "Java";
            case 3 -> nameOject = "Anh";
        }
        return nameOject;
    }

    public void dangKyBaiKiemTra() {
        System.out.println("Nhập tên sinh viên để kiểm tra");
        String nameSinhVien = sc.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (nameSinhVien.equalsIgnoreCase(students.get(i).ten())) {  // kiểm tra trường hợp trùng tên ( check lại cho chắc)
                if (students.get(i).getMonHoc().equalsIgnoreCase("Java")) {
                    students.get(i).setDtb(this.baiKiemTraCode());
                    break;
                }
                if (students.get(i).getMonHoc().equalsIgnoreCase("Toán")) {
                    students.get(i).setDtb(this.baiKiemTraToan());
                    break;
                }
            } else System.out.println("Sai tên , mời nhập lại");

        }
    }


    public double baiKiemTraToan() {
        int count = 0;
        System.out.println("------ BÀI KIỂM TRA TOÁN ------");
        System.out.println("       Bạn có 45' làm bài");
        System.out.println();
        System.out.println("1 + 1 = ?");
        int a = Integer.parseInt(sc.nextLine());
        if (a == 2) {
            System.out.println("Đúng");
            count++;
        } else System.out.println("Sai");

        System.out.println("2 + 1 = ?");
        int b = Integer.parseInt(sc.nextLine());
        if (b == 3) {
            System.out.println("Đúng");
            count++;
        } else System.out.println("Sai");

        System.out.println("100 + 1 = ?");
        int c = Integer.parseInt(sc.nextLine());
        if (c == 101) {
            System.out.println("Đúng");
            count++;
        } else System.out.println("Sai");

        System.out.println("1+11");
        a = Integer.parseInt(sc.nextLine());
        if (a == 12) {
            System.out.println("Đúng");
            count++;
        } else System.out.println("Sai");

        System.out.println("123*321");
        a = Integer.parseInt(sc.nextLine());
        if (a == 343) {
            System.out.println("Đúng");
            count++;
        } else System.out.println("Sai");

        System.out.println("Pi = ?");
        System.out.println("Làm tròn đến 4 số ");
        double d = Double.parseDouble(sc.nextLine());
        if (d == 3.1415) {
            System.out.println("Đúng");
            count++;                            //6
        } else System.out.println("Sai");

        System.out.println(" 123+321 = ?");
        a = Integer.parseInt(sc.nextLine());
        if (a == 444) {
            System.out.println("Đúng");
            count++;                            //7
        } else System.out.println("Sai");

        System.out.println("1 + 1 = ?");
        a = Integer.parseInt(sc.nextLine());
        if (a == 2) {
            System.out.println("Đúng");
            count++;                            //8
        } else System.out.println("Sai");


        System.out.println("1 + 1 = ?");
        a = Integer.parseInt(sc.nextLine());
        if (a == 2) {
            System.out.println("Đúng");
            count++;                            //9
        } else System.out.println("Sai");


        System.out.println("1 + 1 = ?");
        a = Integer.parseInt(sc.nextLine());
        if (a == 2) {
            System.out.println("Đúng");
            count++;                            //10
        } else System.out.println("Sai");

        int z = count;
        System.out.println(z);
        return z;
    }

    //Thêm phương thức check xem học sinh có đỗ hay không ( dựa vào điểm )

    public double baiKiemTraCode() {
        int countHint = 3;
        int countcode = 0;
        System.out.println("------ BÀI KIỂM TRA JAVA ------");
        System.out.println("       Bạn có 45' làm bài");
        System.out.println();

        System.out.println("------ Bạn có 3 lần gợi ý ------");
        System.out.println("      Nhấn Y để dùng gợi ý");


        System.out.println();
        System.out.println("Câu 1");
        System.out.print(" Có mấy loại Access modifier : ");
        String a = sc.nextLine();

        if (a.equalsIgnoreCase("Y")) {
            System.out.println("Đáp án là : 4");
            countHint--;                      //Gợi ý -1
            System.out.println();
            System.out.println(countHint);
            System.out.println("Mời nhập đáp án");
            String b = sc.nextLine();
            if (b.equals("4")) {
                System.out.println("Đúng");
                countcode++;                //1
            } else System.err.println("Đã gợi ý còn sai , gà vl");
        } else if (a.equals("4")) {
            System.out.println("Đúng");
            countcode++;                    //1
        } else System.err.println("Sai     Đáp án : 4");


        System.out.println();


        System.out.println("Câu 2");
        System.out.println(" Có mấy dạng kế thừa trong Java");
        a = sc.nextLine();
        if (a.equalsIgnoreCase("Y")) {
            System.out.println("Đáp án là : 3");
            countHint--;                    //gợi ý -2
            System.out.println();
            System.out.println(countHint);
            System.out.print("Mời nhập đáp án : ");
            String b = sc.nextLine();
            if (b.equals("3")) {
                System.out.println("Đúng");
                countcode++;                //2
            } else System.err.println("Đã gợi ý còn sai , gà vl");
        } else if (a.equals("3")) {
            System.out.println("Đúng");
            countcode++;                    //2
        } else {
            System.err.println("Sai");
            System.out.println("Có 3 dạng kế thừa chính trong Java");
            System.out.print(" Kế thừa từ Class - ");
            System.out.print(" Kế thừa từ lớp trừu tượng (Abstract class) - ");
            System.out.print(" Kế thừa từ Interfac e");
        }

        System.out.println();


        System.out.println("Câu 3");
        System.out.println("Phương thức sau đúng hay sai");
        System.out.println(
                """
                        1        Scanner scanner = new Scanner(System.in);
                        2        while (true) {
                        3            System.out.print("Enter a number:");
                        4            int number = scanner.nextInt();
                        5            if (number < 2) {
                        6                System.out.println(number + " is not a prime");
                        7            } else {
                        8                int i = 2;
                        9                boolean check = true;
                        10                while (i <= Math.sqrt(number)) {
                        11                   if (number % i != 0) {
                        12                      check = false;
                        13                     break;
                        14                }
                        15               i++;
                        16          }
                        17                if (check)
                        18                    System.out.println(number + " is a prime");
                        19                else
                        20                    System.out.println(number + " is not a prime");
                        21            }
                        22        }
                        """);
        System.out.println("Nhập vị trí sai trong đoạn code trên");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Đáp án là : 11");
            countHint--;                    //gợi ý -3
            System.out.println();
            System.out.println(countHint);
            System.out.print("Mời nhập đáp án : ");
            String b = sc.nextLine();
            if (b.equals("11")) {
                System.out.println("Đúng");
                countcode++;                    //3
            } else System.err.println("Đã gợi ý còn sai , gà vl");
        } else if (input.equalsIgnoreCase("11")) {
            System.out.println("Đúng");
            countcode++;                        //3
        } else System.err.println("Sai     Đáp án : Vị trí 11");


        System.out.println();


        System.out.println("Câu 4");
        System.out.println("            Map         ");
        System.out.println("     ↗              ↖     ");
        System.out.println(" AbstractMap     SortedMap");
        System.out.println("     ∆    ↖          ⇡ ");
        System.out.println("     |      ↖     NavigableMap");
        System.out.println("     |        ↖      ↗    ");
        System.out.println("   ???        TreeMap");
        System.out.print("Nhập đáp án : ");
        String hashMap = sc.nextLine();

        if (hashMap.equalsIgnoreCase("Y")) {
            if (countHint == 0) {
                System.out.println("Bạn đã dùng hết gợi ý");
                System.out.println("Mời nhập đáp án : ");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("HashMap")) {
                    System.out.println("Đúng");
                    countcode++;                    //4
                } else System.out.println("Sai     Đáp án : HashMap");
            } else {            //Khi countHint != 0
                countHint--;
                System.out.println();
                System.out.println(countHint);

                System.out.println("Gợi ý : Has...");
                System.out.print("Mời nhập đáp án : ");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("HashMap")) {
                    System.out.println("Đúng");
                    countcode++;                    //4
                } else System.out.println("Đã gợi ý còn sai , gà vl");
            }
//            System.out.println("Gợi ý : Hash...");
//            countHint--;                    //gợi ý -4
//            String b = sc.nextLine();
//            if (b.equalsIgnoreCase("HashMap")) {
//                System.out.println("Đúng");
//                countcode++;                    //3
//            } else System.out.println("Đã gợi ý còn sai , gà vl");
        } else if (hashMap.equalsIgnoreCase("HashMap")) {
            System.out.println("Đúng");
            countcode++;                                        //4
        } else System.err.println("Sai     Đáp án : HashMap");


        System.out.println();


        System.out.println("Câu 5");
        System.out.println("Một cặp Key - Value được gọi là gì ?");
        System.out.print("Nhập đáp án : ");
        String entry = sc.nextLine();
        if (entry.equalsIgnoreCase("Y")) {
            if (countHint == 0) {
                System.out.println("Bạn đã dùng hết gợi ý");
                System.out.println("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("Entry")) {
                    System.out.println("Đúng");
                    countcode++;                    //3
                } else System.out.println("Sai     Đáp án : Entry");
            } else {            //Khi countHint != 0
                System.out.println("Gợi ý : En...");
                countHint--;                    //gợi ý -5
                System.out.println();
                System.out.println(countHint);
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("Entry")) {
                    System.out.println("Đúng");
                    countcode++;                    //5
                } else System.err.println("Đã gợi ý còn sai , gà vl");
            }
        } else if (entry.equalsIgnoreCase("Entry")) {
            System.out.println("Đúng");
            countcode++;                                    //5
        } else System.out.println("Sai       Đáp án : Entry");

        System.out.println();
        System.out.println("Câu 6");
        System.out.println("""
                        Giả sử có 2 lớp NhanVien và TruongPhong được khai báo như sau. Hãy chọn dòng mã lệnh phát sinh lỗi lúc dịch?\s

                        public class NhanVien {
                            public String hoTen;
                            protected double luong;

                            public NhanVien(String hoTen, double luong) {
                            }

                            void xuat() {
                            }

                            private double getThuNhap() {
                                return 0;
                            }
                        }


                package codegym.dn

                        public class TruongPhong extends NhanVien {
                            public double trachNhiem;

                            public TruongPhong(String hoTen, double luong, double trachNhiem) {
                            }

                            public void xuat() {
                                super.hoTen = "Tuấn";
                                super.luong = 500;
                                super.xuat();
                                double thuNhap = super.getThuNhap();
                            }
                        }
                        """);

        System.out.print(" ");
        System.out.println("""
                                Chọn đáp án dưới đây :

                                        a. super.hoTen = "Tuấn"

                                        b. double thuNhap = super.getThuNhap()

                                        c. super.luong = 500

                                        d. super.xuat()\
                """);
        String bb = sc.nextLine();
        if (bb.equalsIgnoreCase("Y")) {
            if (countHint == 0) {
                System.out.println("Bạn đã dùng hết gợi ý");
                System.out.println("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("b")) {
                    System.out.println("Đúng");
                    countcode++;                    //6
                } else System.out.println("Sai     Đáp án : b. double thuNhap = super.getThuNhap()");
            } else {            //Khi countHint != 0
                System.out.println("Gợi ý : b. double thuNhap = super.getThuNhap()");
                countHint--;
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("b")) {
                    System.out.println("Đúng");
                    countcode++;                    //6
                } else System.err.println("Sai     Đáp án : b. double thuNhap = super.getThuNhap() ");
            }
        } else if (bb.equalsIgnoreCase("B")) {
            System.out.println("Đúng");
            countcode++;                        //6
        } else System.err.println("Sai     Đáp án : b. double thuNhap = super.getThuNhap()");


        System.out.println();


        System.out.println("Câu 7");
        System.out.println("Từ khoá gì được sử dụng để kế thừa Interface ?");
        System.out.print("Nhập đáp án : ");
        String extend = sc.nextLine();
        if (extend.equalsIgnoreCase("Y")) {
            if (countHint == 0) {
                System.out.println("Bạn đã dùng hết gợi ý");
                System.out.print("Mời nhập đáp án : ");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("extends")) {
                    System.out.println("Đúng");
                    countcode++;                    //3
                } else System.err.println("Sai     Đáp án : extends");
            } else {            //Khi countHint != 0
                System.out.println("Gợi ý : ex...");
                System.out.print("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("extends")) {
                    System.out.println("Đúng");
                    countcode++;                    //3
                } else System.err.println("Sai       Đáp án : extends");
            }


//            System.err.println("Gợi ý : ex....");
//            countHint--;                    //gợi ý -7
//            String b = sc.nextLine();
//            if (b.equalsIgnoreCase("extends")) {
//                System.out.println("Đúng");
//                countcode++;                    //7
//            } else System.err.println("Đã gợi ý còn sai , gà vl");
        } else if (extend.equalsIgnoreCase("Extends")) {
            System.out.println("Đúng");
            countcode++;                        //7
        } else System.err.println("Sai       Đáp án : extends");

        System.out.println();


        System.out.println("Câu 8");
        System.out.println("         Collection  ");
        System.out.println("       ↗            ↖ ");
        System.out.println("    list      AbstractCollection");
        System.out.println("       ↖            ↗   ");
        System.out.println("            ?????        ");
        System.out.print("Nhập đáp án : ");
        String abstractList = sc.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            if (countHint == 0) {
                System.out.println("Bạn đã dùng hết gợi ý");
                System.out.println("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("AbstractList")) {
                    System.out.println("Đúng");
                    countcode++;
                } else System.err.println("Sai     Đáp án : AbstractList");
            } else {            //Khi countHint != 0
                countHint--;                    // - 7
                System.out.println("Gợi ý : Abs...");
                System.out.print("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("AbstractList")) {
                    System.out.println("Đúng");
                    countcode++;                    //7
                } else System.err.println("Sai       Đáp án : AbstractList");
            }

//            System.err.println("Gợi ý : Abst....");
//            countHint--;                    //gợi ý -8
//            String b = sc.nextLine();
//            if (b.equalsIgnoreCase("AbstractList")) {
//                System.out.println("Đúng");
//                countcode++;                    //8
//            } else System.err.println("Đã gợi ý còn sai , gà vl");

        } else if (abstractList.equalsIgnoreCase("AbstractList")) {
            System.out.println("Đúng");
            countcode++;                            //8
        } else System.err.println("Sai     Đáp án : AbstractList");


        System.out.println();
        System.out.println("Câu 9");
        System.out.println("Phương thức nào kiểm tra xem một phần tử có nằm trong danh sách không?");
        System.out.println("""
                Select one:

                A. contains()

                B. get()

                C. clear()

                D. indexOf()""");
        System.out.print("Mời nhập đáp án : ");
        String conTains = sc.nextLine();
        if (conTains.equalsIgnoreCase("Y")) {
            if (countHint == 0) {
                System.out.println("Bạn đã dùng hết gợi ý");
                System.out.println("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("A. contains()")) {
                    System.out.println("Đúng");
                    countcode++;                    //3
                } else System.err.println("Sai     Đáp án : A. contains()");
            } else {            //Khi countHint != 0
                countHint--;
                System.out.println("Gợi ý : c");
                System.out.print("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("A")) {
                    System.out.println("Đúng");
                    countcode++;                    //3
                } else System.err.println("Sai       Đáp án : A. contains()");
            }

//            System.err.println("Câu này không có gợi ý");
//            System.out.println("Mời nhập đáp án");
//            String b = sc.nextLine();
//            if (b.equalsIgnoreCase("A")) {
//                System.out.println("Đúng");
//                countcode++;                    //9
//            } else System.err.println("Đã gợi ý còn sai , gà vl");

        } else if (conTains.equalsIgnoreCase("A")) {
            System.out.println("Đúng");
            countcode++;                        //9
        } else System.err.println("Sai    Đáp án : A. contains  ");

        System.out.println();
        System.out.println("Câu 10");
        System.out.println("""
                Phương thức nào không sử dụng để duyệt cây ?

                Select one:

                a. Duyệt hậu thứ tự (Post-order Traversal)

                b. Duyệt trung thứ tự (In-order Traversal)
                \s

                c. Duyệt tiền thứ tự (Pre-order Traversal)
                \s

                d. Duyệt tuyến tính (Linear Traversal)
                Feedback
                 """);
        System.out.print("Nhập đáp án : ");
        String linearTraversal = sc.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            if (countHint == 0) {
                System.out.println("Bạn đã dùng hết gợi ý");
                System.out.println("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("D")) {
                    System.out.println("Đúng");
                    countcode++;                    //3
                } else System.err.println("Sai     Đáp án : d. Duyệt tuyến tính (Linear Traversal)\n" +
                        "                Feedback");
            } else {            //Khi countHint != 0
                countHint--;
                System.out.println("Gợi ý : Duyệt t....");
                System.out.print("Mời nhập đáp án");
                String b = sc.nextLine();
                if (b.equalsIgnoreCase("D")) {
                    System.out.println("Đúng");
                    countcode++;                    //3
                } else System.err.println("Sai       Đáp án : d. Duyệt tuyến tính (Linear Traversal)\n" +
                        "                Feedback");
            }


//            System.err.println("Câu này không có gợi ý");
//            System.out.println("Mời nhập đáp án");
//            String b = sc.nextLine();
//            if (b.equalsIgnoreCase("D")) {
//                System.out.println("Đúng");
//                countcode++;                    //10
//            } else System.err.println("Sai     Đáp án : d. Duyệt tuyến tính (Linear Traversal)\n" +
//                    "                Feedback");

        } else if (linearTraversal.equalsIgnoreCase("D")) {
            System.out.println("Đúng");
            countcode++;                    //10
        } else System.err.println("Sai     Đáp án : d. Duyệt tuyến tính (Linear Traversal)\n" +
                "                Feedback");
        return countcode;

    }

}


//Tính đến trường hợp countHint = 0
//Check lại phần gợi ý //
//Bổ sung " Hiện số lượng gợi ý còn sót lại "

//Tạo phương thức ở class khác rồi sang bên này gọi nó ra , xong cho nó = 1 cái biến nào đấy
//Tạo 1 biến dùng để gợi ý đáp án
//    public void themMonHoc() {
//        System.out.println("Nhập id sinh viên cần đăng ký:");
//        int idSV = Integer.parseInt(sc.nextLine());
//
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).id() == idSV) {
//
//            }
//        }
//    }

//    public double tinhDiemTrungBinhToan() {
//        double a = this.baiKiemTraToan();
//        double b = this.baiKiemTraCode();
////        double c = this.baiKiemTraToan();
//
//        double diem = b / 3;
//        return diem;
//    }
//    public void monHoc(){
//        System.out.println("1. Toán");
//        System.out.println("2. Java");
//        System.out.println("3. Anh");
//        System.out.println("Nhập lựa chọn");
//        int choice = Integer.parseInt(sc.nextLine());
//        switch (choice){
//            case 1 -> students.s
//        }
//    }