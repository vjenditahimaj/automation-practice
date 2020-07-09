import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com",
                "https://www.westelm.com", "https://walmart.com");

        for (String url: urls) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(url);
            //remove spaces from title
            String title =driver.getTitle().replace(" ", "");
            String acurl = driver.getCurrentUrl();

            //Verify that URL of the website contains the title of the website and ignore case in comparison
            if (acurl.contains(title.toLowerCase())){
                System.out.println("PASS");
                System.out.println("Tittle: " + title);
                System.out.println("URL: " + acurl);
            }else {
                System.out.println("FAIL");
                System.out.println("Tittle: " + title);
                System.out.println("URL: " + acurl);
            }
            driver.close();
        }

    }

}
