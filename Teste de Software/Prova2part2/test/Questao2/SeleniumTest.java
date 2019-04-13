package Questao2;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    
    WebDriver driver;
    
    public SeleniumTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/media/romero/romero/faculdade/Teste de software/07- Teste de Sistema/chromedriver");
    }

    @Before
    public void before() {
        //garantir que o navegador abre maximizado
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        driver.quit();
    }
    
    @Test
    public void testA(){
        driver.get("https://andreendo.github.io");
        
        driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("neymar");
        driver.findElement(By.xpath("/html/body/form/input[2]")).sendKeys("10");
        driver.findElement(By.xpath("/html/body/form/select")).sendKeys("M");
        driver.findElement(By.xpath("/html/body/form/input[3]")).sendKeys("1000");
        
        driver.findElement(By.xpath("/html/body/form/input[4]")).click(); //click no botao
        
        WebElement nome = driver.findElement(By.xpath("/html/body/form/input[1]"));
        WebElement idade = driver.findElement(By.xpath("/html/body/form/input[2]"));
        WebElement sexo = driver.findElement(By.xpath("/html/body/form/select"));
        WebElement salario = driver.findElement(By.xpath("/html/body/form/input[3]"));
        
        assertEquals("", nome.getText());
        assertEquals("", idade.getText());
        assertFalse(sexo.isSelected());
        assertEquals("", salario.getText().trim());
    }
    
    @Test
    public void testB(){
        driver.get("https://andreendo.github.io");
        
        driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("neymar");
        driver.findElement(By.xpath("/html/body/form/input[2]")).sendKeys("10");
        driver.findElement(By.xpath("/html/body/form/select")).sendKeys("M");
        driver.findElement(By.xpath("/html/body/form/input[3]")).sendKeys("1000");
        
        driver.findElement(By.xpath("/html/body/form/input[5]")).click();
        
        WebElement resultado = driver.findElement(By.xpath("//*[@id=\"divValorImposto\"]"));
        assertEquals("Valor a pagar de imposto: 150", resultado.getText());
    }
    
    @Test
    public void testC(){
        driver.get("https://andreendo.github.io");
        
        driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("neymar");
        driver.findElement(By.xpath("/html/body/form/input[2]")).sendKeys("10");
        driver.findElement(By.xpath("/html/body/form/select")).sendKeys("M");
        driver.findElement(By.xpath("/html/body/form/input[3]")).sendKeys("10000");
        
        driver.findElement(By.xpath("/html/body/form/input[5]")).click();
        
        WebElement resultado = driver.findElement(By.xpath("//*[@id=\"divValorImposto\"]"));
        assertEquals("Valor a pagar de imposto: 2500", resultado.getText());
    }
}
