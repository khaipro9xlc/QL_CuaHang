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
import trankhaidemo.sd17313.Domain.ChiTietSP;
import trankhaidemo.sd17313.ViewModel.ChiTietSanPhamVm;
import trankhaidemo.sd17313.repository.*;

@Controller
@RequestMapping("chitietsp")
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSpRepository ctsprp;

    @Autowired
    private SanPhamRepository sprp;

    @Autowired
    private NsxRepository nsxrp;

    @Autowired
    private MauSacRepository msrp;

    @Autowired
    private DongSpRepository dsprp;

    @Autowired
    private ChiTietSanPhamVm ctspvm;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 4);
        Page<ChiTietSP> ctsp = ctsprp.findAll(pageable);
        model.addAttribute("lstctsp", ctsp);
        return "chitietsp/index";
    }

    @GetMapping("delete/{id}")
    public String Delete(@PathVariable("id") ChiTietSP chiTietSP) {
        this.ctsprp.delete(chiTietSP);
        return "redirect:/chitietsp/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("chitietSp", ctspvm);
        model.addAttribute("lstsp", sprp.findAll());
        model.addAttribute("lstnsx", nsxrp.findAll());
        model.addAttribute("lstms", msrp.findAll());
        model.addAttribute("lstdsp", dsprp.findAll());
        return "chitietsp/create";
    }

    @GetMapping("edit/{id}")
    public String Edit(@PathVariable("id") ChiTietSP ctsp, Model model) {
        ctspvm.loadFromDomainModel(ctsp);
        model.addAttribute("chitietSp", ctspvm);
        model.addAttribute("lstsp", sprp.findAll());
        model.addAttribute("lstnsx", nsxrp.findAll());
        model.addAttribute("lstms", msrp.findAll());
        model.addAttribute("lstdsp", dsprp.findAll());
        model.addAttribute("action", "/chitietsp/update/" + ctsp.getId());
        return "chitietsp/edit";
    }

    @PostMapping("post")
    public String post(@Valid @ModelAttribute(name = "chitietSp") ChiTietSanPhamVm ctspvm, BindingResult result

            , Model model) {
        if (result.hasErrors()) {
            model.addAttribute("lstsp", sprp.findAll());
            model.addAttribute("lstnsx", nsxrp.findAll());
            model.addAttribute("lstms", msrp.findAll());
            model.addAttribute("lstdsp", dsprp.findAll());
            return "chitietsp/create";
        } else {
            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.loadFromViewModel(ctspvm);
            this.ctsprp.save(chiTietSP);
            return "redirect:/chitietsp/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") ChiTietSP ctsp, Model model
            , @Valid @ModelAttribute(name = "chitietSp") ChiTietSanPhamVm ctspvm
            , BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("lstsp", sprp.findAll());
            model.addAttribute("lstnsx", nsxrp.findAll());
            model.addAttribute("lstms", msrp.findAll());
            model.addAttribute("lstdsp", dsprp.findAll());
            model.addAttribute("chitietSp", ctspvm);
            model.addAttribute("action", "/chitietsp/update/" + ctsp.getId());
            return "chitietsp/edit";

        } else {
            ctsp.loadFromViewModel(ctspvm);
            this.ctsprp.save(ctsp);
            return "redirect:/chitietsp/index";
        }

    }

}
