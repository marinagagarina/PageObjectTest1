package ru.netology.web.data;
import lombok.Value;
import ru.netology.web.page.CardChoosePage;

import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {

        return new VerificationCode("12345");
    }
    @Value
    public static class MoneyTransfer {
        private String amount;
        private String cardNumber;
    }

    public static MoneyTransfer firstCardInfo() {
        CardChoosePage balance = new CardChoosePage();
        int limit = balance.checkFirstCardBalance();
        String amount = Integer.toString(getRandomAmount(limit));
        return new MoneyTransfer(amount, "5559 0000 0000 0001");
    }

    public static MoneyTransfer secondCardInfo() {
        CardChoosePage balance = new CardChoosePage();
        int limit = balance.checkSecondCardBalance();
        String amount = Integer.toString(getRandomAmount(limit));
        return new MoneyTransfer(amount, "5559 0000 0000 0002");
    }
    public static MoneyTransfer firstCardInfoWhenAmountDouble() {
        CardChoosePage balance = new CardChoosePage();
        double limit = balance.checkFirstCardBalance();
        String amount = Double.toString(getRandomDoubleAmount(limit));
        return new MoneyTransfer(amount, "5559 0000 0000 0001");
    }
    public static MoneyTransfer secondCardInfoWhenAmountDouble() {
        CardChoosePage balance = new CardChoosePage();
        double limit = balance.checkFirstCardBalance();
        String amount = Double.toString(getRandomDoubleAmount(limit));
        return new MoneyTransfer(amount, "5559 0000 0000 0002");
    }

    public static int getRandomAmount(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
    public static double getRandomDoubleAmount(double max){
        Random random = new Random();
        return random.nextDouble();
    }
}