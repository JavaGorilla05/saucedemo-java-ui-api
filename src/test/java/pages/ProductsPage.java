package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    private final SelenideElement titleSpan = $(".title");
    private final SelenideElement shoppingCartBadge = $(".shopping_cart_badge");

    @Step("Проверить, что открыта страница каталога с заголовком {expectedTitle}")
    public ProductsPage assertPageTitle(String expectedTitle){
        titleSpan.shouldHave(text(expectedTitle));
        return this;
    }

    @Step("Добавить первый товар в корзину")
    public ProductsPage addFirstItemToCart(){
        $("[data-test^='add-to-cart']").click();
        return this;
    }

    @Step("Проверить, что счетчик корзины равен {expectedCount}")
    public ProductsPage assertCartCount(String expectedCount){
        shoppingCartBadge.shouldBe(visible).shouldHave(text(expectedCount));
        return this;
    }

}
