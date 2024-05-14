package org.junit.service;

import org.junit.domain.Account;

public class AccountService {
    public AccountService() {
    }

    public void deposit(Account acc, double amount) {
        requireValidAmount(amount);
        acc.deposit(amount);
    }

    public void withdraw(Account acc, double amount) {
        requireValidAmount(amount);
        if (acc.getBalance() >= amount) {
            acc.withdraw(amount);
            return;
        }
        throw new IllegalArgumentException("Insufficient balance for this withdraw amount");

    }

    private void requireValidAmount(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("The amount should be greater than zero");
    }
}
