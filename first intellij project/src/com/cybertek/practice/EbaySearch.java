package com.cybertek.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearch {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://ebay.com");

       driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon");
       WebElement searchBtn = driver.findElement(By.id("gh-btn"));
       searchBtn.click();
       String tab = null;
       String tabXpath = "//span[@class='BOLD' and contains(text(), '"+tab+"')]";
       driver.findElement(By.xpath(tabXpath));

      WebElement result = driver.findElement(By.xpath("srp-controls__count-heading"));
        System.out.println(result.getText());

        driver.findElement(By.partialLinkText("All")).click();
        WebElement allResults = driver.findElement(By.className("srp-controls__count-heading"));
        System.out.println(allResults.getText());
    }
}
