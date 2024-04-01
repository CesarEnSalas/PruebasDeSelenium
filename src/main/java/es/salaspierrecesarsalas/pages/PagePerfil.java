package es.salaspierrecesarsalas.pages;

import es.salaspierrecesarsalas.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PagePerfil {

    private WebDriver driver;
    private By titleEmail;

    public PagePerfil(WebDriver driver) {
        this.driver = driver;
        titleEmail = By.xpath("//ul/li[contains(@class, 'contentnode')][1]//a[contains(@href, 'mailto')]");
    }

    public void assertPagePerfil(){
        WebElement emailElement = driver.findElement(titleEmail);
        String emailText = emailElement.getText();
        Assert.assertTrue(emailText.contains("enrique.salas2@educa.madrid.org"));
    }
}
