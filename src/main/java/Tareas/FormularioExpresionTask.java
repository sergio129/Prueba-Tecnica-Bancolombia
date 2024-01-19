package Tareas;

import Interacciones.FormularioExpresioninteraccion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static Interfaces.RetoBancolombiaPage.Resultado_operacion_matematica;
import static Interfaces.RetoBancolombiaPage.operacion_matematica;


public class FormularioExpresionTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(FormularioExpresioninteraccion.datos());

    }

    public static FormularioExpresionTask datos() {
        return new FormularioExpresionTask();
    }
}
