package org.junit.service;

import org.junit.domain.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AccountServiceTest {
    Account account;
    AccountService accountService;

    @BeforeEach
    void setUp() {
        account = new Account(1, 300.0, "Bob");
        accountService = new AccountService();
    }

    @Test
    void deposit_ThrowsException_WhenAmountIsLowerThanZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> accountService.deposit(account, -1));
    }

    @Test
    void deposit_ThrowsException_WhenAmountIsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> accountService.deposit(account, 0));
    }

    @Test
    void deposit_WhenAmountIsValid() {
        accountService.deposit(account, 1);
        Assertions.assertEquals(301, account.getBalance());
    }

    @Test
    void withdraw_ThrowsException_WhenAmountIsLowerThanZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> accountService.withdraw(account, -1));
    }

    @Test
    void withdraw_ThrowsException_WhenAmountIsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> accountService.withdraw(account, 0));
    }

    @Test
    void withdraw_ThrowsException_WhenBalanceIsInsufficient() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> accountService.withdraw(account, 301));
    }

    @Test
    void withdraw_WhenAmountIsValid() {
        accountService.withdraw(account, 1);
        Assertions.assertEquals(299, account.getBalance());
    }
}