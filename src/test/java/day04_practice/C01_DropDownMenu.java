package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {

    @Test
    public void Test01() {

      // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

      // dropdown'dan "Books" secenegini secin
        //DropDown 3 adimda handle edilir:
        //1- dropdown locate edilmelidir.
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        //2- select objesi olusturulur.
        Select select = new Select(ddm);

        //3- optionlardan bir tanesi secilir.
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");

      // arama cubuguna "Java" aratın
        WebElement aramaCubugu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaCubugu.sendKeys("Java" + Keys.ENTER);

      // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramaSonucu1 = aramaSonucu.getText();

        Assert.assertTrue(aramaSonucu1.contains("Java"));
    }
}
