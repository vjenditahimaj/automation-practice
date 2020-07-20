package com.vytrack.utilities;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");
            System.out.println("browser = " + browser);
            if (browser == "chrome") {
                driver = BrowserFactory.getDriver("chrome");
            }
        }
        return driver;
    }
}
