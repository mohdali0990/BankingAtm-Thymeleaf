package BankingAtm.Thymeleaf.Controller;

import BankingAtm.Thymeleaf.Model.CheckingAccount;
import BankingAtm.Thymeleaf.Repository.CheckingAccountRepo;
import BankingAtm.Thymeleaf.Service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class CheckingAccountController {

    @Autowired
    private CheckingService checkingService;

    @GetMapping("/accesschecking")
    public String accessAccount(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingaccount", checkingAccount);
        return "checking_account_action";
    }

    @GetMapping("/withdrawal")
    public String withdrawal(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "find_checking_account";
    }

    @GetMapping("/findcheckingaccount/{id}")
    public String getAccount(@PathVariable("id") Integer checkingId, Model model) {
        CheckingAccount checkingAccount = checkingService.getAccount(checkingId);
        model.addAttribute("checkingAccount", checkingAccount);
        return "Found_checking_account";
    }
}
