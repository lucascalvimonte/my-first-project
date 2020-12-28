package com.pom.test;

import com.pom.pages.HomePage;
import com.pom.pages.RegisterPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPrueba {

    WebDriver driver;
    String url = "http://demo.guru99.com/test/newtours/";
    String path="";
    String resEsperado = "";
    String resActual = "";


    @BeforeTest
    public void upTest(){
        path = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void primeraPrueba(){
        HomePage homPag = new HomePage(driver);
        RegisterPage regPag = new RegisterPage(driver);


        try {
            resEsperado = "Welcome: Mercury Tours";
            resActual = homPag.getTitle();
            Assert.assertEquals(resActual,resEsperado);

            homPag.lnlRegister();

            resEsperado = "Register: Mercury Tours";
            resActual = regPag.getTitle();

            Assert.assertEquals(resActual,resEsperado);

            regPag.registerUser();

            resActual=homPag.getTitle();
            resEsperado = "Welcome: Mercury Tours";

            Assert.assertEquals(resActual,resEsperado);


            System.out.println("EL TEST PASO !!!");

        }catch(NoSuchElementException nse){
            System.err.println("NO SE ENCUENTRA EL ELEMENTO BUSCADO: "+nse.getMessage());
        }catch (WebDriverException we){
            System.err.println("WEBDRIVER FALLO !!!"+we.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    @AfterTest
    public void closeTest(){
        driver.quit();
    }

}
