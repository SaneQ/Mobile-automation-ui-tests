package configuration;

import activities.*;
import ru.yandex.qatools.allure.annotations.Step;

public class TestHelper extends AndroidDriverProvider {
    protected final ActivityManager goTo = new ActivityManager();
    private final String phoneNumber = DataProperties.getProperty("phoneNumber");
    private final String pin = DataProperties.getProperty("pin");

    @Step("Переход к активити \"Платежи\"")
    protected void goToActivityForPayments() {
        TutorialActivity tutorialActivity = goTo.getTutorialActivity();
        SignupActivity signupActivity = goTo.getSignupActivity();
        PinCodeActivity pinCodeActivity = goTo.getPinCodeActivity();
        MainActivity mainActivity = goTo.getMainActivity();

        tutorialActivity.skipTutorial();
        signupActivity.setPhoneNumber(phoneNumber).goToNextPage();
        pinCodeActivity.setPin(pin);
        mainActivity.getTransferActivity();
        tutorialActivity.skipTutorial();
    }
}
