/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author YS
 */
public class PruebaFormularioIT {
    
    private static WebDriver manejador;
    
    WebElement txt_nombreCarro;
    WebElement txt_identificadorCarro;
    WebElement txt_colorCarro;
    WebElement txt_modeloCarro;
    WebElement btn_informacion;
    WebElement msjValidadorNombre;
    
    @BeforeClass
    public static void inicializarManejador()
    {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe" );
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        
        manejador =  new FirefoxDriver();
         manejador.get("http://localhost:8080/JSF_FormComponent/");
        
    }
    
    @AfterClass
    public static void eliminarManejador()
    {
        //manejador.quit();
    }
    
    @Test
    public void testSimple() throws Exception {
        
        txt_nombreCarro = manejador.findElement(By.id("form:nombreCarro"));
         txt_identificadorCarro = manejador.findElement(By.id("form:identificadorCarro"));
         txt_colorCarro = manejador.findElement(By.id("form:colorCarro"));
         txt_modeloCarro = manejador.findElement(By.id("form:modeloCarro"));

         // botones
         btn_informacion = manejador.findElement(By.id("form:informacion"));
         
         //asignar valores a los objetos
         
        txt_nombreCarro.sendKeys("Touota12");
        txt_identificadorCarro.sendKeys("1245789");
        txt_colorCarro.sendKeys("azyl");
        txt_modeloCarro.sendKeys("2005");
        
        msjValidadorNombre =  manejador.findElement(By.id("form:msjValNombreCarro"));
        String cadena = msjValidadorNombre.getText();
        Assert.assertEquals(cadena, "");
        

         
        
    }
    
}
