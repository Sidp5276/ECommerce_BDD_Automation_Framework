package com.ecommerce.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;

    @FindBy(css = "a.shopping_cart_link")
    private WebElement cartLink;

    public boolean isOnProductsPage() {
        return isVisible(inventoryContainer);
    }

    public void addProductToCart(String productName) {

        String xpath =
                "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";

        WebElement addButton = find(By.xpath(xpath));

        clickWhenVisible(addButton);
    }

    public void goToCart() {
        clickWhenVisible(cartLink);
    }

    public List<WebElement> getAllProducts() {
        return findAll(By.cssSelector("div.inventory_item_name"));
    }
}
