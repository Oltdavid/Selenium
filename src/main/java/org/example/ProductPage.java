package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    // WebElement representing the OnePlus phone vendor
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div[1]/div[4]/label/span")
    private WebElement phoneVendorOnePlus;

    // WebElement representing the "Add to Cart" button for the OnePlus 7.
    @FindBy(xpath = "//*[@id=\"23\"]/div[4]")
    private WebElement addToCartOnePlus7Button;

    // WebElement representing the "Add to Cart" button for the iPhone 12.
    @FindBy(xpath = "//*[@id=\"1\"]/div[4]")
    private WebElement addToCartIPhone12;

    // WebElement representing the Apple phone vendor.
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div[1]/div[1]/label/span")
    private WebElement phoneVendorApple;

    // Constructs a new ProductPage object.
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Clicks on the OnePlus phone vendor.
    public void clickOnePlusPhoneVendor() {
        phoneVendorOnePlus.click();
    }

    // Clicks on the "Add to Cart" button for the OnePlus 7T.
    public void clickAddToCartButtonOnePlus7T() {
        addToCartOnePlus7Button.click();
    }

    // Clicks on the "Add to Cart" button for the iPhone 12.
    public void clickAddToCartButton_the_iPhone12() {
        addToCartIPhone12.click();
    }

    // Clicks on the Apple phone vendor.
    public void clickAppleVendor() {
        phoneVendorApple.click();
    }
}