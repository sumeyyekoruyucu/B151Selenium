package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://amazon.com");
        //getTitle() methodu: icinde olunan sayfanin(en son gittigi sayfanin) basligini String olarak getirir.
        System.out.println("Amazon Actuel Title : "+ driver.getTitle()); //Amazon.com. Spend less. Smile more.
        System.out.println("Amazon Actuel Url: "+driver.getCurrentUrl()); //https://techproeducation.com/
        String amazonWindowHandle=driver.getWindowHandle();
        System.out.println("Amazon Window Handle Degeri:"+ amazonWindowHandle);//8296ADF7C4FEFBFB45F9F15ECF402EBF

        driver.get("https://techproeducation.com");
        System.out.println("Techproeducation Actuel Title : " + driver.getTitle()); // Techpro Education | Online It Courses & Bootcamps

        //getCurrentUrl() methodu: icinde olunan sayfanin url sini String olarak getirir.
        System.out.println("Techproed Actuel Url: "+driver.getCurrentUrl()); //https://techproeducation.com/

        //getPageSource() methodu: icinde olunan sayfanin kaynak kodlarini String olarak getirir.
        //System.out.println(driver.getPageSource()); //cok uzun old icin bilerek yoruma aldik.

        //getWindowHandle() / getWindowHandles() methodlari:icinde olunan sf ve/veya tablarin  handle degerelerini getirir.
        //gidilen sayfanin handle degerini(hashkod) verir.Bu handle degerini sayfalar arasi gecis icin kulaniriz.
        System.out.println("Techproed Window Handle Degeri: " +driver.getWindowHandle()); //8296ADF7C4FEFBFB45F9F15ECF402EBF
        //bu handle degerini bir Stringe assigne edicez yukarida ettik zaten.

        /*
           METHODLAR;
           getTitle() methodu:       icinde olunan sayfanin(en son gittigi sayfanin) basligini String olarak getirir.
           getCurrentUrl() methodu:  icinde olunan sayfanin url sini String olarak getirir.
           getPageSource() methodu:  icinde olunan sayfanin kaynak kodlarini String olarak getirir.
           getWindowHandle() / getWindowHandles() methodlari:  icinde olunan sf ve/veya tablarin  handle degerelerini getirir.
           getWindowHandles() : set olarak verilen leri getirir
         */




    }
}
