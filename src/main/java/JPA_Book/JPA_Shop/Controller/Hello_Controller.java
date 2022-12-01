package JPA_Book.JPA_Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello_Controller {

    @GetMapping("/Hello")
    public String Hello(Model model)
    {
        model.addAttribute("data","Hello");
        return "Hello";
    }
}
