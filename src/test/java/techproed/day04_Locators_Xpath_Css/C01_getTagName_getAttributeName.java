package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getTagName_getAttributeName {

    /*
               WebElement Get Methodlari
    webElement.click();                        Web elemente click yapar.
    webElement.sendKeys("metin");              Parametre olarak yazilan metni Web elemente gonderir.
    webElement.sendKeys("metin", Keys.Enter);  istedigimiz metni yollayip,sonra ENTER'a basar.
    webElement.submit();                       Web elementi ile islem yaparken Enter tusuna basma gorevi yapar.
    webElement.getText();                      Web element uzerindeki yaziyi getirir.
    webElement.getTagName();                   web elementinin tag ismini getirir.
    webElement.getAttribute("Att.ismi");       Ismi getirilen attribute'un degerini getirir.


    NOT; Web element ile ilgili bu methodlarin disinda size,istenen CSS ozelligi,Location,Rect.geometrik ozellikler,
    DOM degeri vb...Bir cok method vardir ama Automation Test icin kullanmiyoruz

     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- amazon.com'a gidip arama kutusunu locate edin
        driver.get("https://amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        // 2- arama kutusunun tagName'inin input oldugunu test edin
        String actuelTagName=aramaKutusu.getTagName();
        String expectedTagName="input";
        if (actuelTagName.equals(expectedTagName)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // 3- arama kutusunun name attribute'nun degerinin field-keywords oldugunu test edin
        String actuelAttributeName=aramaKutusu.getAttribute("name");
        String expectedAttributeName="field-keywords";
        if (actuelAttributeName.equals(expectedAttributeName)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // 4- sayfayı kapatınız
        driver.close();




    }
}
