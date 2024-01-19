package Interacciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static Interfaces.RetoBancolombiaPage.*;

public class CantidadvecesInteraction implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String numero_veces = Numero_veces.resolveFor(actor).getText();
        int numerosExtraidos = Integer.parseInt(extraerNumeros(numero_veces));

        for (int i = 0; i <= numerosExtraidos; i++) {
            actor.attemptsTo(
                    Enter.keyValues("e").into(Campo_letras)
            );
        }
    }

    private static String extraerNumeros(String cadena) {
        // Utilizar expresiones regulares para extraer los números
        return cadena.replaceAll("[^0-9]", "");
    }

    public static CantidadvecesInteraction data() {
        return new CantidadvecesInteraction();
    }
}
