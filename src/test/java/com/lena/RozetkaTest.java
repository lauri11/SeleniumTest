package com.lena;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Lena on 11/2/2014.
 */
public class RozetkaTest {
    private PageManager pageManager;

    @DataProvider
    private Object[][] testData(){
        return new Object[][]{
           new Object[]{"apple"},
           new Object[]{"htc one"},
        };
    }

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

    @Test(dataProvider = "testData")
    public void priceTest(String goodName){
        Assert.assertTrue(pageManager.getPageMain().search(goodName));
        int priceOne = pageManager.getPageSearchResult().getPrice(2);

        pageManager.getPageSearchResult().getResult(2);
        int priceTwo = pageManager.getPageSelectedItem().getPrice();
        Assert.assertEquals(priceOne, priceTwo);
        pageManager.getPageSelectedItem().clickBuyButton();

        int priceThree = pageManager.getPageCart().getPrice();
        Assert.assertEquals(priceTwo,priceThree);
        pageManager.getPageCart().clickOrderButton();

        pageManager.getPageOrder();
        int priceFour = pageManager.getPageOrder().getPrice();
        Assert.assertEquals(priceThree,priceFour);
        pageManager.getPageOrder().editOrder();

        pageManager.getPageCart().clickDeleteButton();
        String actualText = pageManager.getPageMain().cartEmptyText();
        String expectedText = "Корзина пуста";
        Assert.assertEquals(actualText,expectedText);
    }
}
