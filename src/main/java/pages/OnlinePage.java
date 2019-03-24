package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlinePage extends BasePageObject {
    public OnlinePage(){
        super();
    }

    @FindBy(xpath = "//a[contains(text(), 'Рассчитать')]")
    WebElement onlineButton;

    public void selectPayment(){
        scrollToElement(onlineButton);
        click(onlineButton);
    }

}
