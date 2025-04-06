package com.SerializationUtil.java;
import com.bank.management.model.Account;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SerializationUtil {
    private static final String FILE_NAME = "bank_data.ser";

    public static void saveAccounts(Map<Integer, Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.err.println("Error saving accounts: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<Integer, Account> loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof HashMap) {
                return (HashMap<Integer, Account>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous account data found.");
        }
        return new HashMap<>();
    }
}

