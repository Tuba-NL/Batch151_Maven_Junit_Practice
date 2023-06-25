package day06_practice;

import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.v85.browser.model.WindowID;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {


    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'Oppo' yazıp aratın
    // ilk ürüne tıklayın
    // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin
    // ilk sayfaya donun ve Title'ını yazdırın

    @Test
    public void Test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("sayfa1Handle = " + sayfa1Handle);
        bekle(2);

        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("Oppo" + Keys.ENTER);
        bekle(2);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath(" (//*[@class='productName' ])[1]"));
          ilkUrun.click();
        bekle(2);

        //String sayfa2Handle = driver.getWindowHandle();
        //System.out.println("sayfa2Handle : " + sayfa2Handle);
        //driver hala ilk sayfada bunu anlıyoru

        Set<String> pencereler = driver.getWindowHandles();
        System.out.println("pencereler = " + pencereler);

        String sayfa2Handle="";
        for (String w:pencereler) {
            if (!w.equals(sayfa1Handle)) {
                sayfa2Handle = w;
            }

        }

        System.out.println("sayfa2Handle = " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);





        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));
        bekle(2);

        // ilk sayfaya donun ve Title'ını yazdır
        driver.switchTo().window(sayfa1Handle);
        String ilkSayfaTitle = driver.getTitle();
        System.out.println("ilkSayfaTitle = " + ilkSayfaTitle);

    }
}
