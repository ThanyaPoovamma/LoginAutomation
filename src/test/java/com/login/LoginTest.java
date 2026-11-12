package com.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void validLoginTest() {

        File file = new File("src/main/resources/login.html");

        driver.get(file.toURI().toString());

        driver.findElement(By.id("username")).sendKeys("admin");

        driver.findElement(By.id("password")).sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();

        String message = driver.findElement(By.id("message")).getText();

        Assert.assertEquals(message, "Login Successful!");

        System.out.println("Valid Login Test Passed!");
    }

    @Test(priority = 2)
    public void invalidLoginTest() {

        driver.get(new File("src/main/resources/login.html")
                .toURI().toString());

        driver.findElement(By.id("username")).sendKeys("test");

        driver.findElement(By.id("password")).sendKeys("1234");

        driver.findElement(By.tagName("button")).click();

        String message = driver.findElement(By.id("message")).getText();

        Assert.assertEquals(message,
                "Invalid Username or Password!");

        System.out.println("Invalid Login Test Passed!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
