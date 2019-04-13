package selenium;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
    
    @Test
    public void test01() {
        System.setProperty("webdriver.chrome.driver", "/home/utfpr/install/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://www.google.com.br/");
        WebElement searchInput = driver.findElement( By.name("q") );
        searchInput.sendKeys("teste de software");
        searchInput.submit();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("teste");
            }
        });
        
        assertTrue(driver.getTitle().startsWith("teste de software"));
        driver.close();
    }
    
   @Test
    public void test02() {
        System.setProperty("webdriver.chrome.driver", "/home/utfpr/install/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://github.com/");
        
        //
        WebElement signUpButton = driver.findElement( By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div[1]/form/button") );
        signUpButton.click();
        
        //check msg: "There were problems creating your account."
        WebElement errorMsg = driver.findElement( By.xpath("//*[@id=\"signup-form\"]/div[2]") );
        assertEquals("There were problems creating your account.", errorMsg.getText().trim());
        
        //check msg: "Login can't be blank"
        WebElement errorMsg02 = driver.findElement( By.xpath("//*[@id=\"signup-form\"]/dl[1]/dd[2]") );
        assertEquals("Login can't be blank", errorMsg02.getText().trim());
        
        //fill the username
        WebElement username = driver.findElement( By.id("user_login") );
        username.sendKeys("andreendo22");
        
        //click on button "create account"
        WebElement caButton = driver.findElement( By.id("signup_button") );
        caButton.click();
        
        try{
            errorMsg02 = driver.findElement( By.xpath("//*[@id=\"signup-form\"]/dl[1]/dd[2]") );
            fail();
        }
        catch(NoSuchElementException e) { }
        driver.close();
    }    

    @Test
    public void test03() {
        System.setProperty("webdriver.chrome.driver", "/home/utfpr/install/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.calcule.net/imc.calculo.indice.de.massa.corporal.a.php");
        
        WebElement altura = driver.findElement( By.id("altu") );
        altura.sendKeys("180");        

        WebElement peso = driver.findElement( By.id("peso") );
        peso.sendKeys("7000");        
        
        Select sexo = new Select( driver.findElement( By.name("sexo") ) );
        sexo.selectByVisibleText("Masc");
        
        WebElement calcButton = driver.findElement( By.name("botao") );
        calcButton.click();
        
        WebElement resposta = driver.findElement( By.xpath("//*[@id=\"conteudo3\"]/table/tbody/tr/td[3]/p[4]/span/b[5]") );
        
        assertEquals("Normal", resposta.getText().trim());
        driver.close();
    }

}
