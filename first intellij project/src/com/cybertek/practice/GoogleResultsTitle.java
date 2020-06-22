package com.cybertek.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultsTitle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );
        String capturedUrl;
        String actualUrl;
        for (int i = 0; i < searchStrs.size() ; i++) {
            driver.get("https://google.com");
            WebElement search = driver.findElement(By.name("q"));
            search.sendKeys(searchStrs.get(i) + Keys.ENTER);

            capturedUrl = driver.findElement(By.xpath("//div[@class='r']/a")).getAttribute("href");
            if (i == 0) {
                Thread.sleep(2000);
               driver.findElement(By.partialLinkText("Java | Oracle")).click();
            }else if (i == 1) {
                Thread.sleep(2000);
                    driver.findElement(By.partialLinkText("Cucumber: BDD Testing & Collaboration Tools for Teams")).click();
            }else if (1 == 2) {
                Thread.sleep(2000);
                driver.findElement(By.partialLinkText("SeleniumHQ Browser Automation")).click();
            }
            actualUrl = driver.getCurrentUrl();
            if (capturedUrl.equals(actualUrl)) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                System.out.println("Actual url: " + actualUrl);
                System.out.println("Captured url: " + capturedUrl);
            }

            //System.out.println(actualUrl.toString());
        }




    }
}
