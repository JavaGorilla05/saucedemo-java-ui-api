package drivers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSetUp {
    public static void configure() {
        Configuration.baseUrl = ProjectConfig.getBaseUrl();
        Configuration.browser = ProjectConfig.getBrowser();
        Configuration.browserSize = ProjectConfig.getBrowserSize();
        Configuration.timeout = 8000;
        Configuration.pageLoadTimeout = 20000;

        if (ProjectConfig.isRemote()) {
            Configuration.remote = ProjectConfig.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }
}
