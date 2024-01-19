package Interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RetoBancolombiaPage {
    public static final Target campo_usuario = Target.the("Campo para escribir el usuario").located(By.name("username"));
    public static final Target campo_contrasena = Target.the("Campo para escribir contraseña").located(By.name("password"));
    public static final Target boton_enviar = Target.the("Boton para inicir sesion").located(By.xpath("*//div/div[2]/form/button"));
    public static final Target Campo_letras = Target.the("campo para escribir el numero de letras").located(By.name("text"));
    public static final Target operacion_matematica = Target.the("texto de la operacion matematica").located(By.xpath("*//div[2]/form/div[1]/div[3]/p[2]"));
    public static final Target Resultado_operacion_matematica = Target.the("texto de la operacion matematica").locatedBy("//input[@type='radio'][@name='radio'][@value='{0}']");
    public static final Target Campo_Fecha = Target.the("campo para escribir nueva fecha").located(By.name("date"));
    public static final Target Numero_veces = Target.the("numero de veces de una letra").located(By.xpath("/html/body/div[2]/form/div[1]/div[1]/p"));


}
