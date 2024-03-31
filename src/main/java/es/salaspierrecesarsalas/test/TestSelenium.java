package es.salaspierrecesarsalas.test;

import es.salaspierrecesarsalas.helpers.Helpers;
import es.salaspierrecesarsalas.pages.PageCursos;
import es.salaspierrecesarsalas.pages.PageLogin;
import es.salaspierrecesarsalas.pages.PageLogon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSelenium {

    private WebDriver driver;
    private Helpers helpers = new Helpers();

    @BeforeMethod
    public void setUp(){

        /* El WebDriverManager no funciona con los Test, pero si funciona cuando no son test
         * WebDriverManager.firefoxdriver().setup();
         * WebDriver driver = new FirefoxDriver();
         */

        System.setProperty("webdriver.firefox.driver", "./driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://aulavirtual33.educa.madrid.org/ies.claradelrey.madrid/login/index.php");

    }

    @Test
    public void prueba1(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.login("enrique.salas2", "R$SC7sW1");
        PageLogon pageLogon = new PageLogon(driver);
        driver.close();
    }

    @Test
    public void prueba2(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.login("enrique.salas2", "R$SC7sW1");

        WebElement menuSuperiror = driver.findElement(By.xpath("/html/body/div[3]/nav/div[1]"));
        WebElement elementosMenu = menuSuperiror.findElement(By.xpath("/html/body/div[3]/nav/div[1]/nav"));
        WebElement elementoInternoElement = elementosMenu.findElement(By.xpath("/html/body/div[3]/nav/div[1]/nav/ul/li[3]"));
        WebElement elementoAPresionar = elementoInternoElement.findElement(By.xpath("/html/body/div[3]/nav/div[1]/nav/ul/li[3]/a"));
        elementoAPresionar.click();

        PageCursos pageCursos = new PageCursos(driver);

        helpers.dormir(5);

        driver.close();


    }
}
