package com.blazedemo.validations;

import com.blazedemo.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Validation extends BaseAssertions{
    private static SoftAssert softAssert = new SoftAssert();
    private static boolean used = false; //flag to check if soft assert has been used
    public Validation(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void assertTrue(boolean condition, String message) {
        used = true; //mark that soft assert has been used
        softAssert.assertTrue(condition, message);
    }

    @Override
    protected void assertFalse(boolean condition, String message) {
        used = true; //mark that soft assert has been used
        softAssert.assertFalse(condition, message);
    }

    @Override
    protected void assertEquals(String actual, String expected, String message) {
        used = true; //mark that soft assert has been used
        softAssert.assertEquals(actual, expected, message);
    }

    public static void assertAll(){
        if(!used) return; //no assertions were made
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            LogsManager.error("Assertion failed:" + e.getMessage());
            throw e;
        }
        finally {
            softAssert = new SoftAssert(); //reset soft assert for next use
        }
    }
}
