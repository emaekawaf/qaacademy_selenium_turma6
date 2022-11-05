package google;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleTest {
    WebDriver driver;

    @Before
    public void abrirBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testGoogle(){
        driver.get("https://www.google.com/");
        BuscaGooglePage buscaGooglePage = new BuscaGooglePage();
        buscaGooglePage.preencherCampoBusca(driver);
        buscaGooglePage.clicarResultadoBusca(driver);
        RetornoGooglePage retornoGooglePage = new RetornoGooglePage();
        retornoGooglePage.validarRetornoBusca(driver);
    }
    @After
    public void fecharBrowser(){
        driver.quit();
    }
}
