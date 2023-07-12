package trankhaidemo.sd17313.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("say-hello")
    public String sayhello() {
        return "Hello";
    }

    @ModelAttribute("chuyennganh")
    public String getNganh() {
        return "Ptpm java";
    }


}
