package Interacciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static Interfaces.RetoBancolombiaPage.Resultado_operacion_matematica;
import static Interfaces.RetoBancolombiaPage.operacion_matematica;


public class FormularioExpresioninteraccion implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
       String operacion1 = operacion_matematica.resolveFor(actor).getText();
        String expresion = operacion1.replaceAll("=\\?", "");

        int resultado = 0;
        try {
            resultado = (int) evaluarExpresion(expresion);
       } catch (ScriptException e) {
          throw new RuntimeException(e);
       }

        actor.attemptsTo(Click.on(Resultado_operacion_matematica.of(String.valueOf(resultado))));
    }

    private static double evaluarExpresion(String expresion) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Evaluar la expresión y devolver el resultado como un número
        return ((Number) engine.eval(expresion)).doubleValue();
    }

    public static FormularioExpresioninteraccion datos() {
        return new FormularioExpresioninteraccion();
    }
}
