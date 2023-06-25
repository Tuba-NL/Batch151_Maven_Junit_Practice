package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrog extends TestBase {

    // https://demoqa.com/droppable adresine gidiniz
    // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
    // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz


    @Test
    public void Test01() {

        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath(" //*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath(" //*[@id='droppable']"));
        actions.dragAndDrop(drag,drop).perform();


        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        String actualYazi = drag.findElement(By.xpath(" (//*[.='Dropped!'])[2]")).getText();
        String expectedYazi = "Dropped!";
        Assert.assertEquals(expectedYazi,actualYazi);

    }
}
