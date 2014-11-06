package com.lena.pages;

import com.lena.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Lena on 11/2/2014.
 */
public class PageSearchResult extends Page{

    public PageSearchResult(CustomWebDriver customWebDriver) {
        super(customWebDriver);
    }

    public void getResult(int num){
        WebElement element = customWebDriver.findElement(By.xpath("//div[@name='goods_list']/div[@class='gtile-i-wrap']["+num+"]//div[@class='gtile-i-title']/a"));
        //customWebDriver.waitForVisible(element);
        element.click();
    }

    public int getPrice(int num){
        WebElement priceElement = customWebDriver.findElement(By.xpath("//div[@name='goods_list']/div[@class='gtile-i-wrap']["+num+"]//div[@class='g-price-uah']"));
        String priceElementText = priceElement.getText();
        String replace = priceElementText.replaceAll("\\s", "").replace("грн.", "");
        priceElementText = replace.replace(" ", "");
        return Integer.parseInt(priceElementText);
    }
}
