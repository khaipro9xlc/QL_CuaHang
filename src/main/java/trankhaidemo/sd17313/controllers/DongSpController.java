package trankhaidemo.sd17313.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trankhaidemo.sd17313.Domain.DongSP;
import trankhaidemo.sd17313.ViewModel.DongSpVm;
import trankhaidemo.sd17313.repository.DongSpRepository;

@Controller
@RequestMapping("dongsp")
public class DongSpController {
    @Autowired
    private DongSpRepository dsprp;

    @Autowired
    private DongSpVm dongSpVm;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("lstdsp", dsprp.findAll());
        return "dongsp/index";
    }

    @GetMapping("delete/{id}")
    public String Delete(@PathVariable("id") DongSP dongSP) {
        this.dsprp.delete(dongSP);
        return "redirect:/dongsp/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("dongSp", dongSpVm);
        return "dongsp/create";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") DongSP dongSP, Model model) {
        dongSpVm.loadFromDomainModel(dongSP);
        model.addAttribute("dongSp", dongSpVm);
        model.addAttribute("action", "/dongsp/update/" + dongSP.getId());
        return "dongsp/edit";

    }

    @PostMapping("post")
    public String post(@Valid @ModelAttribute(name = "dongSp") DongSpVm dongSpVm
            , BindingResult result) {
        if (result.hasErrors()) {
            return "dongsp/create";
        } else {
            DongSP dongSP = new DongSP();
            dongSP.loadFromViewModel(dongSpVm);
            this.dsprp.save(dongSP);
            return "redirect:/dongsp/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute(name = "dongSp") DongSpVm dongSpVm
            , @PathVariable("id") DongSP dongSP
            , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "dongsp/edit";
        } else {
            dongSP.loadFromViewModel(dongSpVm);
            this.dsprp.save(dongSP);
            return "redirect:/dongsp/index";
        }

    }
}
