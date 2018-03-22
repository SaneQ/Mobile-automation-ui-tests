import activities.SignupActivity;
import activities.TutorialActivity;
import configuration.AndroidDriverProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class TutorialTest extends AndroidDriverProvider {

    @Test
    @Title("Проверка туториала")
    public void checkTutorialPages(){
        TutorialActivity tutorialActivity = new TutorialActivity();
        tutorialActivity
            .checkElementsOnFirstPage().goToNextPage()
            .checkElementsOnSecondPage().goToNextPage()
            .checkElementsOnThirdPage().goToNextPage()
            .checkElementsOnFourthPage().goToNextPage()
            .checkElementsOnFifthPage().goToNextPage();
        new SignupActivity().checkElements();
    }

}
