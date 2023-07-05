package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    // Ulkeler dosyasındaki "Baskent (İngilizce)" sutununu yazdırınız


    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirNumarasi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirNumarasi);
        // getLastRowNum() son satır numarasını index olarak verir.





        for (int i = 0; i <=sonSatirNumarasi ; i++) {



            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);

            /*
           C01_ReadExcel class'indaki methodu baska classlarda kullanabilmek
           icin static yapmak zorundayiz. Boylece method'u class ismi ile cagirabiliriz.
            NOT:
            - static bir methoda farklı bir class'dan ulasabilmek icin class ismi kullanılır.
           - instance bir methoda farklı bir class'dan ulasabilmek icin obje olusturulur.


             */
        }



/*
        for (int i = 0; i <=sonSatirNumarasi ; i++) {

            String  satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            System.out.println(satirdakiData);


        }


*/




    }
}