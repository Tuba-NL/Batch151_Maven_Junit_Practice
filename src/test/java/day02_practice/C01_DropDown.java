package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {


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
        //  driver.close();

    }

    @Test
    public void Test01() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Books" secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);

           select.selectByVisibleText("Books");//1.option
        // select.selectByValue("search-alias=stripbooks-intl-ship");//2.option
        // select.selectByIndex(5); //3.option
        // ddm.sendKeys("Books");//4.option


        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucElement = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramasonuc = aramaSonucElement.getText();
        Assert.assertTrue(aramasonuc.contains("Java"));

    }
}
