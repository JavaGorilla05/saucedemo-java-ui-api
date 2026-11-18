package tests;

import api.AuthApi;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SauceDemoTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final AuthApi authApi = new AuthApi();

    @Test
    @Tag("smoke")
    @Tag("ui")
    @DisplayName("Успешная авторизация и добавление товара в корзину (UI)")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("QA Automation")
    public void successfulLoginAndAddToCartTest() {
        loginPage.loginAs("standard_user", "secret_sauce")
                .assertPageTitle("Products")
                .addFirstItemToCart()
                .assertCartCount("1");
    }

    @Test
    @Tag("regress")
    @Tag("ui")
    @DisplayName("Ошибка: пустое имя пользователя")
    @Severity(SeverityLevel.NORMAL)
    @Owner("QA Automation")
    public void emptyUsernameLoginTest() {
        loginPage.openPage()
                .enterUsername("")
                .setPassword("secret_sauce")
                .clickLoginButton();

        assertEquals("Epic sadface: Username is required", loginPage.getErrorMessageText());
    }

    @Test
    @Tag("regress")
    @Tag("ui")
    @DisplayName("Ошибка: пустой пароль")
    @Severity(SeverityLevel.NORMAL)
    @Owner("QA Automation")
    public void emptyPasswordLoginTest() {
        loginPage.openPage()
                .enterUsername("standard_user")
                .setPassword("")
                .clickLoginButton();

        assertEquals("Epic sadface: Password is required", loginPage.getErrorMessageText());
    }

    @Test
    @Tag("regress")
    @Tag("ui")
    @DisplayName("Ошибка: заблокированный пользователь")
    @Severity(SeverityLevel.NORMAL)
    @Owner("QA Automation")
    public void lockedOutUserLoginTest() {
        loginPage.openPage()
                .enterUsername("locked_out_user")
                .setPassword("secret_sauce")
                .clickLoginButton();

        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessageText());
    }

    @Test
    @Tag("regress")
    @Tag("api")
    @DisplayName("Успешная авторизация через API (REST Assured)")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("QA Automation")
    public void successfulApiLoginTest() {
        String token = authApi.getToken("eve.holt@reqres.in", "cityslicka");

        assertNotNull(token, "Токен не должен быть null");
    }
}