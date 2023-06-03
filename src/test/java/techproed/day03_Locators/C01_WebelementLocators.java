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

             /*
               WebElement Get Methodlari
    webElement.click();                        Web elemente click yapar.
    webElement.sendKeys("metin");              Parametre olarak yazilan metni Web elemente gonderir.
    webElement.sendKeys("metin", Keys.Enter);  istedigimiz metni yollayip,sonra ENTER'a basar.
    webElement.submit();                       Web elementi ile islem yaparken Enter tusuna basma gorevi yapar.
    webElement.getText();                      Web element uzerindeki yaziyi getirir.
    webElement.getTagName();                   web elementinin tag ismini getirir.
    webElement.getAttribute("Att.ismi");       Ismi getirilen attribute'un degerini getirir.
    webElement.isEnable();                     Web elementi erisilebilir ise true yoksa false doner.
    webElement.isDisplayed();                  Web elementi gorunur ise true yoksa false doner.
    webElement.isSelected();                   Web element secili ise true yoksa false doner

    NOT; Web element ile ilgili bu methodlarin disinda size,istenen CSS ozelligi,Location,Rect.geometrik ozellikler,
    DOM degeri vb...Bir cok method vardir ama Automation Test icin kullanmiyoruz

     */









    }
}
