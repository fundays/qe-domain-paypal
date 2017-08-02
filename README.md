# qe-domain-paypal
This includes packages like “custom - provide common locators and utils”， “testpages - specific variables or Methods for pages”， “testplans - define dataproviders and test for pages” and "testng - xml for test inclusion" to make up frameworks. This can be further extended with more validations. 

## com.sandbox.custom 
- Common Test Locators: including id/name/xpath and etc for webElements
- Common Utils Test Page: new Firefox webDriver, define common methods like accessPage(), isElementPresent() as platform utils
- Custom listener: override listeners with customized log printing 
- JavaCSV：read CSV and parse out cell data

## com.sandbox.testpages: define Strings/Methods to support testplans for the page

- HomeTestPage
- PayPalBalanceTestPage
- TransferMoneyTestPage
- UserLogonTestPage

## com.sandbox.testplans：define dataproviders and tests 

- HomePageTestPlan
- PayPalBalanceTestPlan
- TransferMoneyTestPlan
- UserLogonTestPlan

## test.testng

- testng-HomePageTestPlanThreadsWithPriority.xml
- testng-PayPalBalanceTestPlan.xml
- testng-RunGroupWithThreads.xml
- testng-TransferMoneyTestPlan.xml
- testng-UserLogonTestPlan.xml

## test-output/index.html

To review the testng execution result in html page
