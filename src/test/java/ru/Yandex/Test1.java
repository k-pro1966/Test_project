package ru.Yandex;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 extends WebDriverSetup{


    @Test
    public void FirstTest() {

        driver.get("https://yandex.ru");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByLinkText("Маркет")));
        driver.findElementByLinkText("Маркет").sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Компьютерная техника").sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Ноутбуки").sendKeys(Keys.ENTER);
        driver.findElementById("glpriceto").sendKeys("30000");
        driver.findElementByLinkText("HP").click();
        driver.findElementByLinkText("Lenovo").click();

        int count = driver.findElementsByClassName("link n-link_theme_blue i-bem link_js_inited").size();
        System.out.print("Элементов");
        System.out.println(count);
        Assert.assertEquals(12,count);

    }

    @Test
    public void SecondTest() {

        driver.get("https://yandex.ru");
        WebDriverWait wait1 = new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.visibilityOf(driver.findElementByLinkText("Маркет")));
        driver.findElementByLinkText("Маркет").sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Компьютерная техника").sendKeys(Keys.ENTER);
        driver.findElementByLinkText("Планшеты").sendKeys(Keys.ENTER);
        driver.findElementById("glpricefrom").sendKeys("20000");
        driver.findElementById("glpriceto").sendKeys("25000");
        driver.findElementByLinkText("ASUS").click();
        driver.findElementByLinkText("HP").click();

        int count = driver.findElementsByClassName("link n-link_theme_blue i-bem link_js_inited").size();
        System.out.print("Элементов");
        System.out.println(count);
        Assert.assertEquals(12,count);

    }

}
