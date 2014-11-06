package com.lena;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Lena on 11/2/2014.
 */
public class RozetkaTest {
    private PageManager pageManager;

    @BeforeSuite
    public void init(){
        WebDriver driver = DriverManager.getFirefoxDriver();
        pageManager = new PageManager(driver);
    }

    @AfterSuite
    public void tearDown(){
        pageManager.close();
    }

    @BeforeMethod
    public void beforeMethod(){
        pageManager.openMainPage();
    }

    @Test
    public void priceTest(){
        Assert.assertTrue(pageManager.getPageMain().search("iphone"));
        int priceOne = pageManager.getPageSearchResult().getPrice(1);
        pageManager.getPageSearchResult().getResult(1);
        int priceTwo = pageManager.getPageSelectedItem().getPrice();
        Assert.assertEquals(priceOne, priceTwo);
    }
}
