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

    private static void criarTeste() {
        if (Usuario.count() == 0) {
            Usuario adm = new Usuario();
            adm.nome = "adm";
            adm.email = "adm@adm.com";
            adm.senha = "12345";
            adm.save();
        }

        if (Guilda.count() == 0) {
            Guilda gui = new Guilda();
            gui.nome = "blue";
            gui.historia = "sla";
            gui.save();

            Guilda gui2 = new Guilda();
            gui2.nome = "red";
            gui2.historia = "sla2";
            gui2.save();

            Guilda gui3 = new Guilda();
            gui3.nome = "yellow";
            gui3.historia = "sla3";
            gui3.save();

        }

        Usuarios.home();
    }

    public static void login(String email, String senha) {
        Usuario user = Usuario.find("email = ?1 and senha = ?2", email, senha).first();

        if (user == null && email.equals("adm@adm") && senha.equals("adm")) {
            flash.success("Deu certo");
            criarTeste();
        } else if (user == null || user.status == Status.INATIVO) {
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
