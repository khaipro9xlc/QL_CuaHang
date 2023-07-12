package trankhaidemo.sd17313.ViewModel;

import java.math.BigDecimal;

public class GioHangChiTietVm {
    private String IdGioHang;
    private String IdChiTietSP;
    private int SoLuong;
    private BigDecimal DonGia;
    private BigDecimal DonGiaKhiGiam;

    public GioHangChiTietVm() {
    }

    public GioHangChiTietVm(String idGioHang, String idChiTietSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        IdGioHang = idGioHang;
        IdChiTietSP = idChiTietSP;
        SoLuong = soLuong;
        DonGia = donGia;
        DonGiaKhiGiam = donGiaKhiGiam;
    }

    public String getIdGioHang() {
        return IdGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        IdGioHang = idGioHang;
    }

    public String getIdChiTietSP() {
        return IdChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        IdChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return DonGia;
    }

    public void setDonGia(BigDecimal donGia) {
        DonGia = donGia;
    }

    public BigDecimal getDonGiaKhiGiam() {
        return DonGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        DonGiaKhiGiam = donGiaKhiGiam;
    }
}
