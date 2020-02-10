package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyToFirstCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.secondCardInfo();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putMoneyCard(cardInfo);
    }

    @Test
    void shouldTransferMoneyToSecondCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.firstCardInfo();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putMoneyCard(cardInfo);
    }

    @Test
    void checkFirstCardBalance() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.secondCardInfo();

        val firstCardBalanceBeforeTransfer = new CardChoosePage();
        val cardNumberBeforeTransfer = new CardChoosePage();
        String firstCardNumberBeforeTransfer = cardNumberBeforeTransfer.getFirstCardNumber();

        int actual = firstCardBalanceBeforeTransfer.getCardBalance(firstCardNumberBeforeTransfer);

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putMoneyCard(cardInfo);

        val firstCardBalanceAfterTransfer = new CardChoosePage();
        val cardNumberAfterTransfer = new CardChoosePage();
        String firstCardNumberAfterTransfer = cardNumberAfterTransfer.getFirstCardNumber();
        int expected = firstCardBalanceAfterTransfer.getCardBalance(firstCardNumberAfterTransfer);
        assertNotEquals(expected, actual);
    }

    @Test
    void checkSecondCardBalance() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.firstCardInfo();

        val secondCardBalanceBeforeTransfer = new CardChoosePage();
        val cardNumberBeforeTransfer = new CardChoosePage();
        String secondCardNumberBeforeTransfer = cardNumberBeforeTransfer.getSecondCardNumber();

        int actual = secondCardBalanceBeforeTransfer.getCardBalance(secondCardNumberBeforeTransfer);

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();

        transferPage.putMoneyCard(cardInfo);

        val secondCardBalanceAfterTransfer = new CardChoosePage();
        val cardNumberAfterTransfer = new CardChoosePage();
        String secondCardNumberAfterTransfer = cardNumberAfterTransfer.getSecondCardNumber();
        int expected = secondCardBalanceAfterTransfer.getCardBalance(secondCardNumberAfterTransfer);
        assertNotEquals(expected, actual);
    }

    @Test
    void shouldTransferMoneyToFirstCardIfAmountDouble() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);


        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.secondCardInfoWhenDouble();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putMoneyCard(cardInfo);
    }

    @Test
    void shouldTransferMoneyToSecondCardIfAmountDouble() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.firstCardInfoWhenDouble();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putMoneyCard(cardInfo);
    }

    @Test
    void checkFirstCardBalanceIfAmountDouble() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.secondCardInfoWhenDouble();

        val firstCardBalanceBeforeTransfer = new CardChoosePage();
        val cardNumberBeforeTransfer = new CardChoosePage();
        String firstCardNumberBeforeTransfer = cardNumberBeforeTransfer.getFirstCardNumber();

        int actual = firstCardBalanceBeforeTransfer.getCardBalance(firstCardNumberBeforeTransfer);

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putMoneyCard(cardInfo);

        val firstCardBalanceAfterTransfer = new CardChoosePage();
        val cardNumberAfterTransfer = new CardChoosePage();
        String firstCardNumberAfterTransfer = cardNumberAfterTransfer.getFirstCardNumber();
        int expected = firstCardBalanceAfterTransfer.getCardBalance(firstCardNumberAfterTransfer);
        assertNotEquals(expected, actual);
    }

    @Test
    void checkSecondCardBalanceIfAmountDouble() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.firstCardInfoWhenDouble();

        val secondCardBalanceBeforeTransfer = new CardChoosePage();
        val cardNumberBeforeTransfer = new CardChoosePage();
        String secondCardNumberBeforeTransfer = cardNumberBeforeTransfer.getSecondCardNumber();

        int actual = secondCardBalanceBeforeTransfer.getCardBalance(secondCardNumberBeforeTransfer);

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();

        transferPage.putMoneyCard(cardInfo);

        val secondCardBalanceAfterTransfer = new CardChoosePage();
        val cardNumberAfterTransfer = new CardChoosePage();
        String secondCardNumberAfterTransfer = cardNumberAfterTransfer.getSecondCardNumber();
        int expected = secondCardBalanceAfterTransfer.getCardBalance(secondCardNumberAfterTransfer);
        assertNotEquals(expected, actual);
    }
}
