package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div[1]/div[4]/label/span")
    private WebElement phoneVendorOnePlus;

    @FindBy(xpath = "//*[@id=\"23\"]/div[4]")
    private WebElement addToCartOnePlus7Button;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnePlusPhoneVendor() {
        phoneVendorOnePlus.click();
    }

    public void clickAddToCartButtonOnePlus7T() {
        addToCartOnePlus7Button.click();
    }


}