package steps;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

public class Hooks extends BasePage {


    public Hooks(){
        super(driver);
    }

    public  void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            scenario.log("Scenario failing, plase refer to the image attached to this report");
            final byte[] screanshot = ((TakesScreenshot )driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screanshot,"image/png","Screanshot of the error");
        }

    }
}
