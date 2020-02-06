package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
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

        public int getFirstCardBalanceBeforeTransfer() {
            String str = firstCardString.toString();
            return DataHelper.getCardBalance(str);
        }

        public int getSecondCardBalanceBeforeTransfer() {
            String str = secondCardString.toString();
            return DataHelper.getCardBalance(str);
        }

        public double getFirstCardBalanceIfAmountDoubleBeforeTransfer() {
            String str = firstCardString.toString();
            return DataHelper.getCardBalanceIfAmountDouble(str);
        }
        public double getSecondCardBalanceIfAmountDoubleBeforeTransfer() {
            String str = secondCardString.toString();
            return DataHelper.getCardBalanceIfAmountDouble(str);
        }
    }
