package configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;

public class AndroidDriverProvider implements WebDriverProvider {

    private final String resources = "src\\main\\resources";
    private final File apk = new File(resources, "Mobile.apk");

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability(MobileCapabilityType.VERSION, "4.4.2");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        String deviceName = "K05TS57130007069";
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("app", apk.getAbsolutePath());
        capabilities.setCapability(APP_PACKAGE, "com.mobile.app.test");
        capabilities.setCapability(APP_ACTIVITY, "com.mobile.ui.login.pin.LoginActivity");
        try {
            String driverURL = "http://0.0.0.0:4723/wd/hub";
            return new AndroidDriver(new URL(driverURL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    public void setUp() {
        Configuration.browser = AndroidDriverProvider.class.getName();
    }

}
