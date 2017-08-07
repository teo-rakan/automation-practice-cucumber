package com.automationpractice.steps;

import com.automationpractice.core.BaseSteps;
import com.automationpractice.pages.*;

import static com.automationpractice.core.BasePage.goToHomePage;

public class OrderSteps extends BaseSteps {

    private String orderReference;

    public OrderSteps() {
        And("^Check the shopping cart and proceed$",
                () -> update(((ShoppingCartSummaryPage)page()).proceedAndGoToAddressPage()));
        And("^Check the address and proceed$",
                () -> update(((AddressPage)page()).proceedAndGoToShippingPage()));
        And("^Check the shipping details and proceed$",
                () -> update(((ShippingPage)page()).proceedAndGoToPaymentMethodPage()));
        And("^Select the bank wire payment and proceed$",
                () -> update(((PaymentMethodPage)page()).selectBankWirePayment()));
        And("^Confirm the order$",
                () -> orderReference = ((ConfirmOrderPage)page()).confirmOrder().getOrderReference());
        Then("^The order should be in the order history$",
                () -> goToHomePage().goToAccountPage().goToOrderHistoryPage().shouldHaveOrderReference(orderReference));

    }
}
