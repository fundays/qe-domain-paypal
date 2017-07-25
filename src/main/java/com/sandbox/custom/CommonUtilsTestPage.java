package com.sandbox.custom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CommonUtilsTestPage extends CommonTestLocators {

    public WebDriver driver = new FirefoxDriver();

    public void launchHome() {
        driver.get(Home_URL);
    }

    public void accessPage(String page_URL) {
        driver.get(page_URL);
        this.logonWithCredentials();
    }


    public void logonWithCredentials() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id(Logon_locator_user)).sendKeys(user);
        driver.findElement(By.id(Logon_locator_pwd)).sendKeys(password);
        driver.findElement(By.id(Logon_locator_Login)).click();
    }

    public Boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void implictlyWait(Integer num) {
        driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
    }


}
