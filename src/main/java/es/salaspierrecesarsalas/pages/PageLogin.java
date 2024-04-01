package es.salaspierrecesarsalas.pages;

import es.salaspierrecesarsalas.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {

    private WebDriver driver;
    private By cookiesButtom;
    private By userField;
    private By passwordField;
    private By loginButtom;
    private Helpers helpers;

    public PageLogin(WebDriver driver){
        this.driver =  driver;
        cookiesButtom = By.id("emCookieBtnAccept");
        userField = By.id("username");
        passwordField = By.id("password");
        loginButtom = By.id("loginbtn");
        helpers = new Helpers();
    }

    public void login(String user, String pass){
        driver.findElement(cookiesButtom).click();
        helpers.dormir(2);

        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButtom).click();

        helpers.dormir(2);
    }



}
