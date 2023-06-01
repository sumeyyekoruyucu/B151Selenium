package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Submit {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Arama kutusunu locate edip iphone aratalım
        WebElement aramakutusu= driver.findElement(By.name("field-keywords"));//hem sendKeys hemde submitte kullanacagimiz icin webelement e assigne edelim dedik
        aramakutusu.sendKeys("iphone");
        Thread.sleep(2000);
        aramakutusu.submit();//Keys.ENTER

        /*
        driver.navigate().back();
        aramakutusu.sendKeys("samsung");
        Thread.sleep(2000);
        aramakutusu.submit();
        bi daha birsey aratmak istersek arama kutusunun locate ini kontrol edelim kutuyu clear yapalim aratalim.
        yada arama kutusuna assigne etmeden driver i kullanarak yapalim ki bayatlamasin.
         */

        //Sayfayı kapatalım
        driver.close();













    }
}
