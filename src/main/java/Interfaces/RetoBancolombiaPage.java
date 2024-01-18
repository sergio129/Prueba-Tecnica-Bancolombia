package Interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RetoBancolombiaPage {
    public static final Target campo_usuario = Target.the("Campo para escribir el usuario").located(By.name("username"));
    public static final Target campo_contrasena = Target.the("Campo para escribir contraseña").located(By.name("password"));
    public static final Target boton_enviar = Target.the("Boton para inicir sesion").located(By.xpath("*//div/div[2]/form/button"));

}
