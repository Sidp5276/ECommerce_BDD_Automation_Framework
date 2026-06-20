package com.ecommerce.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(css = "h2.complete-header")
    private WebElement completeHeader;

    public void enterShipping(String first, String last, String postal) {
        type(firstName, first);
        type(lastName, last);
        type(postalCode, postal);
    }

    public void clickContinue() {
        clickWhenVisible(continueButton);
    }

    public void clickFinish() {
        clickWhenVisible(finishButton);
    }

    public String getCompleteText() {
        return getText(completeHeader);
    }
}
