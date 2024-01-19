package Tareas;

import Interacciones.CantidadvecesInteraction;
import Interacciones.FormularioExpresioninteraccion;
import Interacciones.FormularioImagenesInteration;
import Interacciones.FormulariofechasInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CiclosEjecucionTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i <= 10; i++) {
            actor.attemptsTo(
                    CantidadvecesInteraction.data(), FormularioExpresioninteraccion.datos(), FormulariofechasInteraction.datos(), FormularioImagenesInteration.datos()
            );
        }
    }

    public static CiclosEjecucionTask datos() {
        return new CiclosEjecucionTask();
    }
}
