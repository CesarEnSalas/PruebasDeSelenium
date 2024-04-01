package es.salaspierrecesarsalas.test;

import es.salaspierrecesarsalas.helpers.Helpers;
import es.salaspierrecesarsalas.pages.PageCursos;
import es.salaspierrecesarsalas.pages.PageLogin;
import es.salaspierrecesarsalas.pages.PageLogon;
import es.salaspierrecesarsalas.pages.PagePerfil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

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

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void pruebaInicioSesion(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.login("enrique.salas2", "R$SC7sW1");
        PageLogon pageLogon = new PageLogon(driver);
    }

    @Test
    public void pruebaMisCursos(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.login("enrique.salas2", "R$SC7sW1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        buscarMenuSuperior(wait);
        PageCursos pageCursos = new PageCursos(driver);

        helpers.dormir(5);
    }

    private void buscarMenuSuperior(WebDriverWait wait) {
        WebElement menuSuperiror = wait.until(ExpectedConditions.presenceOfElementLocated(
                (By.className("primary-navigation"))));

        WebElement elementosMenu = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                menuSuperiror, By.xpath("/html/body/div[3]/nav/div[1]/nav")));

        WebElement elementoInternoElement = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                elementosMenu, By.xpath("/html/body/div[3]/nav/div[1]/nav/ul/li[3]")));

        WebElement elementoAPresionar = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                elementoInternoElement, By.xpath("/html/body/div[3]/nav/div[1]/nav/ul/li[3]/a")));
        elementoAPresionar.click();
    }

    @Test
    public void pruebaPerfil(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.login("enrique.salas2", "R$SC7sW1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        menuDrop(wait);
        PagePerfil pagePerfil = new PagePerfil(driver);
        pagePerfil.assertPagePerfil();

    }

    private void menuDrop(WebDriverWait wait){
        WebElement dropMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("action-menu-toggle-0")));

        dropMenu.click();

        WebElement dropMenuPerfilElemnt = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                dropMenu, By.xpath("//*[@id='actionmenuaction-1']")));

        dropMenuPerfilElemnt.click();

    }
}
