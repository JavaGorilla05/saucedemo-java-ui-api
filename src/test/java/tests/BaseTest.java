package tests;

import com.codeborne.selenide.Selenide;

import drivers.DriverSetUp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setUpAll() {
        DriverSetUp.configure();
    }
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
