package Interacciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Interacciones.CantidadvecesInteraction.extraerNumeros;
import static Interfaces.RetoBancolombiaPage.*;

public class FormulariofechasInteraction implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String numero_veces = Fecha_dias.resolveFor(actor).getText();
        int Numeros = Integer.parseInt(extraerPrimerosNumeros(numero_veces));
        LocalDate fechaActual = LocalDate.now().plusDays(Numeros);
        String formatoFecha = "dd/MM/yyyy";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatoFecha);
        String fechaComoString = fechaActual.format(dtf);
        actor.attemptsTo(Enter.theValue(fechaComoString).into(Campo_Fecha));

    }

    private static String extraerPrimerosNumeros(String cadena) {
        // Utilizar una expresión regular para extraer los primeros números
        String regex = "^\\D*(\\d+).*";
        return cadena.replaceAll(regex, "$1");
    }

    public static FormulariofechasInteraction datos() {
        return new FormulariofechasInteraction();
    }
}
