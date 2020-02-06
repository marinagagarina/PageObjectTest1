package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckBalancePage {

    private SelenideElement firstCardString = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardString = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement reloadButton = $("[data-test-id='action-reload']");
    private SelenideElement actionDepositeButton = $("[data-test-id='action-deposit']");

    public DashboardPage firstCardBalanceShouldBeLess() {
        int newBalance = 0;
        String str = firstCardString.toString();
        String[] сardList = str.split(" ");
        for (int i = 0; i < сardList.length; i++) {
            newBalance = Integer.parseInt(сardList[6]);
        }
        CardChoosePage balance = new CardChoosePage();
        int lastBalance = balance.checkFirstCardBalance();
        if (newBalance > lastBalance) {
            actionDepositeButton.click();
        }
        return new DashboardPage();
    }

    public int checkFirstCardBalanceAfterTransfer(){
        int newBalance = 0;
        String str = firstCardString.toString();
        String[] firstCardList = str.split(" ");
        for (int i = 0; i < firstCardList.length; i++){
            newBalance = Integer.parseInt(firstCardList[6]);

        }
        return newBalance;
    }

    public void secondCardBalanceShouldBeLess() {
        int newBalance = 0;
        String str = secondCardString.toString();
        String[] сardList = str.split(" ");
        for (int i = 0; i < сardList.length; i++) {
            newBalance = Integer.parseInt(сardList[6]);
        }
        CardChoosePage balance = new CardChoosePage();
        int limitBalance = balance.checkSecondCardBalance();
        if (newBalance < limitBalance) {
            reloadButton.click();
        }
    }
    public void checkFirstCardBalanceIfAmountDouble() {
        double newBalance = 0;
        String str = firstCardString.toString();
        String[] сardList = str.split(" ");
        for (int i = 0; i < сardList.length; i++) {
            newBalance = Double.parseDouble(сardList[6]);
        }
        CardChoosePage balance = new CardChoosePage();
        double limitBalance = balance.checkFirstCardBalance();
        if ((limitBalance - newBalance) % 1 != 0) {
            reloadButton.click();
        }
    }
    public void checkSecondCardBalanceIfAmountDouble() {
        double newBalance = 0;
        String str = secondCardString.toString();
        String[] сardList = str.split(" ");
        for (int i = 0; i < сardList.length; i++) {
            newBalance = Double.parseDouble(сardList[6]);
        }
        CardChoosePage balance = new CardChoosePage();
        double limitBalance = balance.checkSecondCardBalance();
        if ((limitBalance - newBalance) % 1 != 0) {
            reloadButton.click();
        }
    }
}
