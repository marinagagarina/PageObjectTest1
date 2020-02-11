package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.web.page.CardChoosePage.getTansferAmount;
import static ru.netology.web.page.CardChoosePage.getTansferAmountWhenDouble;

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
        val cardNumber = new CardChoosePage();
        String secondCardNumber = cardNumber.getSecondCardNumber();

        String amount = getTansferAmount(secondCardNumber);

        val cardInfo = DataHelper.secondCardInfo();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putTransferAmount(amount);
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
        val cardNumber = new CardChoosePage();
        String firstCardNumber = cardNumber.getFirstCardNumber();

        String amount = getTansferAmount(firstCardNumber);

        val cardInfo = DataHelper.firstCardInfo();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();
        transferPage.putTransferAmount(amount);
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
        val cardNumber = new CardChoosePage();
        String secondCardNumber = cardNumber.getSecondCardNumber();

        String amount = getTansferAmount(secondCardNumber);

        val cardInfo = DataHelper.secondCardInfo();

        val firstCardBalanceBeforeTransfer = new CardChoosePage();
        val cardNumberBeforeTransfer = new CardChoosePage();
        String firstCardNumberBeforeTransfer = cardNumberBeforeTransfer.getFirstCardNumber();

        int expected = (firstCardBalanceBeforeTransfer.getCardBalance(firstCardNumberBeforeTransfer)
                + Integer.parseInt(amount));

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);

        val firstCardBalanceAfterTransfer = new CardChoosePage();
        val cardNumberAfterTransfer = new CardChoosePage();
        String firstCardNumberAfterTransfer = cardNumberAfterTransfer.getFirstCardNumber();
        int actual = firstCardBalanceAfterTransfer.getCardBalance(firstCardNumberAfterTransfer);
        assertEquals(expected, actual);
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
        val cardNumber = new CardChoosePage();
        String firstCardNumber = cardNumber.getFirstCardNumber();

        String amount = getTansferAmount(firstCardNumber);
        val cardInfo = DataHelper.firstCardInfo();

        val secondCardBalanceBeforeTransfer = new CardChoosePage();
        val cardNumberBeforeTransfer = new CardChoosePage();
        String secondCardNumberBeforeTransfer = cardNumberBeforeTransfer.getSecondCardNumber();

        int expected = (secondCardBalanceBeforeTransfer.getCardBalance(secondCardNumberBeforeTransfer)
                + Integer.parseInt(amount));

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();

        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);

        val secondCardBalanceAfterTransfer = new CardChoosePage();
        val cardNumberAfterTransfer = new CardChoosePage();
        String secondCardNumberAfterTransfer = cardNumberAfterTransfer.getSecondCardNumber();
        int actual = secondCardBalanceAfterTransfer.getCardBalance(secondCardNumberAfterTransfer);
        assertEquals(expected, actual);
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
        val cardNumber = new CardChoosePage();
        String secondCardNumber = cardNumber.getSecondCardNumber();

        String amount = getTansferAmountWhenDouble(secondCardNumber);

        val cardInfo = DataHelper.secondCardInfo();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();
        transferPage.putTransferAmount(amount);
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
        val cardNumber = new CardChoosePage();
        String firstCardNumber = cardNumber.getFirstCardNumber();

        String amount = getTansferAmountWhenDouble(firstCardNumber);

        val cardInfo = DataHelper.firstCardInfo();

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();
        transferPage.putTransferAmount(amount);
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
        val cardNumber = new CardChoosePage();
        String secondCardNumber = cardNumber.getSecondCardNumber();

        String amount = getTansferAmountWhenDouble(secondCardNumber);
        val cardInfo = DataHelper.secondCardInfo();

        val firstCardBalanceBeforeTransfer = new CardChoosePage();
        val cardNumberBeforeTransfer = new CardChoosePage();
        String firstCardNumberBeforeTransfer = cardNumberBeforeTransfer.getFirstCardNumber();

        double expected = (firstCardBalanceBeforeTransfer.getCardBalance(firstCardNumberBeforeTransfer)
                + Double.parseDouble(amount));

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseFirstCardForTransfer();

        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);

        val firstCardBalanceAfterTransfer = new CardChoosePage();
        val cardNumberAfterTransfer = new CardChoosePage();
        String firstCardNumberAfterTransfer = cardNumberAfterTransfer.getFirstCardNumber();
        double actual = firstCardBalanceAfterTransfer.getCardBalance(firstCardNumberAfterTransfer);
        assertEquals(expected, actual);
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
        val cardNumber = new CardChoosePage();
        String firstCardNumber = cardNumber.getFirstCardNumber();

        String amount = getTansferAmountWhenDouble(firstCardNumber);
        val cardInfo = DataHelper.firstCardInfo();

        val secondCardBalanceBeforeTransfer = new CardChoosePage();
        val cardNumberBeforeTransfer = new CardChoosePage();
        String secondCardNumberBeforeTransfer = cardNumberBeforeTransfer.getSecondCardNumber();

        double expected = (secondCardBalanceBeforeTransfer.getCardBalance(secondCardNumberBeforeTransfer)
                + Double.parseDouble(amount));

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseSecondCardForTransfer();

        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);

        val secondCardBalanceAfterTransfer = new CardChoosePage();
        val cardNumberAfterTransfer = new CardChoosePage();
        String secondCardNumberAfterTransfer = cardNumberAfterTransfer.getSecondCardNumber();
        double actual = secondCardBalanceAfterTransfer.getCardBalance(secondCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }
}
