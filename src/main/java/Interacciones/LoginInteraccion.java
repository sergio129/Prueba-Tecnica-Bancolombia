package Interacciones;

import Modelos.LoginModel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;

import static Interfaces.RetoBancolombiaPage.*;

@AllArgsConstructor
public class LoginInteraccion implements Interaction {
    private final LoginModel user;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getUsuario()).into(campo_usuario),
                Enter.theValue(user.getContrasena()).into(campo_contrasena),
                Click.on(boton_enviar)
        );

    }
    public static LoginInteraccion login(LoginModel user){
        return new LoginInteraccion(user);
    }
}
