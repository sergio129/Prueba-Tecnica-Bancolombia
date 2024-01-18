package Stepsdefinitions;

import Modelos.LoginModel;
import Modelos.UrlModel;
import Tareas.LoginTask;
import Utilidades.Leerdatos;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.chrome.ChromeDriver;

import static Interfaces.RetoBancolombiaPage.Campo_letras;

public class RetoStepdefs {
    @Managed(driver = "chrome")
    private ChromeDriver driver;
    private final Actor actor = Actor.named("Usuario");

    @Before
    public void setUp() {
        actor.can(BrowseTheWeb.with(driver));
    }


    @Given("Nos logeamos en evalartapp")
    public void nosLogeamosEnEvalartapp() {
        UrlModel url = Leerdatos.datosUrl();
        LoginModel model = Leerdatos.datosLogin();
        actor.wasAbleTo(Open.relativeUrl(url.getUrl()));
        actor.attemptsTo(LoginTask.login(model));
    }

    @When("Escribimos la cantidad de veces: {int} letra: {string}")
    public void escribimosLaCantidadDeVecesLetra(int arg0, String arg1) {
        for (int i = 0; i <= arg0; i++) {
            actor.attemptsTo(
                    Enter.keyValues(arg1).into(Campo_letras)
            );
        }
    }

}
