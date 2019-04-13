package selenium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Aluno
 */
public class ExercicioSeleniumTest {

    WebDriver d;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\selenium\\chromedriver.exe");
    }

    @Before
    public void before() {
        //garantir que o navegador abre maximizado
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        d = new ChromeDriver(options);
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        d.quit();
    }

    @Test
    public void test01() {
        d.get("https://saucelabs.com/test/guinea-pig");

        //WebElement link = d.findElement(By.id("i am a link"));
        //link.click();
        d.findElement(By.linkText("i am a link")).click();

        WebElement body = d.findElement(By.xpath("/html/body"));
        assertTrue(body.getText().contains("I am some other page content"));
    }
    
    @Test
    public void test02() {
        d.get("https://saucelabs.com/test/guinea-pig");
        
        d.findElement(By.id("comments")).sendKeys("testando");
        
        WebElement button = d.findElement(By.id("submit"));
        //ELEMENTO NÃO VISIVEL -> FAZ SCROLL
        ((JavascriptExecutor) d)
                .executeScript("arguments[0].scrollIntoView(true);", button);
        
        button.click();
        
        WebElement comment = d.findElement(By.id("your_comments"));
        assertEquals("Your comments: testando", comment.getText());
    }    
}
