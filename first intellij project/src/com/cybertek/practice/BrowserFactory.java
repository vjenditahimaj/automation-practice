package com.cybertek.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vjendita.himaj\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vjendita.himaj\\Documents\\selenium dependencies\\drivers\\geckoriver.exe");
            return new FirefoxDriver();
        }
        else {
            return null;
        }
    }
}
