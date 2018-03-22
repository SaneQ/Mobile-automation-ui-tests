package activities;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class SuccessActivity extends AbstractActivity{
    private final By stateTitle = By.id(appPackID + "operation_state_title");
    private final By nextBtn = By.id(appPackID + "operation_status_button");

    @Step("Получаем титульный текст")
    public String getTextTitle(){
        $(stateTitle).waitUntil(Condition.enabled, 10000);
        String text = $(stateTitle).getAttribute("text");
        $(nextBtn).click();
        return text;
    }

}
