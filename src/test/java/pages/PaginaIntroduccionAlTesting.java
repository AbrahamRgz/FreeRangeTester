package pages;

public class PaginaIntroduccionAlTesting extends BasePage{

    private String ComprarCurso="//a[@class='sc-dJkDXt fodGEh']";

    public PaginaIntroduccionAlTesting(){
        super(driver);
    }

    public void BuyCourseTesting(){
        ClickElmento(ComprarCurso);
    }


}
