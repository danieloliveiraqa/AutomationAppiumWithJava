import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ioSampleTest {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung S10+");
        caps.setCapability("udid", "35392474bc3f7ece"); // Digite no CMD: adb devices para descobrir a ID.
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage","com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testeCalculadoraSoma() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("1");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("0");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Mais");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("2");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("0");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("Igual");
        el6.click();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
