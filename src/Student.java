import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String ten;
    private int tuoi;
    private String gender;
    private String diaChi;
    private double dtb;
    private int id;
    private String monHoc;
    private Lop lop; //Khai báo 1 thuộc tính class trong class

    public Lop lop() {
        return lop;
    }

    public String tenLop() {
        return lop.getTenLop();
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public Student() {
    }

    public Student(Lop tenLop) { // Constructor có 1 tham số
        this.lop = tenLop;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }


    public Student(int id, String ten, int tuoi, String gender, String diaChi, double dtb, Lop tenLop, String monHoc) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gender = gender;
        this.diaChi = diaChi;
        this.dtb = dtb;
        this.id = id;
        this.lop = tenLop;
        this.monHoc = monHoc;
    }

    public String ten() {
        return ten;
    }


    public void setTen(String ten) {
        this.ten = ten;
    }

    public int tuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String gender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String diaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double dtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                " ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", gender='" + gender + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", dtb=" + dtb +

                ", lop=" + lop +
                ", monHoc='" + monHoc + '\'';
    }

}
//    public void addMonHoc() {
//        System.out.println("Nhập id môn học"); // Bỏ
//        Scanner sc = new Scanner(System.in);
//        int id = Integer.parseInt(sc.nextLine());
//        dsMonHoc.add(new MonHoc(id));
//    }


//    public List<MonHoc> getDsMonHoc() {
//        return dsMonHoc;
//    } // Bỏ

//    public void setDsMonHoc(List<MonHoc> dsMonHoc) {
//        this.dsMonHoc = dsMonHoc;
//    }