package day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {
    @Test
    public void Test01() {
    //http://demo.guru99.com/test/delete_customer.php adresine gidin
     driver.get("http://demo.guru99.com/test/delete_customer.php");

    //customer id kısmına 53920 yazın
        driver.switchTo().frame("gdpr-consent-notice");
        driver.findElement(By.xpath("(//*[.='Tümünü Kabul Et'])[2]")).click();
        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("53920");

    //submit butonuna tıklayın
        driver.findElement(By.xpath("//*[@type='submit']")).click();


    //cıkan alert mesajını yazdırın
        String alertYazisi = driver.switchTo().alert().getText();
        System.out.println("Alert Yazisi = " + alertYazisi);

    //alerti kabul edin
        driver.switchTo().alert().accept();
        bekle(2);

    //cıkan 2. alert mesajını yazdırın
        String  alertYazisi2 = driver.switchTo().alert().getText();
        System.out.println("ALERT YAZISI = " + alertYazisi2);

    //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();
        bekle(2);
    }
}
