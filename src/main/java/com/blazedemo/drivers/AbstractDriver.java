package com.blazedemo.drivers;

import org.openqa.selenium.WebDriver;

//app;y factory pattern
public abstract class AbstractDriver {
    public abstract WebDriver createDriver();

}
