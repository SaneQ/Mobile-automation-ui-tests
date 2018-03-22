package activities;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class AccountActivity extends AbstractActivity{

    private final By firstName = By.id(appPackID + "first_name");
    private final By lastName = By.id(appPackID + "last_name");
    private final By accNumber = By.id(appPackID + "server_field_0");
    private final By nextBtn = By.id(appPackID + "button_next");
    private final By smsField = By.xpath("//android.widget.EditText[@text='code']");
    //TODO add other locators

    @Step("Заполнеие полей аккаунта")
    public AccountActivity fillRequiredFields(String firstName, String lastName, String accNum, String code) {
        try {
            setFirstName(firstName);
            setLastName(lastName);
            setAccountNumber(accNum);
            setSmsField(code);
            $(nextBtn).click();
        } catch (Exception e) {
            throw new IllegalStateException("Обнаружен(ы) дефект(ы): " + e);
        }
        return this;
    }

    private AccountActivity setFirstName(String name){
        $(firstName).setValue(name);
        return this;
    }

    private AccountActivity setLastName(String name){
        $(lastName).setValue(name);
        WebDriverRunner.getWebDriver().navigate().back();
        return this;
    }

    private AccountActivity setAccountNumber(String number){
        $(accNumber).click();
        $(accNumber).setValue(number);
        return this;
    }

    private AccountActivity setSmsField(String sms){
        WebDriverRunner.getWebDriver().navigate().back();
        $(smsField).setValue(sms);
        return this;
    }

}
