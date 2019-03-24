package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import unit.Init;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BasePageObject {
    public BasePageObject(){
        PageFactory.initElements(Init.getDriver(), this);
    }

    public static void compareText(String actual, String expected) {
        Assert.assertTrue(("Искомого текста нет: " + expected + " вместо него " + actual), actual.contains(expected));
        System.out.println("Искомый текст есть: " + expected);
    }

    public String setData(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        Calendar i = Calendar.getInstance();
        i.setTime(new Date());
        i.add(Calendar.DAY_OF_MONTH, 14);
        String newDate = formatForDateNow.format(i.getTime());
        return newDate;
    }

    public void findXpath(String xpath){
        Init.getDriver().findElement(By.xpath(xpath));
    }

    public static void scrollToElement(WebElement find){
        ((JavascriptExecutor) Init.getDriver()).executeScript("arguments[0].scrollIntoView();", find);
        Wait<WebDriver> wait = new WebDriverWait(Init.getDriver(), 20, 1000);
        wait.until(ExpectedConditions.visibilityOf(find));
    }
    public static boolean isElementPresented(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10);
            wait.until((WebDriver d) -> element);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void waitFieldisDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10);
            wait.until((WebDriver d) -> element.isDisplayed());
            return;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        Assert.fail("Поле не отображено");
    }

    public static void click(WebElement element) {
        if (!isElementPresented(element)) {
        }
        waitFieldisDisplayed(element);
        element.click();
    }

    public static void fillForm(String text, WebElement element) throws InterruptedException {
        while (!(element.getAttribute("value").equals(text))) {
            scrollToElement(element);
            element.click();
            element.clear();
            Thread.sleep(1000);
            element.sendKeys(text);
        }
    }

    public static void checkBoxCheck(WebElement checkbox){
        if(!(checkbox.isSelected())){
            checkbox.click();
        }
    }
    public static void checkBoxUnCheck(WebElement checkbox){
        if(checkbox.isSelected()){
            checkbox.click();
        }
    }
}
