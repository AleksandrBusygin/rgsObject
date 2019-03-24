package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IndividualsPage extends BasePageObject {
    public IndividualsPage(){
        super();
    }

    @FindBy(xpath = "//*[@class='list-group-item adv-analytics-navigation-line4-link']")
    List<WebElement> elementZ;

    public void chooseWorldPart(String name){
        elementZ.stream().filter(element -> element.getText().equals(name)).findFirst().get().click();
    }
}
