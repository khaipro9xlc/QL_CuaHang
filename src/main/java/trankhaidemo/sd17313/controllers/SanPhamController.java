package trankhaidemo.sd17313.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trankhaidemo.sd17313.Domain.ChucVu;
import trankhaidemo.sd17313.Domain.SanPham;
import trankhaidemo.sd17313.ViewModel.ChucVuVm;
import trankhaidemo.sd17313.ViewModel.SanPhamVm;
import trankhaidemo.sd17313.repository.SanPhamRepository;

@Controller
@RequestMapping("sanpham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository sprp;

    @Autowired
    private SanPhamVm sanPhamVm;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("lstsp", sprp.findAll());
        return "sanpham/index";
    }

    @GetMapping("create")
    public String Create(Model model) {
        model.addAttribute("sanPham", sanPhamVm);
        return "sanpham/create";

    }

    @GetMapping("delete/{id}")
    public String Delete(@PathVariable("id") SanPham sanPham) {
        this.sprp.delete(sanPham);
        return "redirect:/sanpham/index";
    }

    @GetMapping("edit/{id}")
    public String Edit(@PathVariable("id") SanPham sanPham, Model model) {
        sanPhamVm.loadFromDomainModel(sanPham);
        model.addAttribute("sanPham", sanPhamVm);
        model.addAttribute("action", "/sanpham/update/" + sanPham.getId());
        return "sanpham/edit";

    }

    @PostMapping("post")
    public String post(@Valid @ModelAttribute(name = "sanPham") SanPhamVm sanPhamVm
            , BindingResult result) {
        if (result.hasErrors()) {
            return "sanpham/create";
        } else {
            SanPham sanPham = new SanPham();
            sanPham.loadFromViewModel(sanPhamVm);
            this.sprp.save(sanPham);
            return "redirect:/sanpham/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute(name = "sanPham") SanPhamVm sanPhamVm
            , @PathVariable("id") SanPham sanPham
            , BindingResult result) {
        if (result.hasErrors()) {
            return "sanpham/edit";
        } else {
            sanPham.loadFromViewModel(sanPhamVm);
            this.sprp.save(sanPham);
            return "redirect:/sanpham/index";
        }

    }
}
