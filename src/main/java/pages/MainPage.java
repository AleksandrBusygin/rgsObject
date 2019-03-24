package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePageObject {
    public  MainPage(){
        super();
    }
//    public static final String MENU_NAME="//*[@class='hidden-xs'][contains(text(),'%s')]"

    @FindBy(xpath = "//ol/li/a[contains(text(),'Страхование')]")
    WebElement elementSt;

    @FindBy(xpath = "//*[@class='hidden-xs']")
    List<WebElement> elementP;

    public void chooseService(String name){
        click(elementSt);
        elementP.stream().filter(element -> element.getText().equals(name)).findFirst().get().click();
    }

//    public void addByName(String name){
//        findXpath(String.format(MENU_NAME, name));
//    }

}
