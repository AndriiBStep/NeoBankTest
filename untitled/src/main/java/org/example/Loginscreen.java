package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Loginscreen {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://web.neobank.one/");
//  Перевіряє вкладку браузера
        String title = driver.getTitle();
        String expectedText = "NEOBANK для бізнесу";
        if(title.equals(expectedText)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }
//  Вводить номер телефону
        WebElement loginLine = driver.findElement(By.id("login"));
        String enterPhone = "661478861";
        loginLine.sendKeys(enterPhone);
//  Натискає на кнопку "Продовжити"
        WebElement nextButton=driver. findElement(By.id("btnNext"));
        nextButton.sendKeys(Keys.ENTER);
//  Перевіряє чи текст співдає з очікуваним вводночас чи кнопка некст перекинула юзера на наступний екран
        String expectedTxt = "Відкриття бізнес-рахунку можливе тільки через додаток NEOBANK для бізнесу";
        WebElement verification = driver.findElement(By.cssSelector("#formAuthQr > div.auth-form-title"));
        if(verification.getText().equals(expectedTxt)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }
//  Закриває вкладку
        driver.quit();
    }
}
