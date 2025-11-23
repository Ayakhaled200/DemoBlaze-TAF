package com.blazedemo.pages.components;

import com.blazedemo.drivers.GUIDriver;
import org.openqa.selenium.By;

public class NavigationBarComponent {
    private GUIDriver driver;

    public NavigationBarComponent(GUIDriver driver) {
        this.driver = driver;
    }


    //locators
    private final By homeButton = By.xpath("//a[contains(., 'Home')]");
    private final By contactButton = By.cssSelector("a.nav-link[data-target='#exampleModal']");
    private final By aboutUsButton = By.xpath("a.nav-link[data-target='#videoModal']");
    private final By cartButton = By.id("cartur");
    private final By loginButton = By.id("login2");
    private final By signUpButton = By.id("signin2");
    private final By categoryDropdown = By.id("cat");
    private final By phonseCategory = By.xpath("//a[contains(., 'Phones')]");
    private final By laptopsCategory = By.xpath("//a[contains(., 'Laptops')]");
    private final By monitorsCategory = By.xpath("//a[contains(., 'Monitors')]");
    //validations

}
