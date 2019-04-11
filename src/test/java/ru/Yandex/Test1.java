package ru.Yandex;

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
    private static WebDriverWait wait;
    @Test
    public void FirstTest() {
        
        System.setProperty("webdriver.ie.driver","C:/Users/Konst/IdeaProjects/IEDriverServer.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://yandex.ru");
        //driver.findElement(new ByIdOrName("market")).sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Маркет").sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Компьютерная техника").sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Ноутбуки").sendKeys(Keys.ENTER);
        driver.findElementById("glpriceto").sendKeys("30000");
        driver.findElementByLinkText("HP").click();
        driver.findElementByLinkText("Lenovo").click();
        driver.findElementByClassName("link n-link_theme_blue i-bem link_js_inited").
        //https://market.yandex.ru/?clid=505&utm_source=face_abovesearch&utm_campaign=face_abovesearch
        driver.quit();
    }
}
