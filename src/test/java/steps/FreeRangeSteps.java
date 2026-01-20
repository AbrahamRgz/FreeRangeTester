package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PaginaCursos;
import pages.PaginaIntroduccionAlTesting;
import pages.PaginaPricipal;
import pages.PaginaRecursos;

import java.util.Arrays;
import java.util.List;

public class FreeRangeSteps {

    PaginaPricipal landinPage = new PaginaPricipal();
    PaginaCursos CursosPage = new PaginaCursos();
    PaginaIntroduccionAlTesting PageTesting = new PaginaIntroduccionAlTesting();
    PaginaRecursos pageResourses = new PaginaRecursos();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateFreeRange(){
        landinPage.navigeteFreRantester();
    }

    @When("I go to a {word} using the navigation bar")
    public void navigationBarUse(String section){
        landinPage.clickOnSectionLink(section);
    }

    @When("I go to Cursos using the navigation bar")
    public void navigateToCursos(){
        landinPage.GoToCursos();

    }

    @When("I go to Recursos using the navigation bar")
    public void NavigateToRecursos(){
        landinPage.GoToRecursos();
        pageResourses.AutomationSandbox();
    }

    @And("select Fundamentos del Testing")
    public void PaginaTesting(){
    CursosPage.FundamentosTesting();
    PageTesting.BuyCourseTesting();
    }

    @Then("select Automation Sandbox and validate dropdown")
    public void ValidateDeportesOptions() throws InterruptedException {
        List<String> lista = pageResourses.returnDeportesDropdawnValues();
        List<String> listaEsperada = Arrays.asList("Seleccioná un deporte",
                "Fútbol","Tennis","Basketball");

        Assert.assertEquals(listaEsperada,lista);

    }
}
