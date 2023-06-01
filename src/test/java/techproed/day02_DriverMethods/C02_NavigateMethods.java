package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {
    /*
           navigate METHODLARI   (driver objemizle kullanicaz)

           navigate().to(String Url);  String olarak girilen Url'e gider.(get() methodu ile ayni)
           navigate().back();          Icinde olunan sayfadan,geldigi onceki sayfaya dondurur.
           navigate().forward();       Back ile donulen bir sayfadan tekrar ileri gider.
           navigate().refresh();       Icinde olunan sayfayi yeniler.
         */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //Techproeducation sayfasina gidelim.
        driver.navigate().to("https://techproeducation.com"); //get() methodu ile ayni mantikta calisir.
        Thread.sleep(3000);//java kodlarini bekletmek icin Thread.sleep kullanabiliriz

        //Sonra Amazon sayfasina gidelim.
        driver.navigate().to("https://amazon.com");
        Thread.sleep(3000);

        //Amazon sayfa basligini yazdiralim.
        System.out.println("Amazon Sayfa Basligi: " +driver.getTitle());
        Thread.sleep(3000);

        //Techproeducation sayfasina geri donelim.
        driver.navigate().back();
        Thread.sleep(3000);

        //Sayfa basligini yazdiralim.
        System.out.println("Techproeducation Sayfa Basligi: " +driver.getTitle());
        Thread.sleep(3000);

        //Amazon sayfasina tekrar gidip url'i yazdiralim.
        driver.navigate().forward();
        System.out.println("Amazon Sayfasi url'i : " +driver.getCurrentUrl());
        Thread.sleep(3000);

        //Amozon sayfasindayken sayfayi yenileyelim.
        driver.navigate().refresh();
        Thread.sleep(3000);

        //sayfayi kapatalim
        driver.close();

        //hizli gecisler olmasin diye Thread.sleep kullaniriz.











    }
}
