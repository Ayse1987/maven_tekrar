package com.techpro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBox {
    //    Create test method and complete the following task. 
//    Go to https://the-internet.herokuapp.com/checkboxes 
//    Locate the elements of checkboxes 
//    Then click on checkbox1 if box is not selected 
//    Then click on checkbox2 if box is not selected
//    Homework: Then verify that checkbox1 is checked.
//    isSelected(); is used to check if a checkbox or radio button is CHECKED
//    if the button is checked, then this returns true, otherwise returns false
//    We can click on checkbox or radio button using click() method

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void test1(){
        WebElement checkbox=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")) ;
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        WebElement checkbox2=driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }




    }
}
