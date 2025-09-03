package baitaptrenlop;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private int tuoi;
    private static int tongSoSV = 0;

    public SinhVien(String maSV, String hoTen, int tuoi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        tongSoSV++;
    }


    public void hienThiThongTin() {
        System.out.println("Mã SV: " + maSV);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("------------------------");
    }

    public static void hienThiTongSoSV() {
        System.out.println("Tổng số sinh viên đã tạo: " + tongSoSV);
    }

    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien("D24CC06", "Tran Tuan Hai", 20);
        SinhVien sv2 = new SinhVien("D24CC07", "Nguyen Van A", 21);
        SinhVien sv3 = new SinhVien("D24CC08", "Le Thi B", 19);


        sv1.hienThiThongTin();
        sv2.hienThiThongTin();
        sv3.hienThiThongTin();

        SinhVien.hienThiTongSoSV();
    }
}
