package com.techpro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@title='Accept All']")).click();

    }
    @Test
    public void test1(){
       WebElement createButton= driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
       createButton.click();
       driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Asli");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Asli");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("123");

        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("1258");
        WebElement femalebutton=driver.findElement(By.xpath("//label[@class='_58mt']"));
        if(!femalebutton.isSelected()) {
            femalebutton.click();
        }





    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
