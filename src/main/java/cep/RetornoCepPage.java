package cep;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetornoCepPage {

    private String cepRetorno = "//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]";

    public void validarCep(WebDriver driver){
        String texto = driver.findElement(By.xpath(cepRetorno)).getText();
        Assert.assertTrue("Endereço diferente",texto.contains("Rua Agostinho Gomes"));
        //Assert.assertEquals("Endereço diferente", "Rua Agostinho Gomes - até 1829/1830", texto);
    }

}
