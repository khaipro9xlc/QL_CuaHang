package trankhaidemo.sd17313.controllers.banhang;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trankhaidemo.sd17313.Domain.HoaDon;
import trankhaidemo.sd17313.Domain.NhanVien;
import trankhaidemo.sd17313.repository.HoaDonRepository;
import trankhaidemo.sd17313.repository.NhanVienRopository;

import java.io.IOException;
import java.util.UUID;

@Controller
public class AdMinController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private HoaDonRepository hdrp;
    @Autowired
    private NhanVienRopository nvrp;

    @GetMapping("admin/xacnhan")
    public String XacNhanDonHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idhd = request.getParameter("id");
        HoaDon hoaDon = hdrp.getOne(UUID.fromString(idhd));
        hoaDon.setTinhTrang(2);
        hdrp.save(hoaDon);
        return "redirect:/home/admin";
    }

    @GetMapping("admin/tuchoi")
    public String TuChoiDonHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idhd = request.getParameter("id");
        HoaDon hoaDon = hdrp.getOne(UUID.fromString(idhd));
        hoaDon.setTinhTrang(3);
        hdrp.save(hoaDon);
        return "redirect:/home/admin";
    }

    @PostMapping("login/admin")
    public String loginadmin(HttpServletRequest request, Model model) throws IOException {

        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        NhanVien nv = this.nvrp.login(ma, matKhau);
        httpSession = request.getSession();
        if (nv == null) {
            httpSession.setAttribute("errorMessage", "Sai tài khoản/mật khẩu");
            return "login/loginAdmin";
        } else {
            httpSession.setAttribute("adminTK", nv);
            return "redirect:/home/admin";
        }
    }

    @GetMapping("viewloginadmin")
    public String getLoginForm(HttpServletRequest request) {

        return "login/loginAdmin";
    }

    @GetMapping("home/admin")
    public String home(HttpServletRequest request, Model model) {
        model.addAttribute("lstHoaDon", hdrp.findAll());
        return "home/admin";
    }


}
