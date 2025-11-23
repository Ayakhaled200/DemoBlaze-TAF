package com.blazedemo.utils.actions;

import com.blazedemo.utils.WaitManager;
import com.blazedemo.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;

public class AlertActions {
    private final WebDriver driver;
    private final WaitManager waitManager;
    public AlertActions(WebDriver driver)
    {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    /**
     * Accepts the currently displayed alert dialog.
     */
    public void acceptAlert(){
        waitManager.fluentWait().until(
                d -> {
                    try {
                        d.switchTo().alert().accept();
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Error while accepting alert: " + e.getMessage());
                        return false;
                    }
                }
        );
    }

    /**
     * Dismisses the currently displayed alert dialog.
     */
    public void dismissAlert(){
        waitManager.fluentWait().until(
                d -> {
                    try {
                        d.switchTo().alert().dismiss();
                        return true;}
                    catch (Exception e) {
                        LogsManager.error("Error while dismissing alert: " + e.getMessage());
                    return false;
                    }

                }
        );
    }

    /**
     * gets the text of the currently displayed alert dialog.
     * @return The text of the alert dialog.
     */
    public String getAlertText() {
        return waitManager.fluentWait().until(
                d -> {
                    try {
                        String alertText = d.switchTo().alert().getText();
                        return !alertText.isEmpty() ? alertText : null;
                    } catch (Exception e) {
                        LogsManager.error("Error while getting alert text: " + e.getMessage());
                        return null;
                    }
                }
        );
    }
    /**
     * Sends text to the currently displayed alert dialog.
     * @param text The text to send to the alert dialog.
     */
    public void sendTextToAlert(String text) {
        waitManager.fluentWait().until(
                d -> {
                    try {
                        d.switchTo().alert().sendKeys(text);
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Error while sending text to alert: " + e.getMessage());
                        return false;
                    }
                }
        );
    }
}
