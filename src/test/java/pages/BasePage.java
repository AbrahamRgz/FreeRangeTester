package pages;

import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {

    /*declaracion de una variable estatica de tipo web driver
     * esta variable va a ser compartida por todas las intancias de BasePge y
     * subclases */
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Este es el ontructor de la basepage que acepta un objeto Webdriver como argumento
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    //metodo para navegar a la url
    public static void NavigateTo(String url) {
        driver.get(url);
    }
    public static void WindowMaximace(){
        driver.manage().window().maximize();
    }

    public static void CloseBrowser(){
        driver.quit();
    }

    private WebElement Find (String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void ClickElmento(String locator){
        Find(locator).click();
    }

    public void Write(String locator, String KeystoSend){
        Find(locator).clear();
        Find(locator).sendKeys(KeystoSend);
    }
    public void selectFromDropDawnByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropDawnByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    public int dropdawnSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdawnOptions=dropdown.getOptions();
        return dropdawnOptions.size();
    }

    public  List<String> getDropdawnvalues(String locator){
        Select dropdawn = new Select(Find(locator));

        List<WebElement> dropdawnoptions = dropdawn.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdawnoptions){
            values.add(option.getText());
        }
        return values;
    }

    public void newWindow (String locator){
        ClickElmento(locator);
        Set<String> windows = driver.getWindowHandles();
        Iterator <String> it = windows.iterator();;
        String parentId = it.next();
        String childId = it.next();

        //Cambiar a la nueva pagina que se le dio click
        driver.switchTo().window(childId);

    }

}


