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
        String expresion = numero_veces.replaceAll("\"", "");
        if (!expresion.isEmpty()) {
            // Obtener la longitud de la cadena
            int longitud = expresion.length();
            // Obtener la última letra utilizando el método charAt
            String ultimaLetra = String.valueOf(expresion.charAt(longitud - 1));

            for (int i = 0; i <= numerosExtraidos; i++) {
                actor.attemptsTo(
                        Enter.keyValues(ultimaLetra).into(Campo_letras)
                );
            }
        }
    }

    public static String extraerNumeros(String cadena) {
        // Utilizar expresiones regulares para extraer los números
        return cadena.replaceAll("[^0-9]", "");
    }

    public static CantidadvecesInteraction data() {
        return new CantidadvecesInteraction();
    }
}
