package cep;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CepTest {
    WebDriver driver;
    @Test
    public void testCep (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        driver.findElement(By.id("endereco")).sendKeys("04206000");
        Select opcaoCep = new Select(driver.findElement(By.id("tipoCEP")));
        opcaoCep.selectByVisibleText("Localidade/Logradouro");
        driver.findElement(By.id("btn_pesquisar")).click();
        String texto = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")).getText();
        Assert.assertTrue("Endereço diferente",texto.contains("Rua Agostinho Gomes"));
        //Assert.assertEquals("Endereço diferente", "Rua Agostinho Gomes - até 1829/1830", texto);
    }
    @After
    public void fecharBrowser(){
        driver.quit();
    }
}
