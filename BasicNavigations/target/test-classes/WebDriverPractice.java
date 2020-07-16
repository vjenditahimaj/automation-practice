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
        @Test
    public static void TestCase4() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();

        driver.findElement(By.name("lastname")).sendKeys("q");
        Assert.assertTrue(driver.findElement(By.xpath("(//small[@class='help-block'])[6]")).isDisplayed());
    }
    @Test
    public static void testCase5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])")).click();


        driver.findElement(By.name("firstname")).sendKeys("Vjendita");
        driver.findElement(By.name("lastname")).sendKeys("Himaj");
        driver.findElement(By.name("username")).sendKeys("Vjenditahimaj");
        driver.findElement(By.name("email")).sendKeys("vjendita@cybertekschool.com");
        driver.findElement(By.name("password")).sendKeys("Vjendita123");
        driver.findElement(By.name("phone")).sendKeys("123-456-7855");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("11/05/1995");
        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByValue("DE");
        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox1")).click();

        //Click Sign up
        driver.findElement(By.id("wooden_spoon")).click();

        //Verify that following success message is displayed: “You've successfully completed registration!”
        String success = driver.findElement(By.xpath("//div[@class='alert alert-success']//p")).getText();
        Assert.assertEquals(success,"You've successfully completed registration!");
    }

    @AfterMethod
    public static void closeDriver(){
        driver.close();
    }
}
