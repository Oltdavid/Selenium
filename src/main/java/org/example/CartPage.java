package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[4]/p")
    private WebElement cartPrice;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[3]")
    private WebElement checkOutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCartPrice() {
        return cartPrice.getText();
    }

    public void clickCheckoutButton() {
        checkOutButton.click();
    }
}