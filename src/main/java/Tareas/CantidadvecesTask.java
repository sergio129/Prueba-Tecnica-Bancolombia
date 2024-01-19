package Tareas;

import Interacciones.CantidadvecesInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class CantidadvecesTask implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(CantidadvecesInteraction.data());
    }



    public static CantidadvecesTask data() {
        return new CantidadvecesTask();
    }
}
