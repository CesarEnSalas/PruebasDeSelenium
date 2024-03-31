package es.salaspierrecesarsalas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageCursos {

    private WebDriver driver;
    private By titleCurso;

    public PageCursos(WebDriver driver) {
        this.driver = driver;
        titleCurso = By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[7]/div[1]/div/div/a/span[3]");
    }

    public void assertLogonPage(){
        Assert.assertTrue(driver.findElement(titleCurso).getText().contains("DM2E Susana Canelo 2023 2024"));
    }
}
