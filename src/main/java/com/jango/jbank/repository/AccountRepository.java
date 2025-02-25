package com.jango.jbank.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jango.jbank.model.Account;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class AccountRepository {
    private static final String DATABASE_PATH = "src/main/resources/bankdatabase.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Account> accounts;

    public AccountRepository() {
        loadAccounts();
    }

    // LOAD ACCOUNTS FROM JSON FILE
    private void loadAccounts() {
        try {
            File file = new File(DATABASE_PATH);
            if (file.exists()) {
                accounts = objectMapper.readValue(file, new TypeReference<>() {
                });
            } else {
                accounts = List.of();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading accounts", e);
        }
    }

    // SAVE ACCOUNTS BACK TO JSON
    private void saveAccounts() {
        try {
            objectMapper.writeValue(new File(DATABASE_PATH), accounts);
        } catch (IOException e) {
            throw new RuntimeException("Error saving accounts", e);
        }
    }

    // GET ALL ACCOUNTS
    public List<Account> getAccounts() {
        return accounts;
    }

    // FIND ACCOUNT BY ACCOUNT NUMBER
    public Account findByAccountNumber(String accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    // UPDATE AN ACCOUNT
    public void updateAccount(Account updatedAccount) {
        accounts.replaceAll(
                acc -> acc.getAccountNumber().equals(updatedAccount.getAccountNumber()) ? updatedAccount : acc);
        saveAccounts();
    }
}
