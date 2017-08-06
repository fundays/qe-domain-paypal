package com.sandbox.testpages;

import com.sandbox.custom.CommonPageUtils;

public class HomeTestPage extends CommonPageUtils {

    public String login = "#ul-btn";
    public String signUp="#signup-button";
    public String loginIntoYourAccount = "div[class=vertical-centered]>a";
    public String center_block_text="h1.span9.center-block";


    @Override
    // Override to print log for page url
    public void accessPage(String page_URL) {
        System.out.println("Logon Page" + page_URL);
        driver.get(page_URL);
        this.logonWithCredentials();
    }
}


