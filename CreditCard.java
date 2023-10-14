package com.telran.org.Homework.HomeworkThree;

public class CreditCard {
    private String number;
    private int pin;
    private int amount;
    private String currency;

    public CreditCard(String number, int pin, int amount, String currency) {
        this.number = number;
        this.pin = pin;
        this.amount = amount;
        this.currency = currency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public void subtractAmount(int amount) {
        if (amount >= 0 && amount <= this.amount) {
            this.amount -= amount;
        } else {
            System.out.println("Ошибка: недопустимая сумма снятия.");
        }
    }

    public void withdraw(int convertedAmount) {
    }

    public void deposit(int convertedAmount) {
    }
}
