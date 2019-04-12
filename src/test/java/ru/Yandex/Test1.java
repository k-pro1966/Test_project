package ru.Yandex;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test1 {
    //private static WebDriverWait wait;
    public InternetExplorerDriver driver;

    @Before
    public void Setup() {
        System.setProperty("webdriver.ie.driver","C:/Users/Konst/IdeaProjects/Test_Project/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void FirstTest() {
        driver.get("https://yandex.ru");
        driver.findElementByLinkText("Маркет").sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Компьютерная техника").sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Ноутбуки").sendKeys(Keys.ENTER);
        //driver.findElementById("glpriceto").sendKeys("30000");
        driver.findElementByLinkText("HP").click();
        driver.findElementByLinkText("Lenovo").click();
        int count = driver.findElementsByClassName("link n-link_theme_blue i-bem link_js_inited").size();
        System.out.print("Элементов");
        System.out.println(count);
        Assert.assertEquals(12,count);

    }

    @After
    public void Close() {
        driver.quit();
    }
}
