package trankhaidemo.sd17313.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trankhaidemo.sd17313.Domain.MauSac;
import trankhaidemo.sd17313.Domain.SanPham;
import trankhaidemo.sd17313.ViewModel.MauSacVm;
import trankhaidemo.sd17313.ViewModel.SanPhamVm;
import trankhaidemo.sd17313.repository.MauSacRepository;

@Controller
@RequestMapping("mausac")
public class MauSacController {
    @Autowired
    private MauSacRepository msrp;

    @Autowired
    private MauSacVm mauSacVm;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("lstms", msrp.findAll());
        return "mausac/index";
    }

    @GetMapping("create")
    public String Create(Model model) {
        model.addAttribute("mauSac", mauSacVm);
        return "mausac/create";

    }

    @GetMapping("delete/{id}")
    public String Delete(@PathVariable("id") MauSac mauSac) {
        this.msrp.delete(mauSac);
        return "redirect:/mausac/index";
    }

    @GetMapping("edit/{id}")
    public String Edit(@PathVariable("id") MauSac mauSac, Model model) {
        mauSacVm.loadFromDomainModel(mauSac);
        model.addAttribute("mauSac", mauSacVm);
        model.addAttribute("action", "/mausac/update/" + mauSac.getId());
        return "mausac/edit";

    }

    @PostMapping("post")
    public String post(@Valid @ModelAttribute(name = "mauSac") MauSacVm mauSacVm
            , BindingResult result) {
        if (result.hasErrors()) {
            return "mausac/create";
        } else {
            MauSac mauSac = new MauSac();
            mauSac.loadFromViewModel(mauSacVm);
            this.msrp.save(mauSac);
            return "redirect:/mausac/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute(name = "mauSac") MauSacVm mauSacVm
            , @PathVariable("id") MauSac mauSac
            , BindingResult result) {
        if (result.hasErrors()) {
            return "mausac/edit";
        } else {
            mauSac.loadFromViewModel(mauSacVm);
            this.msrp.save(mauSac);
            return "redirect:/mausac/index";
        }

    }
}
