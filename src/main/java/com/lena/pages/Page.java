package com.lena.pages;

import com.lena.CustomWebDriver;

/**
 * Created by Lena on 11/2/2014.
 */
public abstract class Page {
    protected CustomWebDriver customWebDriver;

    public Page(CustomWebDriver customWebDriver){
        this.customWebDriver = customWebDriver;
    }
}
