package com.base.qa;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    //class variables
    private WebDriver driver;

    public WebDriver launchBrowser(String browserName){

        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equals("ff")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if(browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        else{
            System.out.println("Please enter Chrome/Firefox/Edge as your browser name");
        }
        return driver;
    }

    public void visitSite(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);

    }

    public String doGetPageTitle(){
        return driver.getTitle();
    }

    public void maxWindow(){
        driver.manage().window().maximize();
    }
}
