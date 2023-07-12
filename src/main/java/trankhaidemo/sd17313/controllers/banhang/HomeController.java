package trankhaidemo.sd17313.controllers.banhang;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trankhaidemo.sd17313.Domain.ChiTietSP;
import trankhaidemo.sd17313.Domain.GioHang;
import trankhaidemo.sd17313.Domain.GioHangChiTiet;
import trankhaidemo.sd17313.repository.ChiTietSpRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller

public class HomeController {
    @Autowired
    private ChiTietSpRepository ctspRepo;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("home")
    public String doget(HttpServletRequest request, Model model) {
        model.addAttribute("lstCTSP", ctspRepo.findAll());
        return "home/trang-chu";

    }

    @GetMapping("add-to-cart")
    public String addToCart(HttpServletRequest request) {
        int sl = 1;
        String id = request.getParameter("id");
        ChiTietSP chiTietSP = ctspRepo.findById(UUID.fromString(id)).orElse(null);
        httpSession = request.getSession();
        if (httpSession.getAttribute("ghsession") == null) {
            GioHang gioHang = new GioHang();
            List<GioHangChiTiet> lstGHCT = new ArrayList<>();
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setIdSP(chiTietSP.getId());
            gioHangChiTiet.setTenSP(chiTietSP.getSp().getTen());
            gioHangChiTiet.setPrice(chiTietSP.getGiaBan());
            gioHangChiTiet.setSoLuong(sl);
            lstGHCT.add(gioHangChiTiet);
            gioHang.setLstGioHangChiTiets(lstGHCT);
            httpSession.setAttribute("ghsession", gioHang);
            httpSession.setAttribute("slgh", gioHang.getLstGioHangChiTiets().size());
        } else {
            GioHang gioHang = (GioHang) httpSession.getAttribute("ghsession");
            Boolean kq = false;
            for (GioHangChiTiet ghct : gioHang.getLstGioHangChiTiets()) {
                if (ghct.getIdSP().equals(UUID.fromString(id))) {
                    ghct.setSoLuong(ghct.getSoLuong() + sl);
                    kq = true;
                }
            }
            if (kq == false) {
                List<GioHangChiTiet> lstGHCT = gioHang.getLstGioHangChiTiets();
                GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
                gioHangChiTiet.setIdSP(chiTietSP.getId());
                gioHangChiTiet.setTenSP(chiTietSP.getSp().getTen());
                gioHangChiTiet.setPrice(chiTietSP.getGiaBan());
                gioHangChiTiet.setSoLuong(sl);
                lstGHCT.add(gioHangChiTiet);
                gioHang.setLstGioHangChiTiets(lstGHCT);
            }
            httpSession.setAttribute("ghsession", gioHang);
            httpSession.setAttribute("slgh", gioHang.getLstGioHangChiTiets().size());
        }
        return "redirect:/home";

    }

    @GetMapping("ThemSp")
    public String Themsp(HttpServletRequest request) {
        int sl = 1;
        httpSession = request.getSession();
        String id = request.getParameter("id");
        GioHang gh = (GioHang) httpSession.getAttribute("ghsession");
        for (int i = 0; i < gh.getLstGioHangChiTiets().size(); i++) {
            if (gh.getLstGioHangChiTiets().get(i).getIdSP().equals(UUID.fromString(id))) {
                gh.getLstGioHangChiTiets().get(i).setSoLuong(gh.getLstGioHangChiTiets().get(i).getSoLuong() + 1);
                break;
            }
        }
        httpSession.setAttribute("ghsession", gh);
        httpSession.setAttribute("slgh", gh.getLstGioHangChiTiets().size());
        return "redirect:/giohang/cart";
    }

    @GetMapping("xoasp")
    public String xoasp(HttpServletRequest request) {
        int sl = 1;
        httpSession = request.getSession();
        String id = request.getParameter("id");
        GioHang gh = (GioHang) httpSession.getAttribute("ghsession");
        for (int i = 0; i < gh.getLstGioHangChiTiets().size(); i++) {
            if (gh.getLstGioHangChiTiets().get(i).getIdSP().equals(UUID.fromString(id))) {
                if (gh.getLstGioHangChiTiets().get(i).getSoLuong() <= 1) {
                    gh.getLstGioHangChiTiets().remove(i);
                } else {
                    gh.getLstGioHangChiTiets().get(i).setSoLuong(gh.getLstGioHangChiTiets().get(i).getSoLuong() - 1);

                }
            }
        }
        httpSession.setAttribute("ghsession", gh);
        httpSession.setAttribute("slgh", gh.getLstGioHangChiTiets().size());
        return "redirect:/giohang/cart";
    }


}
