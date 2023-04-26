package com.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LambdaSeleniumTestNGSuite {

    private RemoteWebDriver driver;
    private String Status = null;

    @Test
    public void SeleniumAutomation_Assignment_WIN() throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "aashour" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "3Y1GkAw7ugH07t8KXHVMUJmXSoFKmuO8jnvkFtXfuOYEZ2Pdfx" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "86.0");
        caps.setCapability("build", "LambdaSeleniumTestNG With Java");
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);





        driver.get("https://www.lambdatest.com");

        // Set an implicit wait of 10 seconds for all elements on the page
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Create a new WebDriverWait instance with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Wait for all elements in the DOM to be available
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
        WebElement Lambdatest =driver.findElement(By.cssSelector("img[alt='Logo']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Lambdatest);
        WebElement seeAllIntegrationsLink = driver.findElement(By.xpath("//a[text()='See All Integrations']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeAllIntegrationsLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('target','_blank'); arguments[0].click();", seeAllIntegrationsLink);

        // Save the window handles in a List
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());

        // Print the window handles of the opened windows
        System.out.println("Window Handles: " + windowHandles);

        // Switch to the new window if there are more than one window handles
        if (windowHandles.size() > 1) {
            driver.switchTo().window(windowHandles.get(1));

            // Verify whether the URL is the same as the expected URL
            String expectedURL = "https://www.lambdatest.com/integrations";
            String actualURL = driver.getCurrentUrl();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualURL, expectedURL, "URL is not as expected");


        } else {
            throw new AssertionError("Expected to find at least two window handles but found " + windowHandles.size());
        }


    }


    @Test
    public void SeleniumAutomation_Assignment_MAC() throws MalformedURLException {

        String username = System.getenv("LT_USERNAME") == null ? "aashour" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "3Y1GkAw7ugH07t8KXHVMUJmXSoFKmuO8jnvkFtXfuOYEZ2Pdfx" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Sierra");
        caps.setCapability("browserName", "Microsoft Edge");
        caps.setCapability("version", "87.0");
        caps.setCapability("build", "LambdaSeleniumTestNG With Java");
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);





        driver.get("https://www.lambdatest.com");

        // Set an implicit wait of 10 seconds for all elements on the page
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Create a new WebDriverWait instance with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Wait for all elements in the DOM to be available
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
        WebElement Lambdatest =driver.findElement(By.cssSelector("img[alt='Logo']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Lambdatest);
        WebElement seeAllIntegrationsLink = driver.findElement(By.xpath("//a[text()='See All Integrations']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeAllIntegrationsLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('target','_blank'); arguments[0].click();", seeAllIntegrationsLink);

        // Save the window handles in a List
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());

        // Print the window handles of the opened windows
        System.out.println("Window Handles: " + windowHandles);

        // Switch to the new window if there are more than one window handles
        if (windowHandles.size() > 1) {
            driver.switchTo().window(windowHandles.get(1));

            // Verify whether the URL is the same as the expected URL
            String expectedURL = "https://www.lambdatest.com/integrations";
            String actualURL = driver.getCurrentUrl();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualURL, expectedURL, "URL is not as expected");


        } else {
            throw new AssertionError("Expected to find at least two window handles but found " + windowHandles.size());
        }


    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}