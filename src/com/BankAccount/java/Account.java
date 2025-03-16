package com.bank.management.model;

import java.io.Serializable;

import com.AccountType.java.AccountType;

import com.InsufficientFundsException.java.InsufficientFundsException;

public interface Account extends Serializable {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    int getAccountNumber();
    double getBalance();
    void printTransactionHistory();
    AccountType getAccountType();
}

