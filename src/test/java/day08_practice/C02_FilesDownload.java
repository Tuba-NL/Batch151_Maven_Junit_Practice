package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {

    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void Test01() {
    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(3);


        File silinecekDosya = new File("C:\\Users\\gebruiker\\Downloads\\some-file.txt");
        silinecekDosya.delete();

    // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        bekle(3);


    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
    //  "C:\Users\gebruiker\Downloads\some-file.txt"

    //   Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\gebruiker\\Downloads\\some-file.txt")));

    //  "C:\Users\gebruiker   \Downloads\some-file.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));








    }
}
