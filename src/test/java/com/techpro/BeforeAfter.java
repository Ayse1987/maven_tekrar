package com.techpro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAfter {
    //    Create a class: BeforeAfterMethods 
//    Then create 3 different test methods using the following names. And Go to google. 
    //    titleTest =>Verify if google title = “Google” 
    //    imageTest => Verify if google image displays or not 
    //    gmailLinkTest => Verify if the Gmail link is displayed or not
//    Close the browser after each test
//    I need 3 different test case so I will use 3 @Test annotation

    WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[.='I agree']")).click();
    }
    @Test
    public void test1(){
      String actualTitle= driver.getTitle() ;
      String expectedTitle="Google";
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    @Test
    public void test2(){
      WebElement logo=  driver.findElement(By.xpath("//*[@id='hplogo']"));
      Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void test3(){
        WebElement gmail= driver.findElement(By.xpath("//*[.='Gmail']"));
        Assert.assertTrue(gmail.isDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
