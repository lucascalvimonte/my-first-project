package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage {

    WebDriver driver;
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By phone = By.name("phone");
    By userName = By.name("userName");
    By address = By.name("address1");
    By city = By.name("city");
    By postalCode = By.name("postalCode");
    By email = By.name("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By submit = By.name("submit");
    Select country;
    By home = By.linkText("Home");


    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void registerUser(){
        driver.findElement(firstName).sendKeys("Lucas");
        driver.findElement(lastName).sendKeys("Calvimonte");
        driver.findElement(phone).sendKeys("123456");
        driver.findElement(userName).sendKeys("el kiko");
        driver.findElement(address).sendKeys("Sol de Mayo 427");
        driver.findElement(city).sendKeys("Cordoba");
        driver.findElement(postalCode).sendKeys("5011");
        country = new Select(driver.findElement(By.name("country")));
        country.selectByVisibleText("ARGENTINA");
        driver.findElement(email).sendKeys("lucascalvin@hotmail.com");
        driver.findElement(password).sendKeys("123456");
        driver.findElement(confirmPassword).sendKeys("123456");
        driver.findElement(submit).click();


        Assert.assertEquals(driver.getPageSource().contains("Thank you for registering."), true);

        driver.findElement(home).click();

    }
}
