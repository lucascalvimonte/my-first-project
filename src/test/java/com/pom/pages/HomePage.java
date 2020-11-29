package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By lnlReg = By.linkText("REGISTER");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void lnlRegister(){
        driver.findElement(lnlReg).click();
    }

}
