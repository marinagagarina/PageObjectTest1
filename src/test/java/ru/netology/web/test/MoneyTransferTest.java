package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyFromFirstCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        val cardInfo = DataHelper.secondCardInfo();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
    }

    @Test
    void shouldTransferMoneyFromSecondCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        val cardInfo = DataHelper.firstCardInfo();
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
        val cardInfo = DataHelper.secondCardInfo();
        val firstCardBalanceBeforeTransfer = new CardChoosePage();
        int actual = firstCardBalanceBeforeTransfer.getFirstCardBalanceBeforeTransfer();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val firstCardBalanceAfterTransfer = new CheckBalancePage();
        int expected = firstCardBalanceAfterTransfer.getFirstCardBalanceAfterTransfer();
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
        val cardInfo = DataHelper.firstCardInfo();
        val secondCardBalanceBeforeTransfer = new CardChoosePage();
        int actual = secondCardBalanceBeforeTransfer.getSecondCardBalanceBeforeTransfer();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val secondCardBalanceAfterTransfer = new CheckBalancePage();
        int expected = secondCardBalanceAfterTransfer.getSecondCardBalanceAfterTransfer();
        assertNotEquals(expected, actual);
    }

    @Test
    void shouldTransferDoubleAmountFromSecondCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        val cardInfo = DataHelper.firstCardInfoWhenAmountDouble();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
    }

    @Test
    void shouldTransferDoubleAmountFromFirstCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        val cardInfo = DataHelper.secondCardInfoWhenAmountDouble();
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
        val cardInfo = DataHelper.secondCardInfoWhenAmountDouble();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val firstCardBalanceAfterTransfer = new CheckBalancePage();
        double expected = firstCardBalanceAfterTransfer.getFirstCardBalanceIfAmountDoubleAfterTransfer();
        assertTrue(expected % 1 == 0);
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
        val cardInfo = DataHelper.firstCardInfoWhenAmountDouble();
        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();
        transferPage.putMoneyCard(cardInfo);
        val secondCardBalanceAfterTransfer = new CheckBalancePage();
        double expected = secondCardBalanceAfterTransfer.getSecondCardBalanceIfAmountDoubleAfterTransfer();
        assertTrue(expected % 1 == 0);
    }
}
