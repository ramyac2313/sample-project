package step_defination;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.PageGenerator;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;


    BaseTest(){
        System.setProperty("webdriver.chrome.driver","AllBrowser/chromedriver.exe");
        driver = new ChromeDriver();
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);
        //Maximize Window
        driver.manage().window().maximize();
        //Instantiate the Page Class
        page = new PageGenerator(driver);
    }


}
