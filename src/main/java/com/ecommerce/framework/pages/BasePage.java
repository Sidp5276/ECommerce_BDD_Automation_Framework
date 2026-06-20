package com.ecommerce.framework.pages;

import com.ecommerce.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Reusable BasePage with common helpers.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    protected void clickWhenVisible(org.openqa.selenium.WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(org.openqa.selenium.WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    protected String getText(org.openqa.selenium.WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected org.openqa.selenium.WebElement find(org.openqa.selenium.By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected java.util.List<org.openqa.selenium.WebElement> findAll(org.openqa.selenium.By by) {
        return driver.findElements(by);
    }

    protected boolean isVisible(org.openqa.selenium.WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
