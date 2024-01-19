package Interacciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static Interfaces.RetoBancolombiaPage.Boton_enviar;
import static Interfaces.RetoBancolombiaPage.Campo_imagenes;

public class FormularioImagenesInteration implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue("17").into(Campo_imagenes), Click.on(Boton_enviar));

    }

    public static FormularioImagenesInteration datos() {
        return new FormularioImagenesInteration();
    }
}
