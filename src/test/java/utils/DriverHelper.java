package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverHelper {
    //syngleton patter design to centralize my driver
    //example of encapsulation

    private  static WebDriver driver;

    private DriverHelper(){}
    //i make my constructor private because i do not want anyone to create an object
    //and manipulate my driver from this class.They can just call it

    public static WebDriver getDriver(){
        if(driver==null||((RemoteWebDriver)driver).getSessionId()==null){
            String browser="chrome";
            switch (browser){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options1=new ChromeOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options1);
                    break;
            }
            driver.manage().window().maximize();
           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

}
