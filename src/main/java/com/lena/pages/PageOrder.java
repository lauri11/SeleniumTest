package com.lena.pages;

import com.lena.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Lena on 11/7/2014.
 */
public class PageOrder extends Page {
    public PageOrder(CustomWebDriver customWebDriver) {
        super(customWebDriver);
    }

    private By orderPriceLocator = By.xpath("//div[contains(text(),'Итого')]/..//div[@class='bill-i-field bill-total-sum']");
    private By editOrderLocator = By.xpath("//aside[@id='purchases_block']//div/a[@name='edit']");

    public int getPrice(){
        WebElement orderPrice = customWebDriver.findElement(orderPriceLocator);
        String orderPriceText = orderPrice.getText();
        orderPriceText = orderPriceText.replace("грн.","");
        orderPriceText = orderPriceText.replace(" ", "");
        return Integer.parseInt(orderPriceText);
    }

    public void editOrder(){
        WebElement editOrder = customWebDriver.findElement(editOrderLocator);
        editOrder.click();
    }
}
