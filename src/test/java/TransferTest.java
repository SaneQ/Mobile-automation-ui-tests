import configuration.DataProperties;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import configuration.TestHelper;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class TransferTest extends TestHelper {
    private final String firstName = DataProperties.getProperty("firstName");
    private final String lastName = DataProperties.getProperty("lastName");
    private final String accNumber = DataProperties.getProperty("accNumber");
    private final String bsb = DataProperties.getProperty("bsb");
    private final String postalCode = DataProperties.getProperty("postalCode");
    private final String address = DataProperties.getProperty("address");
    private final String city = DataProperties.getProperty("city");

    @Test
    @Title("Добавление нового бенефициара")
    public void addNewBeneficiaryPersonTest(){
        goToActivityForPayments();
        goTo.getAccountActivity().fillRequiredFields(firstName, lastName, accNumber, bsb);
        goTo.getAddressActivity().fillRequiredFields(postalCode, address, city);
        String successText = goTo.getSuccessActivity().getTextTitle();
        assertThat(successText, is("Beneficiary "+firstName+" "+ lastName+" was successfully created"));
        //todo check added item to list
    }

}
