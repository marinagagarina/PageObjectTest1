package ru.netology.web.test;

import com.codeborne.selenide.SelenideElement;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyFromFirstCad() {
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
    /*@Test
    void checkFirstCardBalance() {
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
        val checkSecondCardBalance = new CheckBalancePage();
        checkSecondCardBalance.secondCardBalanceShouldBeLess();
    }*/
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
        int actual = firstCardBalanceBeforeTransfer.checkFirstCardBalance();
        transferPage.putMoneyCard(cardInfo);
        val firstCardBalanceAfterTransfer = new CheckBalancePage();
        int expected = firstCardBalanceAfterTransfer.checkFirstCardBalanceAfterTransfer();
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

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();

        transferPage.putMoneyCard(cardInfo);
        val checkFirstCardBalance = new CheckBalancePage();
        checkFirstCardBalance.secondCardBalanceShouldBeLess();
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
        val checkFirstCardBalance = new CheckBalancePage();
        checkFirstCardBalance.checkFirstCardBalanceIfAmountDouble();
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
        val checkFirstCardBalance = new CheckBalancePage();
        checkFirstCardBalance.checkSecondCardBalanceIfAmountDouble();
    }
}
