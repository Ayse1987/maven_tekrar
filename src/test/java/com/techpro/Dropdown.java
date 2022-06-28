package com.techpro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown {
    //Go to https://the-internet.herokuapp.com/dropdown
//1.Create method selectByIndexTest and Select and Print Option 1 using index
//2.Create method selectByValueTest Select and Print Option 2 by value
//3.Create method selectByVisibleTextTest Select and Print Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5.Create method printFirstSelectedOptionTest Print first selected option
//6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("https://the-internet.herokuapp.com/dropdown");

    }
    @Test
    public void selectByIndexTest(){
       WebElement dropdown= driver.findElement(By.id("dropdown"));
       Select select=new Select(dropdown);
       select.selectByIndex(1);
        select.selectByVisibleText("Option 2");

    }
    @Test
    public void amazonDropDown(){
        driver.get("https://www.amazon.com/");
        WebElement allDropbox=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(allDropbox);
        List<WebElement>allDepartment=select.getOptions();
        for(WebElement w: allDepartment){
            System.out.println(w.getText());
        }

        select.selectByVisibleText("Computers");
        System.out.println(select.getFirstSelectedOption().getText());
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("apple"+ Keys.ENTER);
        WebElement result=driver.findElement(By.xpath("//*[contains(text(),'results for')]"));
        System.out.println(result.getText());



    }

}
