package BankingAtm.Thymeleaf.Controller;

import BankingAtm.Thymeleaf.Model.CheckingAccount;
import BankingAtm.Thymeleaf.Repository.CheckingAccountRepo;
import BankingAtm.Thymeleaf.Service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckingAccountController {

    @Autowired
    private CheckingService checkingService;

    @GetMapping("/accesschecking")
    public String accessAccount(Model model){
    CheckingAccount checkingAccount = new CheckingAccount();
    model.addAttribute("checkingaccount", checkingAccount);
    return "checking_account_action";
}

    @GetMapping("/withdrawal")
    public String withdrawal(Integer minusBalance , Integer id, Model model){
        CheckingAccount checkingAccount = checkingService.withdrawal(minusBalance, id);
        model.addAttribute("checkingAccount", checkingAccount)
        return
    }
}
