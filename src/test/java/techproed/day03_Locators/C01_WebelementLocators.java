package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebelementLocators {
    /*
    findElement(By.LocatorTuru("LocateBilgisi)); tanimladigimiz web elementin yerini driver'in bulabilmesi icin.
    locator turu ör;id,xpath,css vb.
    Locate ettigimiz Web elementini kullanabilmek icin bir variable a atama yapariz.

    ör; WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox));
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//sn yetmezse exception verir.ama yeter
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Arama kutusunu locate edelim
        //Arama kutusuna iphone yazdıralım ve aratalım

        /*
        Bir webelementin locate'ini birden fazla kullanacaksaniz bir Webelement'te değişken olarak atayabilirsiniz.
        Webelement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox")); şeklinde kullanabiliriz
        1-Locate işlemi bittikten sonra eğer webelemente bir metin göndereceksek sendKeys() methodu kullanırız
        2-webelemente tıklayacaksak click() methodu kullanırız
        3-webelementin uzerindeki yaziyi almak istiyorsak getText() methodunu kullaniriz.
        4-sendKeys()methodunda web elemente metin gonderdikten sonra Keys.ENTER ile yada
        submit() methodu ile manuel olarak enter yaptigimiz gibi otomasyonda da yapabiliriz.
         */
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sayfayı kapatalım
        driver.close();










    }
}
