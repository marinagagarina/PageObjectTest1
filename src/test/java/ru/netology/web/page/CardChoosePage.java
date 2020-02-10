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

        public String getFirstCardNumber() {
            String firstCardNumber = firstCardString.toString();
            return firstCardNumber;
        }
        public String getSecondCardNumber() {
            String secondCardNumber = secondCardString.toString();
            return secondCardNumber;
        }


        public static String setTansferAmount(String cardNumber) {
            int limit = getCardBalance(cardNumber);
            String transferAmount = Integer.toString(getRandomAmount(limit));
            return transferAmount;
        }

        @Value

        public static class MoneyTransfer {
            private String amount;
            private String cardNumber;
        }
        public static MoneyTransfer firstCardInfo() {
            CardChoosePage cardNumber = new CardChoosePage();
            String firstCardNumber = cardNumber.getFirstCardNumber();
            int limit = getCardBalance(firstCardNumber);
            String amount = Integer.toString(getRandomAmount(limit));
            return new MoneyTransfer(amount, "5559 0000 0000 0001");
        }
        public static MoneyTransfer secondCardInfo() {
            CardChoosePage cardNumber = new CardChoosePage();
            String secondCardNumber = cardNumber.getSecondCardNumber();
            int limit = getCardBalance(secondCardNumber);
            String amount = Integer.toString(getRandomAmount(limit));
            return new MoneyTransfer(amount, "5559 0000 0000 0002");
        }

        public static MoneyTransfer firstCardInfoWhenDouble() {
            CardChoosePage cardNumber = new CardChoosePage();
            String firstCardNumber = cardNumber.getFirstCardNumber();
            double limit = getCardBalance(firstCardNumber);
            String amount = Double.toString(getRandomDoubleAmount(limit));
            return new MoneyTransfer(amount, "5559 0000 0000 0001");
        }
        public static MoneyTransfer secondCardInfoWhenDouble() {
            CardChoosePage cardNumber = new CardChoosePage();
            String secondCardNumber = cardNumber.getSecondCardNumber();
            double limit = getCardBalance(secondCardNumber);
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
    }
