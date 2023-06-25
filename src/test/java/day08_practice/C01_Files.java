package day08_practice;


import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {
    @Test
    public void TEST01() {

        //masaustunde bir text dosyasi olusturunuz


        //masaustunde bir text dosyasinin olup olmadigini test ediniz.

        //"C:\Users\gebruiker\Desktop\text.txt"

       // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\gebruiker\\Desktop\\text.txt")));

        //dinamik hale getirelim

        //"C:\Users\gebruiker     \Desktop\text.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\text.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}