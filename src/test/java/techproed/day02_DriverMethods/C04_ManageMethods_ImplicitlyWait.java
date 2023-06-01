package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  Istenen  sayfa acilincaya kadar maximum bekleme suresini belirtir.
//Thread.sleep() java dan gelir. java kodlarini bizim belirttigimiz sure kadar bekler.30 sn beklemesini belirtirsek
// 30 sn bekler ve alt satira gecer.
// --> implicitlyWait()  seleniumdan gelir bekleme problemini %90 cozer.
//implicitlyWait kullanirsan sen 20 sn verdin diyelim 2sn de geldi gorur  2 sn bekler ve alt satira gecer.
// Fakat belirttigimiz max sure boyunca internetten yada sayfadan kaynakli web elementler olusmazsa testimiz fail verir.


//maximize() ve implycitlWait bizim icin cok onemli
public class C04_ManageMethods_ImplicitlyWait {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        //objemizi olusturur olusturmaz hep browseri maximize yapalim.(garanti olsun.)

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //bir defa kullanilir.

        //techproed sayfasina gidelim
        String techproUrl="https://techproeducation.com";
        driver.get(techproUrl);

        //Amazon sf sina gidelim
        String amazonUrl="https://amazon.com";
        driver.get(amazonUrl);

        //techproed sf sina geri donelim
        driver.navigate().back();

        //cok hizli gectigi icin yani web elementi hemen aldigi icin  20 sn beklemedi.Thread.sleep kullanmak istiyorum.
        Thread.sleep(1000);

        //sayfa basliginin techpro icerdigini test edelim
        String actuelTitle= driver.getTitle();
        String expectedWord="techpro";

        if (actuelTitle.contains(expectedWord)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED --> "+driver.getTitle());//Techpro Education | Online It Courses & Bootcamps
            //failed old icin hoca t yi buyuttu Techpro yazdi passed oldu ama ben boyle kalsin istedim.
            //Boyle durumda kodu yazani uyarip failed i duzeltiriz.
        }

        //tekrar amazon sf sina gidelim
        driver.navigate().forward();

        //sayfa basliginin Amazon icerdigini test edelim

        if (driver.getTitle().contains("Amazon")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        //sayfayi kapatalim
        driver.close();



    }
}
