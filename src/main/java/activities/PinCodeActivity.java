package activities;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;

public class PinCodeActivity extends AbstractActivity{
    private final By pinCodeWidget = By.id(appPackID + "pincode_widget");
    private final By blockButtons = By.id(appPackID + "block_buttons");

    @Step("Проверка элементов активити пин-кода")
    private PinCodeActivity checkPinCodeActivity(){
        $(pinCodeWidget).waitUntil(Condition.enabled, 15000);
        $(blockButtons).shouldHave(Condition.enabled);
        return this;
    }

    @Step("Ввод пин-кода")
    public PinCodeActivity setPin(String pin){
        checkPinCodeActivity();
        for(int i = 0; i < pin.length(); i++) {
            int digit = Character.digit(pin.charAt(i), 10);
            $(getElement(By.id(appPackID + "digit"+digit))).click();
        }
        return this;
    }


}
