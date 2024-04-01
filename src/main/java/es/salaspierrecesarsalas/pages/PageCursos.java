package es.salaspierrecesarsalas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageCursos {

    private WebDriver driver;
    private By titleCurso;

    public PageCursos(WebDriver driver) {
        this.driver = driver;
        titleCurso = By.id("788");
    }

    public void assertLogonPage(){
        Assert.assertTrue(driver.findElement(titleCurso).getText().contains("DM2E Susana Canelo 2023 2024"));
    }
}
