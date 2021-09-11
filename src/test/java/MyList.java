import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static javafx.beans.binding.Bindings.when;

public class MyList {
    private AppiumDriver driver;

    @BeforeEach
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Prueba");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait( 15, TimeUnit.SECONDS);
    }
    @AfterEach
    public void after() {
        driver.quit();

    }
    @Test
    public void verifyTheCalculatorApp() throws InterruptedException {
        Thread.sleep(3000);
        //-----------------REGISTRAR--------------------------
        //CLICK EN EL BOTON "+"
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        Thread.sleep(1000);
        for (int contador = 25;contador > 0; contador-- ){

            if(contador >= 13 ){

                //INGRESAR EL TITULO
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).click();
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("VALOR1");
                Thread.sleep(1000);
                //INGRESAR UNA NOTA
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).click();
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Esta es la nota para el campo de VALOR1");
                //GUARDAR Y CONTINUAR EN LA VENTANA LLENANDO VALORES
                driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Save And New']")).click();
                Thread.sleep(1000);
                System.out.println(contador);
            }else {
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("ANTONIA1");
                Thread.sleep(1000);
                //INGRESAR UNA NOTA
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).click();
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Esta es la nota para el campo de ANTONIA1");
                System.out.println(contador);

                if (Objects.equals(contador, 1)){
                    driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Save']")).click();
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']")).click();
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//android.widget.TextView[@text='Sort']")).click();
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Alphabetic']")).click();
                    Thread.sleep(1000);
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/notesList")).click();
                    Thread.sleep(1000);
                    //EDITAR REGISTROS
                    //seleccionar registro de la lista
                    driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.vrproductiveapps.whendo:id/noteTextTitle']")).clear();
                    Thread.sleep(1000);
                    //Modificar el valor
                    driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.vrproductiveapps.whendo:id/noteTextTitle']")).sendKeys("VALOR2");
                    //Ingresar valor en el texto de la nota
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).click();
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Anotaciones 1 xxx");
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
                    Thread.sleep(1000);
                    //driver.findElement(By.id("com.vrproductiveapps.whendo:id/notesList")).click();
                    //Buscar información
                   /* driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Search']")).click();
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/search_src_text")).click();
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/search_src_text")).sendKeys("VALOR1");
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/search_mag_icon")).click();
                    driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Mark Done']")).click();*/
                    //Eliminar registro
                    driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']")).click();
                    driver.findElement(By.xpath("//android.widget.TextView[@text='Delete Completed']")).click();
                    //CONFIRMAR ELIMINAR
                    driver.findElement(By.xpath("//android.widget.Button[@text='DELETE']")).click();
                    Thread.sleep(1000);
                }else{
                    //GUARDAR Y CONTINUAR EN LA VENTANA LLENANDO VALORES
                    driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Save And New']")).click();
                    Thread.sleep(1000);
                }
            }


        }

        TouchAction action = new TouchAction(driver);

        //WebElement firstControl= driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc='Mark Done'])[18]"));
        //WebElement endControl= driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc='Mark Done'])[3]"));
        //WebElement firstControl= driver.findElement(By.xpath("//android.widget.TextView[@text='VALOR1']"));
        //WebElement endControl= driver.findElement(By.xpath("//android.widget.TextView[@text='ANTONIA1']"));
       //WebElement firstControl = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[25]"));

        WebElement firstControl = driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc='Mark Done'])[11]"));
        WebElement endControl= driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc='Mark Done'])[1]"));
                System.out.println("ultimo");
        int firstControlX= firstControl.getLocation().getX();
        int firstControlY= firstControl.getLocation().getY();

        int endControlX= endControl.getLocation().getX();
        int endControlY= endControl.getLocation().getY();

        action.press(PointOption.point(firstControlX,firstControlY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endControlX,endControlY))
                .release().perform();
        //CLICK EN EL BOTON "+"
        //INGRESAR EL TITULO
        //INGRESAR UNA NOTA
        //GUARDAR Y RETORNAR A LA VISTA INICIAL

        //-----------------MENU  LATERAL (....)--------------------------
        //-----------------EDITAR----------------------------------------
        //-----------------BUSCAR----------------------------------------
        //-----------------ELIMINAR--------------------------------------
        //-----------------SWIPE-----------------------------------------

    }

}

