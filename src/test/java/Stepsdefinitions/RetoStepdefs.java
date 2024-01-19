package Stepsdefinitions;

import Interacciones.CantidadvecesInteraction;
import Interacciones.FormularioExpresioninteraccion;
import Modelos.LoginModel;
import Modelos.UrlModel;
import Tareas.FormularioExpresionTask;
import Tareas.LoginTask;
import Utilidades.Leerdatos;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static Interfaces.RetoBancolombiaPage.Campo_Fecha;
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

    @And("Completamos operacion matematica")
    public void completamosOperacionMatematica() {
        actor.attemptsTo(FormularioExpresionTask.datos());

    }

    @And("Completamos el formulario de fecha")
    public void completamosElFormularioDeFecha() throws InterruptedException {
        LocalDate fechaActual = LocalDate.now().plusDays(25);
        String formatoFecha = "dd/MM/yyyy";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatoFecha);
        String fechaComoString = fechaActual.format(dtf);
        actor.attemptsTo(Enter.theValue(fechaComoString).into(Campo_Fecha));
        Thread.sleep(5000);
    }

    @When("Escribimos la cantidad de veces la letras estraidas")
    public void escribimosLaCantidadDeVecesLaLetrasEstraidas() {
        actor.attemptsTo(CantidadvecesInteraction.data());
    }
}
