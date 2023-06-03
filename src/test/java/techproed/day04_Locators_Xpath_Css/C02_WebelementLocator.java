package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
/*
    webElement.isEnable();                     Web elementi erisilebilir ise true yoksa false doner.
    webElement.isDisplayed();                  Web elementi gorunur ise true yoksa false doner.
    webElement.isSelected();                   Web element secilebilir ise true yoksa false doner
 */
public class C02_WebelementLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike" yazıp aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        // sonuc yazısını yazdırın
        List<WebElement > sonucYazisi= driver.findElements(By.className("sg-col-inner"));
        System.out.println(sonucYazisi.get(0).getText());//1-24 von 222 Ergebnissen oder Vorschlägen für "city bike"


        // sonuc sayısını yazdırın
        String [] sonucSayisi=sonucYazisi.get(0).getText().split(" ");
        System.out.println("Sonuc Sayiyi = "+sonucSayisi[2]);//188

        //Xpath ile list kullanmadan tek seferde locate aldık
        WebElement sonucYazisiXpath = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        //Sayfadaki 12. elementi list kullanmadan xpath'in index özelliğini kullanarak locate aldık
        WebElement onikinciElement = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[12]"));
        System.out.println(onikinciElement.getText());


        // ilk ürünün locatini alın
        List<WebElement>urunler=driver.findElements(By.className("s-image"));
        WebElement ilkUrun= urunler.get(0);

        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isDisplayed()); //true

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isEnabled());  //true (tikladiginda erisebilsin)

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isSelected());  //false ...Cunku web element secilme ozelligine sahip degil
        //radio,checkbox gibi secim butonu yok

        // ilk urune tıklayın
        ilkUrun.click();//web elementin uzerine tiklar.

        // sayfayı kapatın
        driver.close();

            /*
            //ARAMA KUTUSUNUN HTML KODLARI
            <input type="text" value="" name="field-keywords" autocomplete="off"
            placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
            tabindex="0" aria-label="Search Amazon" spellcheck="false">
             */



        //Relative Xpath syntax -->  //tagname[@attributeName='atributeValue']
        //                            or: input[@type='text']

        //Aldigimiz xpath unique olmadigi zaman xpath imizi parantez icine alarak ve indexi koseli paranteze alarak index belirtebiliriz.
        // Boylelikle web elementleri liste atip istedigimiz elementi almakla ugrasmayiz.Xpath in degisik kullanma yollari vardir.
        // (//input[@type='text'])[1]

        // En kisa haliyle ;
        // *[@type='text']

        // *  -> tagname ne olursa olsun demektir





    }





    }

