package com.telran.org.Homework.HomeworkThree;

import java.util.Scanner;

public class ATMAPP {
    public static void main(String[] args) {
        ATM[] atms = {
                new USDATM("ATM1", 1000, 1.2),
                new USDATM("ATM2", 1500, 1.2),
                new USDATM("ATM3", 2000, 1.2),
                new USDATM("ATM4", 3000, 1.2)
        };

        // Создаем карту
        CreditCard card;
        card = new CreditCard("1234-5678-9012-3456", 1234, 250, "EURO");

        ATM selectedATM = null;
        for (ATM atm : atms) {
            if (atm instanceof Converter) {
                selectedATM = atm;
                break;
            }
        }
        if (selectedATM != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите PIN код: ");
            int enteredPin = scanner.nextInt();

            if (selectedATM.checkPin(card, enteredPin)) {
                System.out.println("Авторизация успешна.");

                if (selectedATM instanceof Converter) {
                    Converter converter = (Converter) selectedATM;
                    System.out.print("Введите сумму для снятия в EUR: ");
                    int amountInEUR = scanner.nextInt();
                    double convertedAmount = converter.convert(amountInEUR);
                    selectedATM.withdraw(card, (int) convertedAmount);
                    card.subtractAmount((int) convertedAmount);

                } else {
                    System.out.println("Ошибка авторизации. Неверный PIN код.");
                }
            } else {
                System.out.println("Нет банкомата, поддерживающего конвертацию валюты.");
            }
        }


        System.out.println("Информация о карте:");
        System.out.println("Номер карты: " + card.getNumber());
        System.out.println("Баланс: " + card.getAmount() + " " + card.getCurrency());


    }
}
