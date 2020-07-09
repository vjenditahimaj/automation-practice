import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class WebDriverPractice {
    public static WebDriver driver;
    @BeforeMethod
    public static void setUp(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test
    public static void TestCase1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String result = driver.findElement(By.xpath("(//div[@class='col-sm-5']//small)[22]")).getText();
        Assert.assertEquals(result,"The date of birth is not valid");
    }

    @Test
    public static void TestCase2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();

        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox3")).isDisplayed());

    }

    @Test
    public static void TestCase3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();

        driver.findElement(By.name("lastname")).sendKeys("q");
        Assert.assertTrue(driver.findElement(By.xpath("(//small[@class='help-block'])[2]")).isDisplayed());
    }

    @AfterMethod
    public static void closeDriver(){
        driver.close();
    }
}
