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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author andreendo
 */
public class Exercicios02Test {
    
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
    public void testBuscarPesquisador() {
        d.get("http://buscatextual.cnpq.br/buscatextual/busca.do?metodo=apresentar");
        
        WebElement buscaInput = d.findElement( By.id("textoBusca") );
        buscaInput.sendKeys("André Takeshi Endo");
               
        WebElement buscarDemaisCBox = d.findElement( By.id("buscarDemais") );
        buscarDemaisCBox.click();
        
        Select paisSelect = new Select( d.findElement(By.id("paisNascimento")) );                
        paisSelect.selectByVisibleText("Austrália");
        
        WebElement buscaBotao = d.findElement( By.id("botaoBuscaFiltros") );
        buscaBotao.click();
        
        WebElement titDiv = d.findElement( By.className("tit_form") );
        
        assertEquals("Resultado de 1 - 1 de 1 encontrado para: 'André Takeshi Endo'", titDiv.getText().trim());
        d.close();
    }
    
}
