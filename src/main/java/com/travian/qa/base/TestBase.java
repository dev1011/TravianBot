package com.travian.qa.base;

import com.google.gson.Gson;
import com.travian.qa.UserData.UserInputData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Random;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static Actions action;
    public static UserInputData userInputData;


    public TestBase() {

        try {



            StringBuilder userInputfilePath = new StringBuilder();
            userInputfilePath.append(System.getProperty("user.dir"));
            userInputfilePath.append("/src/main/java/com/travian/qa/config/Login.json");

            userInputData = readJson(userInputfilePath.toString());



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Config Properties File not found.. Cannot proceed.. !!!");
        }
    }

    public UserInputData readJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson g = new Gson();
            UserInputData userInputData = g.fromJson(reader, UserInputData.class);

            return userInputData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeMethod
    public void setup(Method method) throws Exception {
        initialization();
    }

    public static void initialization() {
        String appUrl = userInputData.getUserInput().getLogin().getUrl();

        String chromeDrivePath = System.getProperty("user.dir") + "/" + "src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDrivePath);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.get(appUrl);
        action = new Actions(driver);
    }

    public void WaitTillElementLoads(WebDriver driver, WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 40, 3000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));

    }

}
