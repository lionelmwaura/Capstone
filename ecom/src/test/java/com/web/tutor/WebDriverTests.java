package com.web.tutor;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverTests {

public final Logger log = LoggerFactory.getLogger(WebDriverTests.class);

static WebDriver driver;

static String url="http://localhost:2000/capstone";

    @BeforeAll
public static void openBrowser() {  
    //System.setProperty("webdriver.ie.driver", "C:\\ws\\drivers\\IEDriverServer.exe");
        //driver=new InternetExplorerDriver();   
WebDriverManager.chromedriver().setup();
    //System.setProperty("webdriver.chrome.driver", "C:\\ws\\drivers\\chromedriver.exe");        
driver = new ChromeDriver();  
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);        
    }
    
    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
    }

    
    @Test
  @Disabled("for demonstration purposes")
  public void testyahoo() throws InterruptedException {
    	driver.get("https://www.yahoo.com/");
    	driver.findElement(By.name("p")).sendKeys("Claim Academy");
    	
    	Thread.sleep(3000);
  }
    
@Test
@Disabled("for demonstration purposes")
public void login() throws InterruptedException {
driver.get(url+"/login");
driver.findElement(By.name("email")).sendKeys("lmwaura@ku.edu");
//Thread.sleep(3000);
driver.findElement(By.name("password")).sendKeys("123");
    //Thread.sleep(3000);
    driver.findElement(By.id("send2")).click(); 
    Thread.sleep(3000);
    driver.getPageSource().contains("WELCOME BACK");
    driver.findElement(By.linkText("LOGOUT")).click();
    driver.getPageSource().contains("You have been logged out");
    Thread.sleep(3000);
}

@Test
@DisplayName("Test google search")
@Disabled("for demonstration purposes")
public void google() throws InterruptedException {
driver.get("https://www.google.com/");
driver.findElement(By.name("q")).sendKeys("claim academy");
driver.findElement(By.name("btnK")).click();
Thread.sleep(3000);
}

@Test
@Disabled("for demonstration purposes")
public void testheader() throws InterruptedException {
testlink("home");
Thread.sleep(30);
testlink("about");
Thread.sleep(30);
testlink("contact");
Thread.sleep(30);
testlink("login");
Thread.sleep(30);
testlink("signup");
Thread.sleep(30);
}

public synchronized void testlink(String page) throws InterruptedException {
driver.get(url+"/"+page+"");
driver.findElement(By.linkText("HOME")).click();
driver.findElement(By.linkText("ABOUT")).click();
driver.findElement(By.linkText("CONTACT")).click();
driver.findElement(By.id("lg_id")).click();
driver.findElement(By.id("sn_d")).click();

Thread.sleep(300);

}

@Test
@Disabled("for demonstration purposes")
public void testEmail() {
driver.get(url+"/contact");
driver.findElement(By.id("name")).sendKeys("George Omollo");
driver.findElement(By.id("email")).sendKeys("xxxxx@gmail.com");
driver.findElement(By.id("subject")).sendKeys("WebDriver Test Email");
driver.findElement(By.id("msg")).sendKeys("This is atest for Web Driver");
driver.findElement(By.id("send")).click(); 

}

@AfterAll
public static void closeBrowser() {
driver.quit();
}



}