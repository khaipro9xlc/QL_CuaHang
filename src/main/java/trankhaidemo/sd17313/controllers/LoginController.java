package trankhaidemo.sd17313.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trankhaidemo.sd17313.Domain.KhachHang;
import trankhaidemo.sd17313.repository.KhachHangRepository;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private KhachHangRepository khRepo;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("login")
    public String getLoginForm(HttpServletRequest request) {
        return "login/login";
    }

    @PostMapping("/ban-hang/login")
    public String welcomepage(HttpServletRequest request) {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        KhachHang kh = this.khRepo.khachHangLogin(ma, matKhau);
        httpSession = request.getSession();
        if (kh == null) {
            httpSession.setAttribute("errorMessage", "Sai tài khoản/mật khẩu");
            return "redirect:/login";
        } else {
            httpSession.setAttribute("kh", kh);
            return "redirect:/home";
        }

    }


}
