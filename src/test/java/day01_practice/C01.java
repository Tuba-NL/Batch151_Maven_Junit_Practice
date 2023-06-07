package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://ebay.com sayfasına gidiniz
        driver.get("https://ebay.com");

        // electronics bolumune tıklayınız
        WebElement electronic = driver.findElement(By.xpath("(//*[.='Electronics'])[3]"));
        electronic.click();

        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız

        List<WebElement> images = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

        for (int i = 0; i < images.size(); i++) {
            images = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            images.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }

         /*
        2.Yol
        for (int i = 0; i < 19; i++) {
            List<WebElement> images = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            images.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
        */

    }
}