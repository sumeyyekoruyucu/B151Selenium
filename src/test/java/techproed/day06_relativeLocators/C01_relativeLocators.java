package techproed.day06_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_relativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazona gidelim
        driver.get("https://amazon.com");

        //city bike aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bikes altındaki elemente tıklayalım
        //Web elementlerin yazisini konsola yazdiralim
        WebElement elektrofahrrader= driver.findElement(By.xpath("(//*[@data-routing='off'])[4]"));
        System.out.println(elektrofahrrader.getText());
        WebElement cruiser = driver.findElement(with(By.tagName("a")).below(elektrofahrrader));
        System.out.println(cruiser.getText());
        WebElement mountainbikes=driver.findElement(with(By.tagName("a")).below(cruiser));
        System.out.println(mountainbikes.getText());

        System.out.println("**********************************");

        //Fahrräder altindaki tum linkleri konsola yazdiralim.
        List<WebElement> linklerListesi= driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=2 and position()<=8]"));
        /*
        xpath kullaniminda bir sayfadaki webelementlere mudahale etmek istedigimizde xpath ile locate aldigimizda birden fazla sonuc verebilir.
        [position()>=2 and position()<=8] bu kullanimla aralik belirterek istedigimiz webelementleri secip mudahale edebiliriz.
         */

        //lambda ile yazdirdik
        linklerListesi.forEach(t-> System.out.println(t.getText()));
        System.out.println("******************************");

        //for-each ile
        for (WebElement w:linklerListesi){
            System.out.println(w.getText());
        }

        //Bu linklerin hepsini tiklayalim ve sayfa basliklarini alalim
        System.out.println("******************************");

        for (int i = 0; i < linklerListesi.size(); i++) {
            linklerListesi= driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=2 and position()<=8]"));
            //bunu tekrar icine koymazsam back yaptigim zaman bayatlamis eleman olarak gorup exception atar.
            System.out.println(linklerListesi.get(i).getText());
            linklerListesi.get(i).click();
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);
        }


       // mountainbikes.click();
    }
}
