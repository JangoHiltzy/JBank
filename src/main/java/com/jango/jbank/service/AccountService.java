package com.jango.jbank.service;

import com.jango.jbank.model.Account;
import com.jango.jbank.repository.AccountRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // SIMULATE 1 MONTH PASSING EVERY REAL-LIFE MINUTE
    @Scheduled(fixedRate = 60000) // 60 SECONDS
    public void updateBalances() {
        List<Account> accounts = accountRepository.getAccounts();

        for (Account account : accounts) {
            double newBalance = account.getBalance() + account.getMonthlySalary() - account.getMonthlyExpense();
            account.setBalance(newBalance);
            account.setLastUpdated(LocalDateTime.now());
            accountRepository.updateAccount(account);
        }
        System.out.println("Balances updated!");
    }
}
