package BankingAtm.Thymeleaf.Controller;

import BankingAtm.Thymeleaf.Model.CheckingAccount;
import BankingAtm.Thymeleaf.Service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

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

    @GetMapping("/checkingwithdrawalbutton")
    public String withdrawalbutton(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "withdrawal_checkingaccount";
    }

    @PostMapping("/checkingwithdrawal")
    public String withdrawal(@RequestParam("checkingId") Integer checkingId, @RequestParam("addOrMinusBalance") Integer addOrMinusBalance, Model model) {
        CheckingAccount checkingAccount = checkingService.withdrawal(checkingId, addOrMinusBalance);
        model.addAttribute("checkingAccount", checkingAccount);
        return "Found_checking_account";
    }

    @GetMapping("/checkingdepositbutton")
    public String dipositbutton(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "deposit_checkingaccount";
    }

    @PostMapping(value = "/checkingdeposit")
    public String deposit(@RequestParam("checkingId") Integer checkingId, @RequestParam("addOrMinusBalance") @NotEmpty Integer addOrMinusBalance, Model model) {
        CheckingAccount checkingAccount = checkingService.deposit(checkingId, addOrMinusBalance);
        model.addAttribute("checkingAccount", checkingAccount);
        return "Found_checking_account";
    }
}
