package com.lena.pages;

import com.lena.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Lena on 11/7/2014.
 */
public class PageCart extends Page {

    public PageCart(CustomWebDriver customWebDriver) {
        super(customWebDriver);
    }

    private By orderButtonLocator = By.xpath("//form[@id='drop-block']//button");
    private By deleteButtonLocator = By.xpath("//div[@class='cart-other']//a[@name='delete']");

    public int getPrice(){
        WebElement cartPrice = customWebDriver.findElement(By.xpath("//div[@class='cart-total-sum']//span[@name='cost']"));
        String cartPriceText = cartPrice.getText();
        cartPriceText =cartPriceText.replaceAll(" ", "");
        return Integer.parseInt(cartPriceText);
    }

    public void clickOrderButton(){
        WebElement orderButton = customWebDriver.findElement(orderButtonLocator);
        orderButton.click();
    }

    public void clickDeleteButton(){
        WebElement deleteButton = customWebDriver.findElement(deleteButtonLocator);
        deleteButton.click();
    }
}
