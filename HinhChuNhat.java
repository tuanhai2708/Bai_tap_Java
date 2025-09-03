package baitaptrenlop;

public class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double tinhChuVi() {
        return 2* (chieuRong + chieuDai);
    }

    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    public void HienthiThongtin() {
        System.out.println("Hình Chữ Nhật");
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Dien tich: " + tinhDienTich());
    }

    public static void main(String[] args) {
        HinhChuNhat hcn1 = new HinhChuNhat(5,3);
        HinhChuNhat hcn2 = new HinhChuNhat(7.5,4.2);

        hcn1.HienthiThongtin();
        hcn2.HienthiThongtin();
    }
}
