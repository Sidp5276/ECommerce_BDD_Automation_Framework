package com.ecommerce.framework.stepdefinitions;

import com.ecommerce.framework.pages.CartPage;
import com.ecommerce.framework.pages.LoginPage;
import com.ecommerce.framework.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps {
    private ProductsPage products;
    private CartPage cart;

    private ProductsPage productsPage() {
        if (products == null) products = new ProductsPage();
        return products;
    }

    private CartPage cartPage() {
        if (cart == null) cart = new CartPage();
        return cart;
    }

    @Given("user is on products page")
    public void user_on_products_page() {

        LoginPage login = new LoginPage();

        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        Assert.assertTrue(productsPage().isOnProductsPage());
    }

    @When("user adds {string} to cart")
    public void user_adds_to_cart(String name) {
        productsPage().addProductToCart(name);
    }

    @When("user opens cart")
    public void user_opens_cart() {
        productsPage().goToCart();
    }

    @Then("cart contains {string}")
    public void cart_contains(String name) {
        Assert.assertTrue(cartPage().isOnCart());
        boolean found = cartPage().getCartItems().stream().anyMatch(e -> e.getText().equalsIgnoreCase(name));
        Assert.assertTrue(found, "Expected cart to contain " + name);
    }
}
