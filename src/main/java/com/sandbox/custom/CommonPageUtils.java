package com.sandbox.custom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class CommonPageUtils extends CommonLocators {

    public WebDriver driver = new FirefoxDriver();

    public void launchHome() {
        driver.get(Home_URL);
    }


    public void accessPage(String page_URL) {
        driver.get(signIn_Page);
        new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.id(input_user)));
        this.logonWithCredentials();
        driver.get(page_URL);
    }


    public void logonWithCredentials() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id(input_user)).sendKeys(user);
        driver.findElement(By.id(input_pwd)).sendKeys(password);
        driver.findElement(By.id(btn_Logon)).click();
    }

    public void logonWithCredentials(String user, String password) {
        driver.get(signIn_Page);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id(input_user)).sendKeys(user);
        driver.findElement(By.id(input_pwd)).sendKeys(password);
        driver.findElement(By.id(btn_Logon)).click();
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

    public List<WebElement> getElementsList(String cssLocator) {
        List<WebElement> targets = driver.findElements(By.cssSelector(cssLocator));
        return targets;
    }

    public WebElement getElementFromList(String cssLocator, String expectText) {
        int index = 0;
        List<WebElement> targets = driver.findElements(By.cssSelector(cssLocator));
        for (WebElement target : targets) {
            if (!target.getText().equals(expectText))
                index++;
            break;
        }
        return targets.get(index);
    }
}
