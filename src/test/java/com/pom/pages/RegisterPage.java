package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage {

    WebDriver driver;
    //By firstName = By.name("firstName");
    @FindBy(name = "firstName") WebElement firstName;
    //By lastName = By.name("lastName");
    @FindBy(name = "lastName") WebElement lastName;
    //By phone = By.name("phone");
    @FindBy(name = "phone") WebElement phone;
    //By userName = By.name("userName");
    @FindBy(name = "userName") WebElement userName;
    //By address = By.name("address1");
    @FindBy(name = "address1") WebElement address1;
    //By city = By.name("city");
    @FindBy(name = "city") WebElement city;
    //By postalCode = By.name("postalCode");
    @FindBy(name = "postalCode") WebElement postalCode;
    Select selectCountry;
    @FindBy(name = "country") WebElement country;
    //By email = By.name("email");
    @FindBy(name = "email") WebElement email;
    //By password = By.name("password");
    @FindBy(name = "password") WebElement password;
    //By confirmPassword = By.name("confirmPassword");
    @FindBy(name = "confirmPassword") WebElement confirmPassword;
    //By submit = By.name("submit");
    @FindBy(name = "submit") WebElement submit;

    //By home = By.linkText("Home");
    @FindBy(linkText = "Home") WebElement home;


    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void registerUser(){
        //driver.findElement(firstName).sendKeys("Lucas");
        firstName.sendKeys("Lucas");
        //driver.findElement(lastName).sendKeys("Calvimonte");
        lastName.sendKeys("Calvimonte");
        //driver.findElement(phone).sendKeys("123456");
        phone.sendKeys("123456");
        //driver.findElement(userName).sendKeys("el kiko");
        userName.sendKeys("el kiko");
        //driver.findElement(address).sendKeys("Sol de Mayo 427");
        address1.sendKeys("Sol de Mayo 427");
        //driver.findElement(city).sendKeys("Cordoba");
        city.sendKeys("Cordoba");
        //driver.findElement(postalCode).sendKeys("5011");
        postalCode.sendKeys("5011");
        //country = new Select(driver.findElement(By.name("country")));
        selectCountry = new Select(country);
        selectCountry.selectByVisibleText("ARGENTINA");
        //driver.findElement(email).sendKeys("lucascalvin@hotmail.com");
        email.sendKeys("lucascalvin@hotmail.com");
        //driver.findElement(password).sendKeys("123456");
        password.sendKeys("123456");
        //driver.findElement(confirmPassword).sendKeys("123456");
        confirmPassword.sendKeys("123456");
        //driver.findElement(submit).click();
        submit.click();


        Assert.assertEquals(driver.getPageSource().contains("Thank you for registering."), true);

        //driver.findElement(home).click();
        home.click();


    }
}
