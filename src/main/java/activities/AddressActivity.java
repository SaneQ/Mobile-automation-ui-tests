package activities;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class AddressActivity extends AbstractActivity {

    private final By addrPostalcode = By.id(appPackID + "address_postal_code");
    private final By address = By.id(appPackID + "address_line_1");
    private final By addressCity = By.id(appPackID + "address_city");
    private final By nextBtn = By.id(appPackID + "button_next");

    @Step("Ввод адресных данных")
    public AddressActivity fillRequiredFields(String postalCode, String address, String city) {
        setPostalCode(postalCode);
        setAddress(address);
        setCity(city);
        $(nextBtn).click();
        return this;
    }

    private AddressActivity setPostalCode(String postalCode) {
        $(addrPostalcode).setValue(postalCode);
        return this;
    }

    private AddressActivity setAddress(String adress) {
        WebDriverRunner.getWebDriver().navigate().back();
        $(address).setValue(adress);
        return this;
    }

    private AddressActivity setCity(String city) {
        WebDriverRunner.getWebDriver().navigate().back();
        $(addressCity).setValue(city);
        return this;
    }

}
