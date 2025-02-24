package com.jango.jbank.model;

import java.time.LocalDateTime;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String currency;
    private LocalDateTime lastUpdated;
    private double monthlySalary;
    private double monthlyExpense;

    // DEFAULT CONSTRUCTOR
    public Account() {
    }

    // PARAMETERIZED CONSTRUCTOR
    public Account(String accountNumber, String accountHolder, double balance, String currency,
            LocalDateTime lastUpdated, double monthlySalary, double monthlyExpense) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.currency = currency;
        this.lastUpdated = lastUpdated;
        this.monthlySalary = monthlySalary;
        this.monthlyExpense = monthlyExpense;
    }

    // GETTERS AND SETTERS
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlyExpense() {
        return monthlyExpense;
    }

    public void setMonthlyExpense(double monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", monthlySalary=" + monthlySalary +
                ", monthlyExpense=" + monthlyExpense +
                '}';
    }
}
