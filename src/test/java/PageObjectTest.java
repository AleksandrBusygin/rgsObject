import forTest.ForTest;
import org.junit.Test;

public class PageObjectTest extends ForTest {

    @Test
    public void rgs() throws InterruptedException {
        mainPage.chooseService("Путешествия");
        individualsPage.chooseWorldPart("Страхование выезжающих за рубеж");
        onlinePage.selectPayment();
        calculationPage.compareHeader();
        calculationPage.chooseCountOfTrips();
        calculationPage.chooseCountry(countryName);
        calculationPage.setDepartureDate();
        calculationPage.chooseCountOfDays("Не более 90 дней");
        calculationPage.selectName("PUTIN VLADIMIR");
        calculationPage.selectBirthDate("07.10.1952");
        calculationPage.chooseRelaxOption(true);
        calculationPage.consent();
        calculationPage.calculation();
        finalPage.compareFinalresults();
    }

}
