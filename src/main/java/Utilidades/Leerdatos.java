package Utilidades;

import Modelos.LoginModel;
import Modelos.UrlModel;

import java.util.ResourceBundle;

public class Leerdatos {
    public static ResourceBundle resourceBundle() {
        if (System.getProperty("env") != null) {
            return ResourceBundle.getBundle(System.getProperty("env"));
        } else {
            return ResourceBundle.getBundle("Datos_pruebas.Datos");
        }
    }

    public static String getTestLeerDatos(String llave) {
        return resourceBundle().getString(llave);
    }

    public static UrlModel datosUrl() {
        UrlModel model = new UrlModel();
        model.setUrl(Leerdatos.getTestLeerDatos("user.url"));
        return model;
    }

    public static LoginModel datosLogin() {
        LoginModel modelogin = new LoginModel();
        modelogin.setUsuario(Leerdatos.getTestLeerDatos("user.name"));
        modelogin.setContrasena(Leerdatos.getTestLeerDatos("user.password"));
        return modelogin;
    }

}
