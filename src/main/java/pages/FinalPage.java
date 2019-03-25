package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FinalPage extends BasePageObject {

    public FinalPage(){
        super();
    }
    @FindBy(xpath = "//div[@class='program-name'][contains(text(),'Комфорт')]")
    WebElement comfort;
    @FindBy(xpath = "//h2[@class='step-title'][contains(text(),'Расчет')]")
    WebElement elementToscroll;

    @FindBy(xpath = "//span/span[@class='text-bold']/parent::span")
    WebElement trips;
    @FindBy(xpath = "//span/strong[@data-bind='text: Name']")
    WebElement shengen;
    @FindBy(xpath = "//strong[@data-bind=\"text: LastName() + ' ' + FirstName()\"]")
    WebElement firstName;
    @FindBy(xpath = "//strong[@data-bind=\" text: BirthDay.repr('moscowRussianDate')\"]")
    WebElement birthDate;
    @FindBy(xpath = "//div[@style=\"visibility: visible; opacity: 1; display: block; transform: translateX(0px);\"]//child::small[@data-bind=\"text: ko.unwrap('undefined' === typeof info ? '' : info)\"]")
    WebElement relaxOption;

    public void compareFinalResults(String p1, String p2, String p3, String p4, String p5){
        waitFieldisDisplayed(comfort);
        scrollToElement(elementToscroll);
        compareText(trips.getText(),p1);
        compareText(shengen.getText(),p2);
        compareText(firstName.getText(),p3);
        compareText(birthDate.getText(),p4);
        compareText(relaxOption.getText(),p5);
    }





}
