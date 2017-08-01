package com.sandbox.testpages;

import com.sandbox.custom.CommonUtilsTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeTestPage extends CommonUtilsTestPage {
    // Here to define locators or Methods for this Page
    public String home_locator_Login = "ul-btn";
    public String login_btn = "";
    public String balance_amt = "span[class^=vx_h2]";
    public String btn_addMoney = "#addFunds";
    public String btn_transferToBack = "a[role=\"button\"]";
    public String section_bankAndCards = "h3[class^=fiModule-title]";
    public String lnkBankOrCard = "span[class*=link-add]";
    public String Completed_Transactions = "div[id^=txnDescription]>span[class^=transactionD]";
    public String net_amt_list = ".netAmount.vx_h4";
    public String positive_amt_list = ".isPositive.vx_h4";

    @Override
    // Override to print log for page url
    public void accessPage(String page_URL) {
        System.out.println("Logon Page" + page_URL);
        driver.get(page_URL);
        this.logonWithCredentials();
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


