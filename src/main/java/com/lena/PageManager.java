package com.lena;


import com.lena.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Lena on 11/2/2014.
 */
public class PageManager {
    private WebDriver driver;
    private WebDriverWait wait;
    private String mainPageAddress;
    private CustomWebDriver customWebDriver;

    public PageManager(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.mainPageAddress = "http://rozetka.com.ua";
        this.customWebDriver = new CustomWebDriver(driver, wait);
    }

    public void openMainPage(){
        driver.get(mainPageAddress);
    }

    public PageMain getPageMain(){
        return new PageMain(customWebDriver);
    }

    public PageSearchResult getPageSearchResult(){
        return new PageSearchResult(customWebDriver);
    }

    public PageSelectedItem getPageSelectedItem(){
        return new PageSelectedItem(customWebDriver);
    }

    public PageCart getPageCart(){
        return new PageCart(customWebDriver);
    }

    public PageOrder getPageOrder(){
        return  new PageOrder(customWebDriver);
    }

    public void close(){
        driver.close();
    }
}
