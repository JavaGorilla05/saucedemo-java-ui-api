package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $("[data-test='error']");

    @Step("Открыть страницу авторизации SauceDemo")
    public LoginPage openPage(){
        open("/");
        return this;
    }

    @Step("Ввести логин: {username}")
    public LoginPage enterUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    @Step("Ввести пароль: {password}")
    public LoginPage setPassword(String password){
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажать кнопку входа")
    public ProductsPage clickLoginButton(){
        loginButton.click();
        return new ProductsPage();
    }
    @Step("Авторизоваться пользователем: {username}")
    public ProductsPage LoginAs(String username, String password){
        openPage();
        setPassword(password);
        enterUsername(username);
        return clickLoginButton();
    }

    @Step("Получить текст ошибки")
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    @Step("Авторизоваться пользователем: {username}")
    public ProductsPage loginAs(String username, String password) {
        openPage();
        enterUsername(username);
        setPassword(password);
        return clickLoginButton();
    }
}
