package com.bank.management.model;

import com.AccountType.java.AccountType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import com.InsufficientFundsException.java.InsufficientFundsException;

public class BankAccount implements com.bank.management.model.Account {
    private static final long serialVersionUID = 1L;
    private final int accountNumber;
    private final String accountHolder;
    private double balance;
    private final AccountType accountType;
    private final ReentrantLock lock = new ReentrantLock();
    private final List<String> transactionHistory = new ArrayList<>();

    public BankAccount(int accountNumber, String accountHolder, double initialBalance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.accountType = accountType;
        transactionHistory.add("Account created with balance: ₹" + initialBalance);
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            transactionHistory.add("Deposited ₹" + amount + " | New Balance: ₹" + balance);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        lock.lock();
        try {
            if (amount > balance) {
                throw new InsufficientFundsException("Insufficient Balance in Account " + accountNumber);
            }
            balance -= amount;
            transactionHistory.add("Withdrew ₹" + amount + " | New Balance: ₹" + balance);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void printTransactionHistory() {
        System.out.println("\nTransaction History for Account " + accountNumber + ":");
        transactionHistory.forEach(System.out::println);
    }
}
