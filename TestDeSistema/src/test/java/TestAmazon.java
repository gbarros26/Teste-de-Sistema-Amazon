import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAmazon {

    WebDriver driver;

    @BeforeAll
    public void setupAll(){
       System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");


    }

    @BeforeEach
    public void setup(){
       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterEach
    public void closeDriver(){
        WebDriver driver = new ChromeDriver();
        driver.close();
    }




    @Test
    public void abrirPaginaTest() {  //OK

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.br/");
        Assertions.assertEquals("https://www.amazon.com.br/", driver.getCurrentUrl());    //assert equals


    }

    @Test
    public void encontrarElementoTest(){  //OK
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.br/");
         WebElement busca = driver.findElement(By.id("twotabsearchtextbox"));     //find element  e BY.id

    }

    @Test
    public void pesquisarCelular(){  //OK
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.br/");
        WebElement busca = driver.findElement(By.id("twotabsearchtextbox"));     //find element e send keys  e By.id
        busca.sendKeys("celular xiaomi");
        WebElement botao = driver.findElement(By.id("nav-search-submit-button"));
        botao.click();
    }

    @Test
    public void moverElemento(){  //OK
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.br/");
        Actions actions = new Actions(driver);
        WebElement botao = driver.findElement(By.id("nav-search-submit-button"));     //   assert true e moveToElement
        actions.moveToElement(botao).perform();
        Assertions.assertTrue(botao.isEnabled());


    }





    @Test
    public void selecionarElementos(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.br/s?k=celular+xiaomi&sprefix=ce%2Caps%2C289&ref=nb_sb_ss_ts-doa-p_1_2");
        WebElement  tabela = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]"));   //ex: /hmtl/body/main
        List<WebElement> elements = tabela.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]"));  //ex:("./tr")         //By.xpath  findElements


    }

    @Test
    public void selecionarUmaOpcao(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/s?k=celular+xiaomi&sprefix=ce%2Caps%2C289&ref=nb_sb_ss_ts-doa-p_1_2");  //https
        WebElement selectElement = driver.findElement(By.xpath(""));  //pesquisar alguma coisa    //selectByIndex
        Select select = new Select(selectElement);
        select.selectByIndex(3);



    }

    @Test
    public void pesquisarCelularFalso(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.br/");
        WebElement busca = driver.findElement(By.id("twotabsearchtextbox")); //id de um campodebusca    //find element e send keys  e By.id
        busca.sendKeys("celular xiaomi");  //ex: oq pesquisa
        WebElement botao = driver.findElement(By.name("nav-search-submit-button"));     //   assert false
        Assertions.assertFalse(botao.isDisplayed());


    }

    @Test
    public void Enviar(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.br/");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));  //ex: header-search-input
        search.sendKeys("smart tv");             //submit
        search.submit();
    }


    }


