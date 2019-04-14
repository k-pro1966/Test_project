package ru.Yandex;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;


public class Test1 extends WebDriverSetup{

    public static String geNodeText(WebElement element) {
        String text = element.getText();
        for (WebElement child : element.findElements(By.xpath("./*"))) {
            text = text.replaceFirst(child.getText(), "");
        }
        return text;
    }


    @Test
    public void FirstTest() {

        driver.get("https://yandex.ru");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByLinkText("Маркет")));
        driver.findElementByLinkText("Маркет").sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByLinkText("Компьютерная техника")));
        driver.findElementByLinkText("Компьютерная техника").sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByLinkText("Ноутбуки")));
        driver.findElementByLinkText("Ноутбуки").sendKeys(Keys.ENTER);
        //driver.findElementById("glpriceto").sendKeys("30000");
        driver.findElementByLinkText("HP").click();
        driver.findElementByLinkText("Lenovo").click();

        //List<WebElement> elements = driver.findElementsByPartialLinkText("Ноутбук ");
        List<WebElement> elements = driver.findElementsByXPath("/html/body/div[1]/div[5]/div[2]/div[1]/div[1]/div/div[1]/div/div[4]/div[1]/div[1]/a") ;
        // /html/body/div[1]/div[5]/div[2]/div[1]/div[1]/div/div[1]/div[2]/div[4]/div[1]/div[1]/a    // синие ссылки
        // /html/body/div[1]/div[5]/div[2]/div[1]/div[1]/div/div[1]/div[10]/div[4]/div[1]/div[1]/a

        // /html/body/div[1]/div[5]/div[2]/div[1]/div[1]/div/div[1]/div[10]/div[5]/div[1]/div[1]/div/div/a/div //цена
        // /html/body/div[1]/div[5]/div[2]/div[1]/div[1]/div/div[1]/div[4]/div[5]/div[1]/div[1]/div/div/a/div


        System.out.println("Элементов "+elements.size());
        Assert.assertEquals(48,elements.size()); // Ноутбуков то уже больше 12 ! :)
        int count = 0;
        string nText ;

        for (WebElement element: elements) {
            //System.out.println(element.getText());

            // !!!! Ахтунг! Возникает исключение : https://www.seleniumhq.org/exceptions/stale_element_reference.jsp
            System.out.println(geNodeText(element));

            if (element.getAttribute("title").toString().contains("HP")
            || element.getAttribute("title").toString().contains("Lenovo")) count++;
        }
        System.out.println("count= "+count);
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

        int count = driver.findElementsByPartialLinkText("Планшет").size();
        System.out.print("Элементов "+count);
        Assert.assertEquals(12,count);

    }

    private class string {
    }
}
