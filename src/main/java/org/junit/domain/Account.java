package org.junit.domain;

public class Account {
    private Integer number;
    private Double balance;
    private String holderName;

    public Account(Integer number, Double balance, String holderName) {
        this.number = number;
        this.balance = balance;
        this.holderName = holderName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

