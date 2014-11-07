package com.lena.pages;

import com.lena.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Lena on 11/2/2014.
 */
public class PageMain extends Page {

    public PageMain(CustomWebDriver customWebDriver) {
        super(customWebDriver);
    }

    By cartEmptyLocator = By.xpath("//div[@class='m-cart']//div[@class='m-cart-empty']");

    public boolean search(String value){
        WebElement searchInput = customWebDriver.findElement(By.xpath("//form[@action='http://rozetka.com.ua/search/']//input[@hint='Поиск']"));
        WebElement searchButton = customWebDriver.findElement(By.xpath("//form[@action='http://rozetka.com.ua/search/']//button"));
        searchInput.sendKeys(value);
        if(!searchInput.getAttribute("value").equals(value)){
            return false;
        }
        searchButton.click();
        return true;
    }

    public String cartEmptyText(){
        WebElement cartEmpty = customWebDriver.findElement(cartEmptyLocator);
        return cartEmpty.getText();
    }
}
