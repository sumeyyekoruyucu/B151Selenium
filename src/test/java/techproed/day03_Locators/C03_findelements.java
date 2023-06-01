package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_findelements {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Sayfadaki linklerin sayısını ve linkleri yazdıralım.// sayfaya gidip cntrl f diyince //a yaziyoruz
         /*
        findelement ile bir webelemente ulaşabilirken, birden fazla webelement için findelements() methodunu
        kullanırız.Bu webelementlerin sayısına ulaşmak için yada bu webelementlerin yazısını konsola yazdırabilmek için
        List<Webelement> linklerListesi = driver.findElements(By.locator("locator değeri")) olarak kullanırız.
        Oluşturmuş olduğumuz list'i loop ile konsola yazdırabiliriz
         */
        List<WebElement>linklerListesi=driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayisi = "+linklerListesi.size());

        //linkleri for loop yada lambda ile yazdirabiliriz.

        //1.way(for-each loop)
        for (WebElement w:linklerListesi) {
            if (!w.getText().isEmpty()){    //bos link degilse yazdire
            System.out.println(w.getText());
        }}

        System.out.println("***********************************");

        //2.way(lambda)
        linklerListesi.forEach(t->{if(!t.getText().isEmpty()){
            System.out.println(t.getText());}
        });
        //linklerListesi.stream().filter(webElement -> !webElement.getText().isEmpty()).forEach(webElement -> System.out.println(webElement.getText()));

        System.out.println("*********************************");

        //"Jetzt tolle Angebote durchstöbern" webElementinin yazisini yazdiralim.
        System.out.println(driver.findElement(By.linkText("Jetzt tolle Angebote durchstöbern")).getText());//metni kendimiz yazdik
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());//metni id ile otomasyon aldik

        //bir webElementin uzerindeki yaziyi alm ak icin getText() kullanilir.

        //kapatalim
        driver.close();



    }
}
