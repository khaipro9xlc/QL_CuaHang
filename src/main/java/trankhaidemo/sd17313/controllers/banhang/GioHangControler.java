package trankhaidemo.sd17313.controllers.banhang;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trankhaidemo.sd17313.Domain.*;
import trankhaidemo.sd17313.ViewModel.HoaDonChiTietVm;
import trankhaidemo.sd17313.repository.ChiTietSpRepository;
import trankhaidemo.sd17313.repository.HoaDonCtRepository;
import trankhaidemo.sd17313.repository.HoaDonRepository;
import trankhaidemo.sd17313.repository.SanPhamRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("giohang")
public class GioHangControler {
    @Autowired
    private HoaDonRepository hdrp;
    @Autowired
    private ChiTietSpRepository ctspRepo;
    @Autowired
    private HoaDonCtRepository hdctrp;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private SanPhamRepository sprp;


    @GetMapping("cart")
    public String ViewGioHang(HttpServletRequest request, Model model) {
        Double tongtien = 0.0;
        httpSession = request.getSession();
        GioHang gioHang = (GioHang) httpSession.getAttribute("ghsession");
        System.out.println(gioHang.getLstGioHangChiTiets().size());
        model.addAttribute("lstcard", gioHang.getLstGioHangChiTiets());
        for (GioHangChiTiet ghct : gioHang.getLstGioHangChiTiets()) {
            tongtien += ghct.getSoLuong() * ghct.getPrice().doubleValue();
        }
        model.addAttribute("tongtien", tongtien);
        return "giohang/gio-hang";
    }

    @GetMapping("ban-hang/lich-su/mua-hang")
    public String checkLichSuMuaHang(HttpServletRequest request, Model model) {
        httpSession = request.getSession();
        KhachHang khachHang = (KhachHang) httpSession.getAttribute("kh");
        model.addAttribute("lstHoaDon", hdrp.lsthd(khachHang));
        return "giohang/lich-su-mua-hang";
    }

    @GetMapping("ban-hang/detail-hoa-don")
    public String ChitietDonhang(HttpServletRequest request, Model model) {
        UUID IdHd = UUID.fromString(request.getParameter("id"));
        HoaDon hoaDon = hdrp.findById(IdHd).orElse(null);
        List<HoaDonChiTiet> hdct = hdctrp.getListHdct(hoaDon.getId());
        List<HoaDonChiTietVm> lstHDCTVM = new ArrayList<>();
        for (int i = 0; i < hdct.size(); i++) {
            SanPham sanPham = sprp.findById(hdct.get(i).getIdChiTietSP()).orElse(null);
            HoaDonChiTietVm hdctvm = new HoaDonChiTietVm();
            hdctvm.setDonGia(hdct.get(i).getDonGia());
            hdctvm.setSoLuong(hdct.get(i).getSoLuong());
            hdctvm.setSp(sanPham);
            lstHDCTVM.add(hdctvm);
        }
        model.addAttribute("listhdct", lstHDCTVM);
        return "giohang/chi-tiet-san-pham";
    }

    @GetMapping("ban-hang/thanh-toan")
    public String thanhToanGioHang(HttpServletRequest request, Model model) {
        httpSession = request.getSession();
        if (httpSession.getAttribute("kh") == null) {
            return "login/login";
        } else {

            Double tongtien = 0.0;
            GioHang gioHang = (GioHang) httpSession.getAttribute("ghsession");
            model.addAttribute("lstCart", gioHang.getLstGioHangChiTiets());
            for (GioHangChiTiet ghct : gioHang.getLstGioHangChiTiets()) {
                tongtien += ghct.getSoLuong() * ghct.getPrice().doubleValue();
            }
            model.addAttribute("tongTien", tongtien);
            return "giohang/thanh-toan";
        }
    }

    @PostMapping("ban-hang/xac-nhan")
    public String dopost(HttpServletRequest request) {
        httpSession = request.getSession();
        String tenNguoiNhan = request.getParameter("tenNguoiNhan");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        GioHang gioHang = (GioHang) httpSession.getAttribute("ghsession");
        KhachHang khachHang = (KhachHang) httpSession.getAttribute("kh");
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa("HD00" + hdrp.findAll().size());
        hoaDon.setKh(khachHang);
        hoaDon.setNgayTao(new Date());
        hoaDon.setDiaChi(diaChi);
        hoaDon.setSdt(sdt);
        hoaDon.setTenNguoiNhan(tenNguoiNhan);
        hoaDon.setTinhTrang(1);
        hdrp.save(hoaDon);
        for (int i = 0; i < gioHang.getLstGioHangChiTiets().size(); i++) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setIdHoaDon(hoaDon.getId());
            ChiTietSP chiTietSP = ctspRepo.findById(gioHang.getLstGioHangChiTiets().get(i).getIdSP()).orElse(null);
            hoaDonChiTiet.setIdChiTietSP(chiTietSP.getId());
            hoaDonChiTiet.setDonGia(gioHang.getLstGioHangChiTiets().get(i).getPrice());
            hoaDonChiTiet.setSoLuong(gioHang.getLstGioHangChiTiets().get(i).getSoLuong());
            hdctrp.save(hoaDonChiTiet);
        }
        httpSession.removeAttribute("ghsession");
        return "redirect:/home";

    }

}
