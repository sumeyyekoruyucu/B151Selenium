package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTest {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        //Java uygulamalarinda system ozelliklerini ayarlamak icin setProperty methodu nu kullaniriz.
        //setProperty methodu ile class imiza driver in fiziki yolunu belirtiriz.
        System.out.println(System.getProperty("chromeDriver"));
        //getProperty ile "Key" degerini girerek "value" ya ulasabilirim.
        WebDriver driver =new ChromeDriver();
        //ChromeDriver turunde yeni bir obje olusturduk.
        driver.get("https://www.techproeducation.com");
        //get()methodu String olarak girilen url ye gidilir.









    }
}
