package techproed.day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethods {

    /*
        manage().window() METHODLARI  (driver objemizle kullanicaz)(manage:yonet)

        manage().window().maximize();      Browser'i maximize yapar.      --En onemli method istemese de hep yapalim
        manage().window().minimize();      Browser'i minimize yapar.
        manage().window().fullscreen();    Browser'i full screen yapar.
        manage().window().getPosition();   Browser'in koordinatlarini verir.
        manage().window().getSize();       Browser'i olculerini verir.

        manage().window().setPosition();   Browser'i istenen koordinatlara tasir.
        manage().window().setSize();       Browser'i istenen olculere getrírir.

        manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   Istenen  sayfa acilincaya kadar maximum bekleme suresini belirtir.

        close();   Sadece calisan Browser'i kapatir.
        quit();    Acik olan tum Browser'lari kapatir.
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();



        //Browser'ın konumunu yazdıralım.
        System.out.println("Sayfanin Konumu = "+driver.manage().window().getPosition());

        //Browser'ın boyutlarını yazdıralım.
        System.out.println("Sayfanin Boyutlari"+driver.manage().window().getSize());

        //Browser'ı maximize yapalım.
        driver.manage().window().maximize();
        //sayfamizi olusturur olusturmaz hep browseri maximize yapalim.(garanti olsun.)

        /*
         Bir web sitesine gittiğimizde browser default olarak bir boyutta gelir. Ve açılan browser'daki
         webElementlere browser maximize olmadığı için ulaşamayabiliriz. Dolayısıyla browser'ı açtıktan sonra
         maximize yaparsak driver bütün webelementleri görür ve rahatlikla müdehale edebilir. Bu yüzden
         browser'ı açtıktan sonra ilk olarak driver.manage().window().maximize(); yapmamız bizim webelementlere
         ulaşmada işimizi kolaylaştırır. Böylelikle fail almamış oluruz.
         */

        //Techproeducation sayfasina gidelim.
        driver.get("https://techproeducation.com");

        //Browser'ın konumunu yazdıralım.
        System.out.println("Sayfanin Konumu = "+driver.manage().window().getPosition());

        //Browser'ın boyutlarını yazdıralım.
        System.out.println("Sayfanin Boyutlari"+driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayi minimize yapalim
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //sayfayi fullscreen yapalim.
        driver.manage().window().fullscreen();
        Thread.sleep(3000);


        // setPosition ve setSize methodlari (istedigimiz gibi degisiklik yapmak icin)
        driver.manage().window().setPosition(new Point(50,50)); //istedigimiz konuma getirir.
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(600,600)); //istedigimiz boyutlara getirir.
        Thread.sleep(3000);

        //sayfayi kapatiniz
        driver.close();
    }
}
