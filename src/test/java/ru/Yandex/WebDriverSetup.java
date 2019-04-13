package ru.Yandex;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSetup {

    public InternetExplorerDriver driver;

    @Before
    public void Setup() {
        System.setProperty("webdriver.ie.driver","C:/Users/Konst/IdeaProjects/Test_Project/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //wait = new WebDriverWait(driver, 10);
    }

    @After
    public void Close() {
        driver.close();
        driver.quit();
    }

}
