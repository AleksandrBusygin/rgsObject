package forTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.*;
import unit.Init;
import unit.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ForTest {
    public static Properties properties = TestProperties.getInstance().getProperties();
    protected static String baseUrl;
    protected MainPage mainPage;
    protected IndividualsPage individualsPage;
    protected OnlinePage onlinePage;
    protected CalculationPage calculationPage;
    protected FinalPage finalPage;
    protected String countryName;
//    public String name;
//    public String date;

    @Before
    public void beforeEach() {
        switch (properties.getProperty("browser2")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                Init.setDriver(new FirefoxDriver());
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                Init.setDriver(new ChromeDriver());
                break;
            case "explorer":
                System.setProperty("webdriver.ie.driver", properties.getProperty("webdriver.ie.driver"));
                Init.setDriver(new InternetExplorerDriver());
                break;
        }
        baseUrl = properties.getProperty("app.url");
        Init.getDriver().get(baseUrl);
        Init.getDriver().manage().window().maximize();
        Init.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        mainPage = new MainPage();
        individualsPage = new IndividualsPage();
        onlinePage = new OnlinePage();
        calculationPage = new CalculationPage();
        finalPage = new FinalPage();
        countryName = "Испания";
//        name = "PUTIN VLADIMIR";
//        date = "07.10.1952";
// не хочет сравнивать если задаю здесь имя и дату рождения, в финальном методе не видит этих переменных, хотя они public
    }

    @After
    public void close(){
        Init.getDriver().close();
    }
}
