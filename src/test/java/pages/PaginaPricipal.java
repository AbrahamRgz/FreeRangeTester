package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaginaPricipal extends BasePage{

    private String sectionLink = "(//a[text()='%s'])[1]";
    private String CursosLink ="(//a[text()='Cursos'])[1]";
    private String RecursosLink ="(//a[text()='Recursos'])[1]";

    public  PaginaPricipal (){
        super(driver);
    }

    public void navigeteFreRantester(){
        NavigateTo("https://www.freerangetesters.com");
        WindowMaximace();
    }

    public  void clickOnSectionLink(String section){
        //Reemplaza el marcador de posision en sectionlink con el nombre
        String xpathsection = String.format(sectionLink,section);
        ClickElmento(xpathsection);
    }

    public void GoToCursos(){
        ClickElmento(CursosLink);
    }

    public  void GoToRecursos(){
        ClickElmento(RecursosLink);
    }



}
