package BankingAtm.Thymeleaf.Service;

import BankingAtm.Thymeleaf.Model.CheckingAccount;
import BankingAtm.Thymeleaf.Repository.CheckingAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingService {

    @Autowired
    private CheckingAccountRepo checkingAccountRepo;

    public List<CheckingAccount> allCheckingAccounts() {

        return checkingAccountRepo.findAll();
    }

    public List < CheckingAccount>getAccount(Integer id){
        return checkingAccountRepo.findByCustomerId(id);
        //orElseThrow(() -> new ApiRequestException("Account does not exist. Please try again."));
    }

    public CheckingAccount withdrawal(Integer minusBalance,Integer id){

        CheckingAccount checkingAccount=checkingAccountRepo.findById(id).get();
        int balance = checkingAccount.getBalance();
        int newBalance = balance - minusBalance;
        checkingAccount.setAddOrMinusBalance(minusBalance);
        checkingAccount.setBalance(balance);
        checkingAccount.setNewBalance(newBalance);
        checkingAccountRepo.save(checkingAccount);

        return checkingAccountRepo.findById(id).get();
        //orElseThrow(() -> new ApiRequestException("Account does not exist. Please try again."));
    }

    public CheckingAccount deposit(Integer addBalance,Integer id){

        CheckingAccount checkingAccount=checkingAccountRepo.findById(id).get();
        int balance = checkingAccount.getBalance();
        int newBalance = balance + addBalance;
        checkingAccount.setAddOrMinusBalance(addBalance);
        checkingAccount.setBalance(balance);
        checkingAccount.setNewBalance(newBalance);
        checkingAccountRepo.save(checkingAccount);

        return checkingAccountRepo.findById(id).get();
                //orElseThrow(() -> new ApiRequestException("Account does not exist. Please try again."));
    }

    public String closeAccount(Integer id){
        CheckingAccount checkingAccount = checkingAccountRepo.findById(id).get();
        //orElseThrow(()-> new ApiRequestException("Account does not exist. Please try again."));
        checkingAccount.setAddOrMinusBalance(null);
        checkingAccount.setAddOrMinusBalance(null);
        checkingAccount.setNewBalance(null);
        checkingAccount.setBalance(null);
        checkingAccount.setStatus("inactive");
        checkingAccountRepo.save(checkingAccount);

        return "account closed";
    }


}
