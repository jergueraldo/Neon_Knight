package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Secure extends Controller {

    @Before(unless = {"Usuarios.form", "Usuarios.salvar"})  
    static void isLogado() {
        if (!session.contains("user")) {
            flash.put("warning","É necessário ter feito login");
            Logins.form();
        }
    }
}
