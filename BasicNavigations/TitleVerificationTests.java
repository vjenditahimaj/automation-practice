import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",  "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");

        String expectedUrl = "http://practice.cybertekschool.com";
        for (String url: urls) {
           driver.get(url);
           driver.getTitle();
            String acurl = null;
            acurl = url;
            System.out.println(acurl);
            StringUtility.verifyEquals(url, acurl);
            if (acurl.startsWith(expectedUrl)){
                System.out.println("Expected url is equal to actual url");
            }else {
                System.out.println("Fail");
                System.out.println("Actual Url = " + acurl);
                System.out.println("Expected Url = " + expectedUrl);
            }
        }
        driver.close();
        }
    }

