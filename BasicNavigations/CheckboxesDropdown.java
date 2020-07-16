import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class CheckboxesDropdown {
    public static WebDriver driver;
    @BeforeMethod
    public static void setUp(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test
    public static void Days(){
        driver.get(" http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox ");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("td input"));
        List<WebElement> labels = driver.findElements(By.cssSelector("td label"));

        Random random = new Random();

        int count = 0;

        while(count != 3) {
            int num = random.nextInt(checkboxes.size()-1);
            if(checkboxes.get(num).isEnabled()){
                if(labels.get(num).getText().equals("Friday")) {
                    count++;
                }
                checkboxes.get(num).click();

                System.out.println(labels.get(num).getText());

                checkboxes.get(num).click();
            }
        }
        driver.quit();
    }
    @Test
    public static void TodaysDate(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        Select years = new Select(year);

        WebElement month = driver.findElement(By.id("month"));
        Select months = new Select(month);

        WebElement day = driver.findElement(By.id("day"));
        Select days = new Select(day);

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MMMM/dd");
        LocalDateTime time = LocalDateTime.now();

        StringUtility.verifyEquals(formater.format(time),
                years.getFirstSelectedOption().getText()+ "/" +
                        months.getFirstSelectedOption().getText()+ "/" +
                        days.getFirstSelectedOption().getText());

        driver.quit();
    }
   @Test
   public static void DepartmentsSort(){
       driver.get("https://www.amazon.com/");

   String Alldepartments = driver.findElement(By.className("nav-search-label")).getText();
   Assert.assertEquals(Alldepartments, "All");

       WebElement selectDepartment = driver.findElement(By.xpath("//select"));

       Select deptartments = new Select(selectDepartment);

       List<WebElement> options = deptartments.getOptions();

       for (int i = 1; i < options.size() - 1; i++) {

           String currentDept = options.get(i).getText();
           String nextDept = options.get(i + 1).getText();

           System.out.println("Comparing: " + currentDept + " " + nextDept);

           if (currentDept.compareTo(nextDept) < 0) {
               System.out.println("PASS");
           } else {
               System.out.println("FAIL");
           }
       }
   }

    @AfterMethod
    public static void closeDriver(){
        driver.close();
    }

}
