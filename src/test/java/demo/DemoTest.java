package demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DemoTest {
    WebDriver driver;
    @Test
    public void testDemo (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Elaine");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Maekawa");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("Rua Agostinho Gomes, 1074 Apto 1074");
        driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("emaekawaf@hotmail.com");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("1397072607");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();
        Select selectSkills = new Select(driver.findElement(By.id("Skills")));
        selectSkills.selectByVisibleText("Java");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-country-results\"]/li[7]")).click();
        Select selectYear = new Select(driver.findElement(By.xpath("//*[@id=\"yearbox\"]")));
        selectYear.selectByVisibleText("1994");
        Select selectMonth = new Select(driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")));
        selectMonth.selectByVisibleText("March");
        Select selectDay = new Select(driver.findElement(By.xpath("//*[@id=\"daybox\"]")));
        selectDay.selectByVisibleText("14");
        driver.findElement(By.xpath("//*[@id=\"firstpassword\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"secondpassword\"]")).sendKeys("4321");
        driver.findElement(By.xpath("//*[@id=\"submitbtn\"]")).click();
    }

//    @After
//    public void fecharBrowser(){
//        driver.quit();
//    }

    @Test
    public void alertOK(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
        Alert alert = driver.switchTo().alert();
        String textoAlert = alert.getText();
        Assert.assertEquals("Texto alert inválido", "I am an alert box!", textoAlert);
        alert.accept();
    }

    @Test
    public void alertCancel(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Oie!");
        driver.switchTo().defaultContent();
    }

    @Test
    public void windowTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.automationtesting.in/Windows.html");
        driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
        Object[] janelas = driver.getWindowHandles().toArray();
        driver.switchTo().window(janelas[1].toString());
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.selenium.dev/", url);
    }
}
