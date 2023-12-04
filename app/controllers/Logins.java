package controllers;

import models.Status;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Logins extends Controller {

    public static void form() {
        render();
    }

    public static void login(String email, String senha) {
        Usuario user = Usuario.find("email = ?1 and senha = ?2", email, senha).first();

        if (user == null || user.status == Status.INATIVO) {
            flash.error("Senha e/ou email incorreto(s)");
            form();
        }

        session.put("userName", user.nome);
        session.put("userEmail", user.email);
        session.put("user", user);

        flash.success("Bem vindo " + user.nome);
        Usuarios.home();
    }

    public static void logout() {

        if (!session.contains("user")) {
            flash.error("Nínguem logado");
        } else {
            flash.success(session.get("userName") + " delosgou");
        }

        session.clear();
        form();
    }

}
