package controllers;

import models.Guilda;
import models.Status;
import models.Usuario;
import play.cache.Cache;
import play.mvc.Controller;

public class Logins extends Controller {

    public static void form() {
        render();
    }

    public static void login(String email, String senha) {
        Usuario user = Usuario.find("email = ?1 and senha = ?2 and status =?3", email, senha, Status.ATIVO).first();

        if (user == null) {
            flash.error("Email e/ou senha incorreto(s)");
            form();
        }

        session.put("user", user.id);
        flash.success("Bem vindo " + user.nome);
        Usuarios.home();
    }

    public static void logout() {

        if (!session.contains("user")) {
            flash.put("warning", "Nínguem logado");
        } else {
            flash.put("info", "Usuário deslogado");
        }

        session.clear();
        form();
    }

}
