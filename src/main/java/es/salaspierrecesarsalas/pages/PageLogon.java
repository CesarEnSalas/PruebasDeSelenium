package es.salaspierrecesarsalas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLogon {

    private WebDriver driver;
    private By titleText;

    public PageLogon(WebDriver driver){
        this.driver = driver;
        titleText = By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/section/div/div[2]/div/div/a");
    }

    public void assertLogonPage(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Mis cursos"));
    }
}
