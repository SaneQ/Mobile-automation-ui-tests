package activities;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainActivity extends AbstractActivity{

    private final By mainWidget = By.id(appPackID + "main_container");
    private final By transferButton = By.id(appPackID + "button_transfer");

    @Step("Переходим в основное активити")
    public MainActivity getTransferActivity(){
        $(mainWidget).waitUntil(Condition.enabled, 15000);
        $(transferButton).click();
        return this;
    }
}
