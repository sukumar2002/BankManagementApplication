package com.AccountRepository.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountRepository {
    private final Map<Integer, com.bank.management.model.Account> accounts = new HashMap<>();

    public void saveAccount(com.bank.management.model.Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account Created Successfully!");
    }

    public Optional<com.bank.management.model.Account> getAccount(int accNo) {
        return Optional.ofNullable(accounts.get(accNo));
    }
}
