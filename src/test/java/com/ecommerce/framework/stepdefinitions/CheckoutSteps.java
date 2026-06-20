package com.ecommerce.framework.stepdefinitions;

import com.ecommerce.framework.pages.CartPage;
import com.ecommerce.framework.pages.CheckoutPage;
import com.ecommerce.framework.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutSteps {
    private ProductsPage products;
    private CartPage cart;
    private CheckoutPage checkout;

    private ProductsPage productsPage() {
        if (products == null) products = new ProductsPage();
        return products;
    }

    private CartPage cartPage() {
        if (cart == null) cart = new CartPage();
        return cart;
    }

    private CheckoutPage checkoutPage() {
        if (checkout == null) checkout = new CheckoutPage();
        return checkout;
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        productsPage().goToCart();
        cartPage().clickCheckout();
    }

    @When("user enters shipping details {string} {string} {string}")
    public void user_enters_shipping(String first, String last, String postal) {
        checkoutPage().enterShipping(first, last, postal);
        checkoutPage().clickContinue();
    }

    @When("user finishes checkout")
    public void user_finishes_checkout() {
        checkoutPage().clickFinish();
    }

    @Then("order should be completed")
    public void order_completed() {
        Assert.assertTrue(checkoutPage().getCompleteText().toLowerCase().contains("thank you"));
    }
}
