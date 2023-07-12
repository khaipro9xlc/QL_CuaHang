package trankhaidemo.sd17313.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trankhaidemo.sd17313.Domain.KhachHang;
import trankhaidemo.sd17313.ViewModel.KhachHangVm;
import trankhaidemo.sd17313.repository.KhachHangRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangVm khachHangVm;

    @Autowired
    private KhachHangRepository khrp;

    @GetMapping("index")
    private String index(Model model) {
        model.addAttribute("listkh", khrp.findAll());
        return "khachhang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang) {
        this.khrp.delete(khachHang);
        return "redirect:/khachhang/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("khachhang", khachHangVm);
        return "khachhang/create";
    }

    //    public KhachHangVm detail(String ma){
//        for (KhachHangVm kh : lstkh){
//            if (kh.getMa().equals(ma)){
//                return kh;
//            }
//        }
//        return null;
//    }
//    public void update(String ma, KhachHangVm khachHangVm){
//        for (int i = 0; i < lstkh.size(); i++) {
//            if (lstkh.get(i).getMa().contains(ma)){
//                lstkh.set(i, khachHangVm);
//            }
//        }
//    }
    @PostMapping("post")
    public String store(@Valid @ModelAttribute(name = "khachhang") KhachHangVm khvm, BindingResult result) {
        if (result.hasErrors()) {
            return "khachhang/create";
        } else {
            KhachHang khachHang = new KhachHang();
            khachHang.LoadformViewModel(khvm);
            this.khrp.save(khachHang);
            return "redirect:/khachhang/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") KhachHang khachHang, @Valid @ModelAttribute(name = "khachhang") KhachHangVm khvm, BindingResult result) {
        if (result.hasErrors()) {
            return "khachhang/edit";
        } else {
            khachHang.LoadformViewModel(khvm);
            this.khrp.save(khachHang);
            return "redirect:/khachhang/index";
        }
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") KhachHang khachHang) {
        khachHangVm.LoadformDomainModel(khachHang);
        model.addAttribute("khachhang", khachHangVm);
        model.addAttribute("action", "/khachhang/update/" + khachHang.getId());
        return "khachhang/edit";
    }


}
