package com.telran.org.Homework.HomeworkThree;

public class USDATM extends ATM implements Converter {
    private double conversionRate;

    public USDATM(String name, double balance, double conversionRate) {
        super(name, balance);
        this.conversionRate = conversionRate;
    }

    @Override
    public void withdraw(CreditCard card, int amount) {
        if (getBalance() >= amount) {
            double convertedAmount = convertToUSD(amount);
            if (card.getAmount() >= convertedAmount) {
                card.withdraw((int) convertedAmount);
                System.out.println("Снято " + amount + " USD с карты " + card.getNumber());

            } else {
                System.out.println("Недостаточно средств на карте для снятия.");
            }
        } else {
            System.out.println("Недостаточно средств в банкомате " + getName());
        }

    }


    @Override
    public void deposit(CreditCard card, int amount) {
        double convertedAmount = convertToUSD(amount);
        card.deposit((int) convertedAmount);
        setBalance(getBalance() + amount);
        System.out.println("Внесено " + amount + " USD на карту " + card.getNumber());
    }

    @Override
    public double convert(int amountInEUR) {
        return amountInEUR * conversionRate;
    }

    private double convertToUSD(int amount) {
        return amount / conversionRate;
    }
}
