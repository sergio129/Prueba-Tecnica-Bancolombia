package Tareas;


import Interacciones.LoginInteraccion;
import Modelos.LoginModel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

@AllArgsConstructor
public class LoginTask implements Task {
    private final LoginModel user;



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(LoginInteraccion.login(user));
    }

    public static LoginTask login(LoginModel user) {
        return new LoginTask(user);
    }
}
