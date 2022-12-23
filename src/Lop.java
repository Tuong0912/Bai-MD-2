public class Lop {
    private String tenLop; //Thuộc tính của Lop

    public Lop(String tenLop) { //Constructor có tham số
        this.tenLop = tenLop;
    }

    public Lop() { // Constructor không tham số
    }

    public String getTenLop() { //getter
        return tenLop;
    }

    public void setTenLop(String tenLop) { //getter
        this.tenLop = tenLop;
    }

    @Override
    public String toString() {
        return tenLop;
    }
}
