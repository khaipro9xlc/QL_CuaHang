package trankhaidemo.sd17313.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trankhaidemo.sd17313.Domain.NSX;
import trankhaidemo.sd17313.Domain.SanPham;
import trankhaidemo.sd17313.ViewModel.NSXVm;
import trankhaidemo.sd17313.ViewModel.SanPhamVm;
import trankhaidemo.sd17313.repository.NsxRepository;

@Controller
@RequestMapping("nsx")
public class NsxController {
    @Autowired
    private NsxRepository nsxrp;

    @Autowired
    private NSXVm nsxVm;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("lstnsx", nsxrp.findAll());
        return "nsx/index";
    }

    @GetMapping("create")
    public String Create(Model model) {
        model.addAttribute("nSx", nsxVm);
        return "nsx/create";

    }

    @GetMapping("delete/{id}")
    public String Delete(@PathVariable("id") NSX nsx) {
        this.nsxrp.delete(nsx);
        return "redirect:/nsx/index";
    }

    @GetMapping("edit/{id}")
    public String Edit(@PathVariable("id") NSX nsx, Model model) {
        nsxVm.loadFromDomainModel(nsx);
        model.addAttribute("nSx", nsxVm);
        model.addAttribute("action", "/nsx/update/" + nsx.getId());
        return "nsx/edit";

    }

    @PostMapping("post")
    public String post(@Valid @ModelAttribute(name = "nSx") NSXVm nsxVm
            , BindingResult result) {
        if (result.hasErrors()) {
            return "nsx/create";
        } else {
            NSX nsx = new NSX();
            nsx.loadFromViewModel(nsxVm);
            this.nsxrp.save(nsx);
            return "redirect:/nsx/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute(name = "nSx") NSXVm nsxVm
            , @PathVariable("id") NSX nsx
            , BindingResult result) {
        if (result.hasErrors()) {
            return "nsx/edit";
        } else {
            nsx.loadFromViewModel(nsxVm);
            this.nsxrp.save(nsx);
            return "redirect:/nsx/index";
        }

    }
}
