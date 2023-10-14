package com.telran.org.Homework.HomeworkThree;

public abstract class ATM {
    private String name;
    private double balance;

    public ATM(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public abstract void withdraw(CreditCard card, int amount);

    public abstract void deposit(CreditCard card, int amount);

    public boolean checkPin(CreditCard card, int enteredPin) {
        return card.getPin() == enteredPin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
