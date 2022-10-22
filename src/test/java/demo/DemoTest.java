package demo;

import org.junit.After;
import org.junit.Test;
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
        Select selectSkills = new Select(driver.findElement(By.xpath("//*[@id=\"Skills\"]")));
        selectSkills.selectByVisibleText("Java");
//        Select selectCountry = new Select(driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")));
//        selectCountry.selectByVisibleText("Japan");
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
    @After
    public void fecharBrowser(){
        driver.quit();
    }

}
