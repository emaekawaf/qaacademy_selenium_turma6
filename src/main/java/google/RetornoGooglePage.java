package google;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetornoGooglePage {

    private String textoRetorno = "//*[@id=\"sports-app\"]/div/div[1]/div/div/div[1]/div/div[2]/div[2]";

    public void validarRetornoBusca(WebDriver driver){
        String texto = driver.findElement(By.xpath(textoRetorno)).getText();
        Assert.assertEquals("Texto inválido", "Sociedade Esportiva Palmeiras", texto);
    }
}
