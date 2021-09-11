import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyStepTodo2 {

    private AppiumDriver driver;

    @Given("tengo abierto el aplicativo")
    public void tengoAbiertoElAplicativo() throws MalformedURLException {
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

    @When("hago click en button adicionar contacto")
    public void hagoClickEnButtonAdicionarContacto() {
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
    }


    @And("hago click en adicionar titulo y nota")
    public void hagoClickEnAdicionarTituloYNota(Map<String,String> datosFormulario) {

        for (String nameField: datosFormulario.keySet()
        ) {
         //   System.out.println("nombre control: "+nameField+ " valor a definir: "+datosFormulario.get(nameField));

            driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).click();
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(nameField);
            System.out.println("prueba5555 ");
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).click();
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(nameField);

//guardar
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Save And New']")).click();
        }
    }



    @And("hago en el doble check para ver la lista")
    public void hagoEnElDobleCheckParaVerLaLista() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Save']")).click();
    }

    @Then("deberian mostrar la lista")
    public void deberianMostrarLaLista() {
    }



}
