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
        transferDashboard.chooseSecondCardForTransfer();
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
        int actual = firstCardBalanceBeforeTransfer.getFirstCardBalance();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putMoneyCard(cardInfo);

        val firstCardBalanceAfterTransfer = new CardChoosePage();
        int expected = firstCardBalanceAfterTransfer.getFirstCardBalance();
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

        int actual = secondCardBalanceBeforeTransfer.getSecondCardBalance();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();

        transferPage.putMoneyCard(cardInfo);

        val secondCardBalanceAfterTransfer = new CardChoosePage();
        int expected = secondCardBalanceAfterTransfer.getSecondCardBalance();
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
        val cardInfo = CardChoosePage.firstCardInfoWhenAmountDouble();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val secondCardBalanceAfterTransfer = new CardChoosePage();
        double expected = secondCardBalanceAfterTransfer.getSecondCardBalanceIfAmountDouble();
        assertEquals(expected % 1, 0);
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
        val cardInfo = CardChoosePage.secondCardInfoWhenAmountDouble();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val firstCardBalanceAfterTransfer = new CardChoosePage();
        double expected = firstCardBalanceAfterTransfer.getSecondCardBalanceIfAmountDouble();
        assertEquals(expected % 1, 0);
    }


    @Test
    void shouldTransferDoubleAmountToSecondCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.firstCardInfoWhenAmountDouble();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
    }
    @Test
    void shouldTransferDoubleAmountToFirstCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardInfo = CardChoosePage.secondCardInfoWhenAmountDouble();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
    }

}
