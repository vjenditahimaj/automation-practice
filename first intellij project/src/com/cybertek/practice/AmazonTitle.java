package com.cybertek.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        // Opening pages
        // get() --> opens pages
        driver.get("https://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));

        search.sendKeys("iphone charger");

        WebElement enterSearch = driver.findElement(By.className("nav-input"));
        enterSearch.click();
        String expectedTitle = driver.getTitle();
        if (expectedTitle.contains("iphone charger")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();


    }
}
