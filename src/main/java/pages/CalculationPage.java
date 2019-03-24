package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalculationPage extends BasePageObject {
    public CalculationPage(){
        super();
    }
    @FindBy(xpath = "//div[@class='page-header']/span[@class='h1']")
    WebElement head;

    public void compareHeader(){
        waitFieldisDisplayed(head);
        compareText(head.getText(),"Страхование выезжающих за рубеж");
    }

    @FindBy(xpath = "//button/*[contains(@class, 'content-title')]")
    WebElement someTrips;

    public void chooseCountOfTrips(){
        scrollToElement(someTrips);
        click(someTrips);
    }

    @FindBy(xpath = "//*[@id='Countries']")
    WebElement selectCountry;

    @FindBy(name = "ArrivalCountryList")
    WebElement selectArrivalCountry;

    public void chooseCountry(String country) throws InterruptedException {
        fillForm("Шенген", selectCountry);
        selectCountry.sendKeys(Keys.DOWN,Keys.ENTER);
        new Select(selectArrivalCountry).selectByVisibleText(country);
    }

    @FindBy(xpath = "//input[@data-test-name='FirstDepartureDate']")
    WebElement elementDeparture;

    public void setDepartureDate() throws InterruptedException {
        elementDeparture.click();
        waitFieldisDisplayed(elementDeparture);
        isElementPresented(elementDeparture);
        fillForm(setData(),elementDeparture);
    }

    @FindBy(xpath = "//label[@class='btn btn-attention']")
    List<WebElement> countOfDays;

    public void chooseCountOfDays(String count){
            countOfDays.stream().filter(element -> element.getText().equals(count)).findFirst().get().click();
    }

    @FindBy(xpath = "//input[@data-test-name='FullName']")
    WebElement fullName;

    public void selectName(String name) throws InterruptedException {
        waitFieldisDisplayed(fullName);
        fillForm(name,fullName);
    }

    @FindBy(xpath = "//input[@data-test-name=\"BirthDate\"]")
    WebElement birthDaate;

    public void selectBirthDate(String date) throws InterruptedException {
        waitFieldisDisplayed(birthDaate);
        fillForm(date,birthDaate);
    }

    @FindBy(xpath = "//div[contains(@data-bind,'activeRestOrSportsToggle')]/div[contains(@class, 'toggle-rgs')]")
    WebElement activeRelax;

    public void chooseRelaxOption(boolean ad){
        if(ad == true){
            checkBoxCheck(activeRelax);
        }
        if (ad == false) {
            checkBoxUnCheck(activeRelax);
        }
    }

    @FindBy(xpath = "//label[@class='adaptive-checkbox-label'][contains(text(),' Я согласен')]")
    WebElement agree;

    public void consent(){
        scrollToElement(agree);
        checkBoxCheck(agree);
    }

    @FindBy(xpath = "//button[@data-test-name='NextButton'][contains(text(),'Рассчитать')]")
    WebElement calculate;

    public void calculation(){
        click(calculate);
    }
}
