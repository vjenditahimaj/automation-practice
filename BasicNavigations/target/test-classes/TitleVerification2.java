import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com",
                "https://www.westelm.com", "https://walmart.com");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (String url: urls) {
            driver.get(url);
                                            //remove spaces from title
            String title =driver.getTitle().replace(" ", "");
            String acurl = driver.getCurrentUrl();

            //Verify that URL of the website contains the title of the website and ignore case in comparison
            if (acurl.contains(title.toLowerCase())){
                System.out.println("PASS");
            }else {
                System.out.println("FAIL");
            }

        }
        driver.close();
    }

}
