package baitaptrenlop;

import java.util.*;

public class TaiKhoan {
    private String soTaiKhoan;
    private String tenChuTaiKhoan;
    private double soDu;
    private static double laiSuatNam = 0.05; // 5%

    public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.soDu = soDu;
    }

    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
        }
    }

    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
        }
    }

    public double tinhLaiMotThang() {
        return soDu * (laiSuatNam / 12);
    }

    public void hienThiThongTin() {
        System.out.println("Số TK: " + soTaiKhoan);
        System.out.println("Chủ TK: " + tenChuTaiKhoan);
        System.out.println("Số dư: " + soDu);
        System.out.println("Lãi tháng: " + tinhLaiMotThang());
        System.out.println("------------------------");
    }

    public static void thayDoiLaiSuat(double laiSuatMoi) {
        laiSuatNam = laiSuatMoi;
    }

    public static void hienThiLaiSuat() {
        System.out.println("Lãi suất năm hiện tại: " + (laiSuatNam * 100) + "%");
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public static void main(String[] args) {
        List<TaiKhoan> danhSach = new ArrayList<>();
        danhSach.add(new TaiKhoan("TK001", "Nguyen Van A", 10000));
        danhSach.add(new TaiKhoan("TK002", "Tran Thi B", 15000));
        danhSach.add(new TaiKhoan("TK003", "Le Van C", 8000));

        // Giao dịch
        danhSach.get(0).napTien(2000);
        danhSach.get(1).rutTien(3000);
        danhSach.get(2).napTien(500);

        // Hiển thị thông tin
        for (TaiKhoan tk : danhSach) {
            tk.hienThiThongTin();
        }

        // Hiển thị lãi suất
        TaiKhoan.hienThiLaiSuat();

        // Tìm kiếm theo số tài khoản
        String soTKCanTim = "TK002";
        for (TaiKhoan tk : danhSach) {
            if (tk.getSoTaiKhoan().equals(soTKCanTim)) {
                System.out.println("Tìm thấy tài khoản:");
                tk.hienThiThongTin();
            }
        }

        // Sắp xếp theo số dư giảm dần
        danhSach.sort((a, b) -> Double.compare(b.getSoDu(), a.getSoDu()));
        System.out.println("Danh sách sau khi sắp xếp theo số dư giảm dần:");
        for (TaiKhoan tk : danhSach) {
            tk.hienThiThongTin();
        }
    }
}
