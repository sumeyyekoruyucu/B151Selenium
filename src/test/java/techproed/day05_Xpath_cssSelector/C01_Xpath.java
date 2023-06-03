package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.List;

public class C01_Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://amazon.com");

        // arama kutusuna "city bike"  yazıp aratın

        /*
        Arama kutusu html kodlari
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
         placeholder="Suche Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
         aria-label="Suche Amazon" spellcheck="false">
         */
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //WebElement aramaKutusu = driver.findElement(By.xpath("//*[@name='field-keywords']"));
        //WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));//-->//*[@*='text']
        //WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));

        // Hybrid Bikes bölümüne tıklayın //ben bulamadim elektrofahrrader e tikladim
          driver.findElement(By.xpath("(//*[@ class='a-size-base a-color-base'])[7]")).click();
        //driver.findElement(By.xpath("//*[text()='Hybrid Bikes']")).click();// --> //*[.='Hybrid Bikes']

        // sonuc sayısını yazdırın
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String [] sonucSayisi=sonucYazisi.getText().split(" ");
        System.out.println("SonucSayisi = "+sonucSayisi[2]);

        // ilk ürününe tıklayın
        driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[5]")).click();
        //driver.findElement(By.xpath("(//h2)[1]")).click();  //tag kullaninca attribute ve value ya gerek yok

        // Sayfayı kapatınız.
        driver.close();








    }
}
