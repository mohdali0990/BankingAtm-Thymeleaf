package BankingAtm.Thymeleaf.Controller;

import BankingAtm.Thymeleaf.Model.CheckingAccount;
import BankingAtm.Thymeleaf.Model.Customer;
import BankingAtm.Thymeleaf.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.constraints.NotEmpty;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }

    @GetMapping("/showNewCustomerForm")
    public String newCustomerForm(Model model){
//        Customer customer = new Customer();
//        model.addAttribute("customer",customer);
        return "new_customer";
    }

    @GetMapping("/newcheckingaccount")
    public String newCheckingAccount(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "new_checking_account";
    }

    @PostMapping("/createcheckingaccount")
    public String newCheckingAccount(String firstName, String lastName, Integer firstCheckingAmount, Model model, SessionStatus status){
        Customer customer = customerService.newCheckingAccount(firstName, lastName, firstCheckingAmount);
                model.addAttribute("customer",customer );

                status.setComplete();

                return "success";
    }
}
