package controllers;

import java.util.Arrays;
import java.util.List;

import models.Classe;
import models.EstiloDeCombate;
import models.Guilda;
import models.Status;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Logins extends Controller {

    public static void listaClasses(String estilo) {
        List<Classe> classes = Classe.find("estilo = ?1", EstiloDeCombate.valueOf(estilo)).fetch();
        renderJSON(classes);
    }

    public static void form() {
        Usuario u = (Usuario) Cache.get("user");
        Cache.clear();

        List<EstiloDeCombate> estilos = Arrays.asList(EstiloDeCombate.values());

        render(u, estilos);
    }

    public static void salvar(@Valid Usuario u) {

        if (validation.hasErrors()) {
            validation.keep();
            flash.error("Falha ao salvar");
            Cache.set("user", u);
            form();
        }

        u.save();
        flash.success("Salvo com sucesso");
        Logins.logout();
    }

    public static void login(String email, String senha) {
        Usuario user = Usuario.find("email = ?1 and senha = ?2", email, senha).first();

        if (user == null || user.status == Status.INATIVO) {
            flash.error("Senha e/ou email incorreto(s)");
            form();
        }

        session.put("userName", user.nome);
        flash.success("Bem vindo " + user.nome);
        Usuarios.home();
    }

    public static void logout() {

        if (session.contains("userName")) {
            flash.success(session.get("userName") + " delosgou");
        }

        session.clear();
        form();
    }

}
