package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import ru.netology.web.data.DataHelper;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

    public class CardChoosePage {
        private SelenideElement firstCardTransferButton = $("[data-test-id='action-deposit']");
        private SelenideElement secondCardTransferButton = $("#root > div > ul > li:nth-child(2) > div > button");
        private SelenideElement firstCardString = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
        private SelenideElement secondCardString = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

        public TransferPage chooseFirstCardForTransfer(){
            firstCardTransferButton.click();
            return new TransferPage();
        }
        public TransferPage chooseSecondCardForTransfer(){
            secondCardTransferButton.click();
            return new TransferPage();
        }

        public int getFirstCardBalance() {
            String str = firstCardString.toString();
            int firstCardBalance = getCardBalance(str);
            return firstCardBalance;
        }

        public int getSecondCardBalance() {
            String str = secondCardString.toString();
            int secondCardBalance = getCardBalance(str);
            return secondCardBalance;
        }

        public double getFirstCardBalanceIfAmountDouble() {
            String str = firstCardString.toString();
            return getCardBalanceIfAmountDouble(str);
        }
        public double getSecondCardBalanceIfAmountDouble() {
            String str = secondCardString.toString();
            return getCardBalanceIfAmountDouble(str);
        }

        @Value

        public static class MoneyTransfer {
            private String amount;
            private String cardNumber;
        }
        public static MoneyTransfer firstCardInfo() {
            CardChoosePage balance = new CardChoosePage();
            int limit = balance.getFirstCardBalance();
            String amount = Integer.toString(getRandomAmount(limit));
            return new MoneyTransfer(amount, "5559 0000 0000 0001");
        }


        public static MoneyTransfer secondCardInfo() {
            CardChoosePage balance = new CardChoosePage();
            int limit = balance.getSecondCardBalance();
            String amount = Integer.toString(getRandomAmount(limit));
            return new MoneyTransfer(amount, "5559 0000 0000 0002");
        }

        public static MoneyTransfer firstCardInfoWhenAmountDouble() {
            CardChoosePage balance = new CardChoosePage();
            double limit = balance.getFirstCardBalanceIfAmountDouble();
            String amount = Double.toString(getRandomDoubleAmount(limit));
            return new MoneyTransfer(amount, "5559 0000 0000 0001");
        }
        public static MoneyTransfer secondCardInfoWhenAmountDouble() {
            CardChoosePage balance = new CardChoosePage();
            double limit = balance.getSecondCardBalanceIfAmountDouble();
            String amount = Double.toString(getRandomDoubleAmount(limit));
            return new MoneyTransfer(amount, "5559 0000 0000 0002");
        }

        public static int getRandomAmount(int max) {
            Random random = new Random();
            return random.nextInt(max);
        }
        public static double getRandomDoubleAmount(double max) {
            Random random = new Random();
            return random.nextDouble();
        }

        public static int getCardBalance(String cardNumber) {
            int balance = 0;
            String[] cardList = cardNumber.split(" ");
            balance = Integer.parseInt(cardList[6]);
            return balance;
        }
        public static double getCardBalanceIfAmountDouble(String str) {
            double balance = 0;
            String[] cardList = str.split(" ");
            balance = Double.parseDouble(cardList[6]);
            return balance;
        }
    }
