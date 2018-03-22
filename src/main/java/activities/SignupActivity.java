package activities;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SignupActivity extends AbstractActivity {

    private final By signupTitle = By.id(appPackID + "signup_title");
    private final By signupActivity = By.id(appPackID + "sign_phone_number_fragment");
    private final By phoneField = By.id(appPackID + "uic_edit_phone_number");
    private final By countryCodeField = By.id(appPackID + "uic_edit_country_code");
    private final By nextBtn = By.id(appPackID + "signup_next");
    private String countryCodeText;
    private String phoneFieldText;

    @Step("Проверка элементов и текста на титульной странице")
    public SignupActivity checkElements(){
        $(signupActivity).waitUntil(Condition.visible, 10000);
        $(signupTitle).isDisplayed();
        $(countryCodeField).isDisplayed();
        $(nextBtn).shouldHave(Condition.disabled);
        titleText =  $(signupTitle).getAttribute("text");
        phoneFieldText =  $(phoneField).getAttribute("text");
        countryCodeText =  $(countryCodeField).getAttribute("text");
        checkFieldsSignupActivity();
        return this;
    }

    @Step("Проверка текста на титульной странице")
    private void checkFieldsSignupActivity() {
        assertThat(titleText, is("Hi, welcome to Application!"));
        assertThat(phoneFieldText, is("Enter your phone number"));
        assertThat(countryCodeText, is("+7"));
    }

    @Step("Переход на следующую страницу")
    public SignupActivity goToNextPage(){
        $(nextBtn).click();
        return this;
    }

    @Step("Ввод номера телефона")
    public SignupActivity setPhoneNumber(String value){
        $(phoneField).setValue(value);
        return this;
    }

}
