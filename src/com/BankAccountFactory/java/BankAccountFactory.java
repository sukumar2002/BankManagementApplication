package com.BankAccountFactory.java;

import com.AccountType.java.AccountType;
import com.bank.management.model.Account;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class BankAccountFactory {
    public static Account createAccount(int accNo, String holder, double initialBalance, AccountType type) {
        try {
            Constructor<?> constructor = com.bank.management.model.BankAccount.class.getConstructor(int.class, String.class, double.class, AccountType.class);
            return (Account) constructor.newInstance(accNo, holder, initialBalance, type);
        } catch (Exception e) {
            throw new RuntimeException("Error creating account: " + e.getMessage());
        }
    }
}
