package com.ecommerce.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "div.cart_list")
    private WebElement cartList;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public boolean isOnCart() {
        return isVisible(cartList);
    }

    public List<WebElement> getCartItems() {
        return findAll(By.cssSelector("div.cart_item div.inventory_item_name"));
    }

    public void clickCheckout() {
        clickWhenVisible(checkoutButton);
    }
}
