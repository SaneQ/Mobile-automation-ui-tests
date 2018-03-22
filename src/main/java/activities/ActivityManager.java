package activities;

public class ActivityManager {

    private AccountActivity accountActivity;
    private AddressActivity addressActivity;
    private PinCodeActivity pinCodeActivity;
    private SignupActivity signupActivity;
    private TutorialActivity tutorialActivity;
    private MainActivity mainActivity;
    private SuccessActivity successActivity;

    public AccountActivity getAccountActivity() {
        if (accountActivity == null) {
            accountActivity = new AccountActivity();
        }
        return accountActivity;
    }

    public AddressActivity getAddressActivity() {
        if (addressActivity == null) {
            addressActivity = new AddressActivity();
        }
        return addressActivity;
    }

    public PinCodeActivity getPinCodeActivity() {
        if (pinCodeActivity == null) {
            pinCodeActivity = new PinCodeActivity();
    }
        return pinCodeActivity;
    }

    public SignupActivity getSignupActivity() {
        if (signupActivity == null) {
            signupActivity = new SignupActivity();
        }
        return signupActivity;
    }

    public TutorialActivity getTutorialActivity() {
        if (tutorialActivity == null) {
            tutorialActivity = new TutorialActivity();
        }
        return tutorialActivity;
    }

    public MainActivity getMainActivity() {
        if (mainActivity == null) {
            mainActivity = new MainActivity();
        }
        return mainActivity;
    }

    public SuccessActivity getSuccessActivity() {
        if (successActivity == null) {
            successActivity = new SuccessActivity();
        }
        return successActivity;
    }

}
