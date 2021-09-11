import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyStepTodoManager {

    private AppiumDriver driver;

    @Given("tengo Todo abierto")
    public void tengoContactManagerAbieto() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Prueba");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // implicit wait - para todos los controles
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }





    @When("hago click en Ok button adicionar contacto")
    public void hagoClickEnOkButtonAdicionarContacto() {

        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();

    }

    @And("lleno el campo Titulo con {string}")
    public void llenoElCampoTituloCon(String value) {

        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).click();
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(value);
    }

    @And("lleno el campo Notas con {string}")
    public void llenoElCampoNotasCon(String value) {

        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).click();
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(value);

    }

    @And("presiono el check para guardar")
    public void presionoElCheckParaGuardar() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Save And New']")).click();
    }

    @And("hago en el doble check para ver los contactos agregados")
    public void hagoEnElDobleCheckParaVerLosContactosAgregados() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Save']")).click();
        }


    @Then("el contact {string} deberia ser creado")
    public void elContactDeberiaSerCreado(String arg0) {
    }
}
