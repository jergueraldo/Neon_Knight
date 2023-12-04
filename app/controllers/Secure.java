package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Secure extends Controller {

    @Before  
    static void isLogado() {
        if (!session.contains("userName")) {
            flash.error("Realize login");
            Logins.form();
        }
    }
}
