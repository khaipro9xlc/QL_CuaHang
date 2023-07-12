package trankhaidemo.sd17313.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trankhaidemo.sd17313.Domain.ChucVu;
import trankhaidemo.sd17313.Domain.DongSP;
import trankhaidemo.sd17313.Domain.NhanVien;
import trankhaidemo.sd17313.ViewModel.ChucVuVm;
import trankhaidemo.sd17313.ViewModel.DongSpVm;
import trankhaidemo.sd17313.repository.ChucVuRepository;

@Controller
@RequestMapping("chucvu")
public class ChucVuController {
    @Autowired
    private ChucVuRepository cvrp;

    @Autowired
    private ChucVuVm chucVuVm;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("lstcv", cvrp.findAll());
        model.addAttribute("view", "/chucvu/index");
        return "chucvu/index";
    }

    @GetMapping("create")
    public String Create(Model model) {
        model.addAttribute("chucVu", chucVuVm);
        return "chucvu/create";

    }

    @GetMapping("delete/{id}")
    public String Delete(@PathVariable("id") ChucVu chucVu) {
        this.cvrp.delete(chucVu);
        return "redirect:/chucvu/index";
    }

    @GetMapping("edit/{id}")
    public String Edit(@PathVariable("id") ChucVu chucVu, Model model) {
        chucVuVm.loadFromDomainModel(chucVu);
        model.addAttribute("chucVu", chucVuVm);
        model.addAttribute("action", "/chucvu/update/" + chucVu.getId());
        return "chucvu/edit";

    }

    @PostMapping("post")
    public String post(@Valid @ModelAttribute(name = "chucVu") ChucVuVm chucVuVm
            , BindingResult result) {
        if (result.hasErrors()) {
            return "chucvu/create";
        } else {
            ChucVu cv = new ChucVu();
            cv.loadFromViewModel(chucVuVm);
            this.cvrp.save(cv);
            return "redirect:/chucvu/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") ChucVu chucVu, @Valid @ModelAttribute(name = "chucVu") ChucVuVm chucVuVm

            , BindingResult result) {
        if (result.hasErrors()) {
            return "chucvu/edit";
        } else {
            chucVu.loadFromViewModel(chucVuVm);
            this.cvrp.save(chucVu);
            return "redirect:/chucvu/index";
        }

    }

}
