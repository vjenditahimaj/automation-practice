package com.cybertek.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaUrl {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://wikipedia.org");

        WebElement search = driver.findElement(By.id("searchInput"));
        search.sendKeys("selenium webdriver");

        WebElement enterSearch = driver.findElement(By.xpath("//button[@type='submit']"));
        enterSearch.click();

        WebElement seleniumWebdriver = driver.findElement(By.linkText("Selenium (software)"));
        seleniumWebdriver.click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.endsWith("Selenium_(software)")) {
            System.out.println("PASS");
            System.out.println(driver.getCurrentUrl());

        }else{
            System.out.println("FAIL");
            System.out.println(driver.getCurrentUrl());
        }
        driver.close();

        }

    }
