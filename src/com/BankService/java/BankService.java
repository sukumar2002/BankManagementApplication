package com.BankService.java;


import com.AccountRepository.java.AccountRepository;
import com.AccountType.java.AccountType;
import com.BankAccountFactory.java.BankAccountFactory;

public class BankService {
    private final AccountRepository accountRepository = new AccountRepository();

    public void addAccount(int accNo, String holder, double balance, AccountType type) {
        com.bank.management.model.Account account = BankAccountFactory.createAccount(accNo, holder, balance, type);
        accountRepository.saveAccount(account);
    }
}
