package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Application {
    public static WebDriver driver;

    @BeforeEach
    public void setUp(){
        stUpDriver();
    }
    public static void stUpDriver(){
        // Configuracion ChromeDriver usando WebDriverManger
        WebDriverManager.chromedriver().setup();
        //System.setProprety("webdriver.chrome.driver","C:

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //setear el driver de selenium apuntando a chrome
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/elements");
    }

    @Test()
    public void primerTest() throws InterruptedException {
        WebElement boton1 = driver.findElement(By.id("item-0"));
        boton1.click();

        WebElement cajaTexto = driver.findElement(By.id("userName"));
        cajaTexto.click();
        cajaTexto.sendKeys("Hola Mundo");
        Thread.sleep(1000);

        // Realiza un scroll hacia abajo utilizando la clase Actions
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,2000).perform();
        Thread.sleep(2000);

        WebElement boton2 = driver.findElement(By.id("submit"));
        Thread.sleep(2000);
        boton2.click();

        actions.scrollByAmount(0,-2000).perform();

    }
}
