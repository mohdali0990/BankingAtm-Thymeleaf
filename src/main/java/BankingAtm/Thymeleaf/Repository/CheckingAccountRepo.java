package BankingAtm.Thymeleaf.Repository;

import BankingAtm.Thymeleaf.Model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheckingAccountRepo extends JpaRepository<CheckingAccount,Integer> {
    public List<CheckingAccount> findByCustomerId(Integer customerId);

}
