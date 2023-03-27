package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils { //this is browser util method
    public static void selectBy(WebElement location,String value,String methodName){//switch is usefull here
        Select select=new Select(location);
        switch (methodName){
            case "text":
                select.selectByVisibleText(value);
            break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available,use text value or index");

        }
    }
    public static String getText(WebElement element){  //BrowserUtils.getText(message) it will trim directly
        return  element.getText().trim();
    }

    //another method for Java Script
    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }
    public static void clickWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }
    public static void scrollWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }
  public static void switchById(WebDriver driver){
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesId=driver.getWindowHandles();
        for(String id:allPagesId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
  }
  //in real work this will help you a lot once you test different tabs or windows.
  public static void switchByTitle(WebDriver driver,String title){
        Set<String>allPagesId=driver.getWindowHandles();
        for(String id:allPagesId){//internet-->new Window
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
  }
        public static void getScreenshot(WebDriver driver,String packageName){
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("/src/test/java/"+packageName+"/");
        try {
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()));
        } catch (IOException e) {
            throw new RuntimeException();
        }//finally comes here
    }
    public static void getScreenShotForCucumber(WebDriver driver, Scenario scenario){
        Date currentDate=new Date();
        String screenshotFileName=currentDate.toString().replace(" ","-").replace(":","-");
        if(scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/"+screenshotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
/*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
 */