package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    // WebElement representing the price displayed in the cart.
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[4]/p")
    private WebElement cartPrice;

    // WebElement representing the checkout button.
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[3]")
    private WebElement checkOutButton;



    // Constructs a new CartPage object.
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Returns the price displayed in the cart.
    public String getCartPrice() {
        return cartPrice.getText();
    }

    // Clicks on the checkout button.
    public void clickCheckoutButton() {
        checkOutButton.click();
    }



}