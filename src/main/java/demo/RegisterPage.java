package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driverParametro){
        driver = driverParametro;
    }

    private String firstName = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input";
    private String lastName = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input";
    private String address = "//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea";
    private String emailAddress = "//*[@id=\"eid\"]/input";
    private String phone = "//*[@id=\"basicBootstrapForm\"]/div[4]/div/input";
    private String gender = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input";
    private String hobbies = "checkbox2";
    private String skills = "Skills";
    private String selectCountry1 = "//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span";
    private String selectCountry2 = "//*[@id=\"select2-country-results\"]/li[7]";
    private String year = "yearbox";
    private String month = "//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select";
    private String day = "daybox";

    public void preencherNome(String nome){
        driver.findElement(By.xpath(firstName)).sendKeys(nome);
    }
    public void preencherSobrenome(String sobrenome){
        driver.findElement(By.xpath(lastName)).sendKeys(sobrenome);
    }
    public void preencherEndereco(String endereco){
        driver.findElement(By.xpath(address)).sendKeys(endereco);
    }
    public void preencherEmail(String email){
        driver.findElement(By.xpath(emailAddress)).sendKeys(email);
    }
    public void preencherTelefone(String telefone){
        driver.findElement(By.xpath(phone)).sendKeys(telefone);
    }
    public void selecionarSexo(){
        driver.findElement(By.xpath(gender)).click();
    }
    public void selecionarHobbies(){
        driver.findElement(By.id(hobbies)).click();
    }
    public void selecionarSkills(String skill){
        Select selectSkills = new Select(driver.findElement(By.id(skills)));
        selectSkills.selectByVisibleText(skill);
    }
    public void selecionarPais(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", ""); //scroll automático
        driver.findElement(By.xpath(selectCountry1)).click();
        driver.findElement(By.xpath(selectCountry2)).click();
    }
    public void selecionarAno(String ano){
        Select selectYear = new Select(driver.findElement(By.id(year)));
        selectYear.selectByVisibleText(ano);
    }
    public void selecionarMes(String mes){
        Select selectMonth = new Select(driver.findElement(By.xpath(month)));
        selectMonth.selectByVisibleText(mes);
    }
    public void selecionarDia(String dia){
        Select selectDay = new Select(driver.findElement(By.id(day)));
        selectDay.selectByVisibleText(dia);
    }

}
