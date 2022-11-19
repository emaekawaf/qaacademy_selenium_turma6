package cep;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CepTest {
    WebDriver driver;

    @Before
    public void abrirBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void testCep(){
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        BuscaCepPage buscaCepPage = new BuscaCepPage();
        buscaCepPage.preencherCep(driver);
        buscaCepPage.selecionarTipoLocal(driver);
        buscaCepPage.pesquisarCep(driver);
        RetornoCepPage retornoCepPage = new RetornoCepPage();
        retornoCepPage.validarCep(driver);
    }

    @After
    public void fecharBrowser(){
        driver.quit();
    }
}
