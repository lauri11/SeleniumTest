package com.lena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Lena on 11/2/2014.
 */
public class DriverManager {
    public static WebDriver getFirefoxDriver(){
        return new FirefoxDriver();
    }
}
