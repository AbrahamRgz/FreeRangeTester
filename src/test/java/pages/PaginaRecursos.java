package pages;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PaginaRecursos extends BasePage{

    public PaginaRecursos (){
        super(driver);
    }

    private String automationSandbox ="//h3[normalize-space()='Automation Sandbox']";
    private String deportesList = "//select[@id='formBasicSelect']";
    public void AutomationSandbox(){
        //ClickElmento( automationSandbox);
        newWindow(automationSandbox);
    }

    public List<String> returnDeportesDropdawnValues() throws InterruptedException {
        return getDropdawnvalues(deportesList);
    }

    SoftAssert soft = new SoftAssert();

    public void Ejemplulis(){
        String palabraEsperada ="Pepe";
        String palabraEncontrada ="Papa";

        soft.assertEquals(palabraEsperada, palabraEncontrada);
        soft.assertTrue(palabraEncontrada.contains(palabraEsperada));

        soft.assertNotEquals(palabraEncontrada,palabraEsperada);
        soft.assertAll();
    }


}
