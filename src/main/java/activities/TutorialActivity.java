package activities;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class TutorialActivity extends AbstractActivity {

    private final By tutorialContainer = By.id(appPackID + "tutorial_fragments_container");
    private final By toolbar = By.id(appPackID + "toolbar");
    private final By tutorialsPager = By.id(appPackID + "tutorials_pager");
    private final By tutorialImage = By.id(appPackID + "tutorial_image");
    private final By tutorialTitle = By.id(appPackID + "tutorial_title");
    private final By tutorialSubtitle = By.id(appPackID + "tutorial_subtitle");
    private final By nextPageButton = By.id(appPackID + "next_button");
    private final By skip = By.id(appPackID + "header_next");
    private String subtitleText;
    private String nextButtonText;

    @Step ("Проверка элементов тулбара")
    private TutorialActivity checkWidgets(){
        $(tutorialContainer).isDisplayed();
        $(toolbar).isDisplayed();
        $(tutorialsPager).isDisplayed();
        $(tutorialImage).isDisplayed();
        $(tutorialTitle).isDisplayed();
        $(skip).isDisplayed();
        titleText =  $(tutorialTitle).getAttribute("text");
        subtitleText =  $(tutorialSubtitle).getAttribute("text");
        nextButtonText =  $(nextPageButton).getAttribute("text");
        return this;
    }

    @Step ("Проверка элементов туториала на первой активити")
    public TutorialActivity checkElementsOnFirstPage(){
        checkWidgets();
        Assert.assertEquals(titleText, "Spend your money");
        Assert.assertEquals(subtitleText, "When using the card, spending is always free.");
        Assert.assertEquals(nextButtonText, "Continue");
        return this;
    }

    @Step ("Проверка элементов туториала на второй активити")
    public TutorialActivity checkElementsOnSecondPage(){
        checkWidgets();
        Assert.assertEquals(titleText, "Track your expenses");
        return this;
    }

    @Step ("Проверка элементов туториала на третьей активити")
    public TutorialActivity checkElementsOnThirdPage(){
        checkWidgets();
        Assert.assertEquals(titleText, "Exchange currencies");
        return this;
    }

    @Step ("Проверка элементов туториала на четвертой активити")
    public TutorialActivity checkElementsOnFourthPage(){
        checkWidgets();
            Assert.assertEquals(titleText, "Control your money");
        return this;
    }

    @Step ("Проверка элементов туториала на пятой активити")
    public TutorialActivity checkElementsOnFifthPage(){
        checkWidgets();
        Assert.assertEquals(titleText, "Transfer money");
        Assert.assertEquals(nextButtonText, "Got it");
        return this;
    }

    public TutorialActivity goToNextPage(){
        $(nextPageButton).click();
        return this;
    }

    @Step ("Пропуск туториала")
    public void skipTutorial(){
        $(skip).waitUntil(Condition.enabled, 10000).click();
    }


}
