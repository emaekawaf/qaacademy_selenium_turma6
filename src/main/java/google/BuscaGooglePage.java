package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuscaGooglePage {

    private String campoBusca = "q";
    private String resultadoBusca = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul/li[1]";

    public void preencherCampoBusca(WebDriver driver){
        driver.findElement(By.name(campoBusca)).sendKeys("Palmeiras");
    }

    public void clicarResultadoBusca(WebDriver driver){
        driver.findElement(By.xpath(resultadoBusca)).click();
    }

}
