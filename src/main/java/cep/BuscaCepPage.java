package cep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BuscaCepPage {

    private String campoBusca = "endereco";
    private String selecionarTipo = "tipoCEP";
    private String clicaBusca = "btn_pesquisar";

    public void preencherCep(WebDriver driver){
        driver.findElement(By.id(campoBusca)).sendKeys("04206000");
    }

    public void selecionarTipoLocal(WebDriver driver){
        Select opcaoCep = new Select(driver.findElement(By.id(selecionarTipo)));
        opcaoCep.selectByVisibleText("Localidade/Logradouro");
    }

    public void pesquisarCep(WebDriver driver){
        driver.findElement(By.id(clicaBusca)).click();
    }

}
