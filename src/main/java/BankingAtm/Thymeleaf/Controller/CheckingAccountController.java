package BankingAtm.Thymeleaf.Controller;

import BankingAtm.Thymeleaf.Model.CheckingAccount;
import BankingAtm.Thymeleaf.Repository.CheckingAccountRepo;
import BankingAtm.Thymeleaf.Service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class CheckingAccountController {

    @Autowired
    private CheckingService checkingService;


    @GetMapping("/accesschecking")
    public String withdrawal(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "find_checking_account";
    }

    @GetMapping("/findcheckingaccount")
    public String getAccount(@RequestParam(value = "checkingId") Integer checkingId, Model model) {
        CheckingAccount checkingAccount = checkingService.getAccount(checkingId);
        model.addAttribute("checkingAccount", checkingAccount);
        return "Found_checking_account";
    }

    @GetMapping("/withdrawalbutton")
    public String withdrawalbutton(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "withdrawal_checkingaccount";
    }

    @GetMapping("/checkingwithdrawal")
    public String withdrawal(@RequestParam("checkingId") Integer id, @RequestParam(value = "addOrMinusBalance") Integer amountWithdraw, Model model){
        CheckingAccount checkingAccount = checkingService.withdrawal(id,amountWithdraw);
        model.addAttribute("withdrawal", checkingAccount);
        return "Found_checking_account";
    }
}
