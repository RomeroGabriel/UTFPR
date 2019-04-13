package selenium;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author andreendo
 */
public class ExerciciosTest {
    
    private WebDriver d;
    
    @BeforeClass
    public static void beforeClass() {
        //ALTERAR PARA O DIRETORIO ONDE VC INSTALOU O ARQUIVO CHROMEDRIVER.EXE
        System.setProperty("webdriver.chrome.driver", "/home/utfpr/install/chromedriver");
    }
    
    @Before
    public void before() {
        d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        
    }
    
    @Test
    public void testLinks() {
        d.get("https://saucelabs.com/test/guinea-pig");
        
        WebElement link = d.findElement( By.linkText("i am a link") );
        link.click();
        
        WebElement div = d.findElement( By.id("i_am_an_id") );
        assertEquals("I am another div", div.getText());
        d.close();
    }
    
    @Test
    public void testPreencherCampos() {
        d.get("https://saucelabs.com/test/guinea-pig");
        
        WebElement firstInput = d.findElement(By.id("i_am_a_textbox"));
        firstInput.clear();
        firstInput.sendKeys("aqui foi preenchido");
        
        WebElement firstCheckbox = d.findElement(By.name("unchecked_checkbox"));
        assertFalse(firstCheckbox.isSelected());
        firstCheckbox.click();

        WebElement secondCheckbox = d.findElement(By.name("checked_checkbox"));
        assertTrue(secondCheckbox.isSelected());
        secondCheckbox.click();
        
        WebElement emailInput = d.findElement(By.id("fbemail"));
        emailInput.clear();
        emailInput.sendKeys("andre@mail.com");
        
        WebElement commentsInput = d.findElement(By.id("comments"));
        commentsInput.clear();
        commentsInput.sendKeys("Some comments here!");
        
        d.close();
    }

    @Test
    public void testEnviarComentario() {
        d.get("https://saucelabs.com/test/guinea-pig");
        
        WebElement commentsInput = d.findElement(By.id("comments"));
        commentsInput.clear();
        commentsInput.sendKeys("Some comments here!");
        
        WebElement sendButton = d.findElement(By.id("submit"));
        sendButton.click();
        
        WebElement commentsDisplay = d.findElement(By.id("your_comments"));
        assertEquals("Your comments: Some comments here!", commentsDisplay.getText().trim());
        
        d.close();
    }
    
}