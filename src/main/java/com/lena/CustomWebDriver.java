package com.lena;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Lena on 11/2/2014.
 */
public class CustomWebDriver {
    private WebDriver driver;
    private WebDriverWait wait;

    public CustomWebDriver(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitForVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement findElement(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public List<WebElement> findElements(By locator){
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return elements;
    }

    public boolean isElementPresent(By locator){
        List<WebElement> elements = findElements(locator);
        return elements.size()>0;
    }
}
