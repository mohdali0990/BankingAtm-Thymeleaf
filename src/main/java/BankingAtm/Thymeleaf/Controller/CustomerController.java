package BankingAtm.Thymeleaf.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }
}
