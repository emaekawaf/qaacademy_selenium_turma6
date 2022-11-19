package demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DemoTest {
    WebDriver driver;
    @Before
    public void abrirBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //espera do elemento
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //espera do carregamento da página
    }
    @Test
    public void testDemo (){
        driver.get("https://demo.automationtesting.in/Register.html");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.preencherNome("Elaine");
        registerPage.preencherSobrenome("Maekawa");
        registerPage.preencherEndereco("Rua Agostinho Gomes, 1326 Apto 1074");
        registerPage.preencherEmail("emaekawaf@hotmail.com");
        registerPage.preencherTelefone("1397072607");
        registerPage.selecionarSexo();
        registerPage.selecionarHobbies();
        registerPage.selecionarSkills("Java");
        registerPage.selecionarPais();
        registerPage.selecionarAno("1994");
        registerPage.selecionarMes("March");
        registerPage.selecionarDia("14");
//        driver.findElement(By.xpath("//*[@id=\"firstpassword\"]")).sendKeys("1234");
//        driver.findElement(By.xpath("//*[@id=\"secondpassword\"]")).sendKeys("4321");
//        driver.findElement(By.xpath("//*[@id=\"submitbtn\"]")).click();
    }

//    @After
//    public void fecharBrowser(){
//        driver.quit();
//    }

    @Test
    public void alertOK(){
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
        Alert alert = driver.switchTo().alert();
        String textoAlert = alert.getText();
        Assert.assertEquals("Texto alert inválido", "I am an alert box!", textoAlert);
        alert.accept();
    }

    @Test
    public void alertCancel(){
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
        Alert alert = driver.switchTo().alert();
        String textoAlert = alert.getText();
        Assert.assertEquals("Texto alert inválido", "Press a Button !", textoAlert);
        alert.dismiss();
    }

    @Test
    public void alertText(){
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
        Alert alert = driver.switchTo().alert();
        String textoAlert = alert.getText();
        Assert.assertEquals("Texto alert inválido", "Please enter your name", textoAlert);
        alert.sendKeys("Elaine Maekawa");
        alert.accept();
    }

    @Test
    public void frameTest(){
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Oie!");
        driver.switchTo().defaultContent();
    }

    @Test
    public void windowTest(){
        driver.get("https://demo.automationtesting.in/Windows.html");
        driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
        Object[] janelas = driver.getWindowHandles().toArray();
        driver.switchTo().window(janelas[1].toString());
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.selenium.dev/", url);
    }
}
