package com.lena.pages;

import com.lena.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Lena on 11/3/2014.
 */
public class PageSelectedItem extends Page {
    public PageSelectedItem(CustomWebDriver customWebDriver) {
        super(customWebDriver);
    }

    public int getPrice(){
        WebElement priceElement = customWebDriver.findElement(By.xpath("//div[@class='pp-price-box']//span[@itemprop='price']"));
        String priceElementText = priceElement.getText();
        priceElementText = priceElementText.replaceAll("\\s", "");
        return Integer.parseInt(priceElementText);
    }
}
