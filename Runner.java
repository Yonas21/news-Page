/**
 * Created by Yon MomBoy on 5/26/2018.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        fetchNews.getNews();
        fetchNews.updateNews();

    }
}
