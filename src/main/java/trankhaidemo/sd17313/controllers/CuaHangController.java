package trankhaidemo.sd17313.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trankhaidemo.sd17313.Domain.CuaHang;
import trankhaidemo.sd17313.Service.CuaHangService;
import trankhaidemo.sd17313.ViewModel.CuaHangVm;
import trankhaidemo.sd17313.repository.CuaHangRepository;

import java.util.UUID;

@Controller
@RequestMapping("cuahang")
public class CuaHangController {
    @Autowired
    private CuaHangVm chvm;

    @Autowired
    private CuaHangRepository chrp;


    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<CuaHang> ch = chrp.findAll(pageable);
        model.addAttribute("lstds", ch);
        return "cuahang/index";
    }

//    @GetMapping("detail/{ma}")
//    public String detail(Model model,@PathVariable("id") UUID id) {
//        model.addAttribute("lstds", chrp.findAll());
//
//        return "cuahang/update";
//    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("cuaHang", chvm);
        return "cuahang/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") CuaHang cuaHang) {
        chvm.loadFromDomainModel(cuaHang);
        model.addAttribute("cuaHang", chvm);
        model.addAttribute("action", "/cuahang/update/" + cuaHang.getId());
        return "cuahang/edit";
    }

    @GetMapping("delete/{id}")
    public String Delete(@PathVariable("id") CuaHang cuaHang) {
        this.chrp.delete(cuaHang);
        return "redirect:/cuahang/index";
    }

    @PostMapping("post")
    public String post(@Valid @ModelAttribute(name = "cuaHang") CuaHangVm chview, BindingResult result) {
        if (result.hasErrors()) {
            return "cuahang/create";
        } else {
            CuaHang ch = new CuaHang();
            ch.loadFromViewModel(chview);
            this.chrp.save(ch);
            return "redirect:/cuahang/index";
        }

    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute(name = "cuaHang") CuaHangVm chvm
            , @PathVariable("id") CuaHang cuaHang
            , BindingResult result
            , Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cuaHang", chvm);
            model.addAttribute("action", "/cuahang/update/" + cuaHang.getId());
            return "cuahang/edit";
        } else {
            cuaHang.loadFromViewModel(chvm);
            this.chrp.save(cuaHang);
            return "redirect:/cuahang/index";
        }
    }
}

