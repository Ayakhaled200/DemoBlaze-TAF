package com.blazedemo.utils.actions;

import com.blazedemo.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class BrowserActions {
    private final WebDriver driver;
    public BrowserActions(WebDriver driver){
        this.driver = driver;
    }
    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

    public String getCurrentUrl(){
        String url = getCurrentUrl();
        LogsManager.info("Current URL is: " + url);
        return url;
    }
    //Navigate to specific URL
    public void navigateTo(String url){
        driver.get(url);
        LogsManager.info("Navigated to URL: " + url);
    }
    //Refresh the current Page
    public void refreshPage()
    {
        driver.navigate().refresh();
    }
    //close current window
    public void closeCurrentWindow(){
        driver.close();
    }
    //open a new window
    public void openNewWindow(){
        driver.switchTo().newWindow(WindowType.WINDOW);
    }



}
