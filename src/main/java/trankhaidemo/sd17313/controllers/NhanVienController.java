package trankhaidemo.sd17313.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import trankhaidemo.sd17313.Domain.CuaHang;
import trankhaidemo.sd17313.Domain.NhanVien;
import trankhaidemo.sd17313.ViewModel.CuaHangVm;
import trankhaidemo.sd17313.ViewModel.NhanVienVm;
import trankhaidemo.sd17313.repository.ChucVuRepository;
import trankhaidemo.sd17313.repository.CuaHangRepository;
import trankhaidemo.sd17313.repository.NhanVienRopository;

import java.util.List;

@Controller
@RequestMapping("nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienRopository nvrp;

    @Autowired
    private ChucVuRepository cvrp;

    @Autowired
    private CuaHangRepository chrp;

    @Autowired
    @Qualifier("nv1")
    private NhanVienVm nv;


    public NhanVienController() {
//        lstnv.add(new NhanVien(UUID.randomUUID(),"NV1","KHAI","QUANG","TRAN","NAM","22-04-2003","236 DAI TU","0985469203","22042003","1","1","1",1));
//        lstnv.add(new NhanVien(UUID.randomUUID(),"NV2","KHAI","QUANG","TRAN","NAM","22-04-2003","236 DAI TU","0985469203","22042003","1","1","1",1));

    }

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 4);
        Page<NhanVien> nvv = nvrp.findAll(pageable);
        model.addAttribute("listnv", nvv);
        return "nhanvien/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhanVien nvdm) {
        this.nvrp.delete(nvdm);
        return "redirect:/nhanvien/index";

    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("nhanVien", nv);
        model.addAttribute("lstcv", cvrp.findAll());
        model.addAttribute("lstch", chrp.findAll());
        return "nhanvien/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") NhanVien nhanVien) {
        nv.loadFromDomainModel(nhanVien);
        model.addAttribute("nhanVien", nv);
        model.addAttribute("lstcv", cvrp.findAll());
        model.addAttribute("lstch", chrp.findAll());
        model.addAttribute("action", "/nhanvien/update/" + nhanVien.getId());
        return "nhanvien/edit";
    }

    @PostMapping("post")
    public String post(@Valid BindingResult result, @ModelAttribute(name = "nhanVien") NhanVienVm nhanvien, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("lstcv", cvrp.findAll());
            model.addAttribute("lstch", chrp.findAll());
            return "nhanvien/create";
        } else {
            NhanVien nvdm = new NhanVien();
            nvdm.loadFromViewModel(nhanvien);
            this.nvrp.save(nvdm);
            return "redirect:/nhanvien/index";
        }
    }

    //    public void update(String ma,NhanVienVm nhanVien){
//        for (int i = 0; i < lstnv.size(); i++) {
//            if (lstnv.get(i).getMa().contains(ma)){
//                lstnv.set(i,nhanVien);
//            }
//        }
//
//    }
    @PostMapping("update/{id}")
    public String update(
            @Valid @ModelAttribute(name = "nhanVien") NhanVienVm nvView,
            @PathVariable("id") NhanVien nvdm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("lstcv", cvrp.findAll());
            model.addAttribute("lstch", chrp.findAll());
            model.addAttribute("nhanVien", nvView);
            model.addAttribute("action", "/nhanvien/update/" + nvdm.getId());
            return "nhanvien/edit";
        } else {
            nvdm.loadFromViewModel(nvView);
            this.nvrp.save(nvdm);
            return "redirect:/nhanvien/index";
        }
    }


}
