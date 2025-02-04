package controllers;

import java.util.List;

import models.Cargo;
import models.Guilda;
import models.Status;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Usuarios extends Controller {

    public static void form() {
        Usuario u = (Usuario) Cache.get("user");
        Cache.clear();

        List<Guilda> guildas = Guilda.findAll();
        render(u, guildas);
    }

    public static void home() {
        render();
    }

    public static void ficha() {
        render();
    }

    public static void salvar(@Valid Usuario u) {

        if (Validation.hasErrors()) {
            Validation.keep();
            flash.error("Falha no cadastro. Por favor, verefique tudo com cuidado");
            Cache.set("user", u);
            form();
        }

        u.save();
        flash.success("Cadastrado com sucesso");
        home();
    }

    public static void detalhar(long id) {
        Usuario u = Usuario.findById(id);
        render(u);
    }

    public static void listar() {
        List<Usuario> lista = Usuario.find("status <> ?1",
                Status.INATIVO).fetch();

        render(lista);
    }

    public static void elevarParaAdm(String senha) {
        if (!session.contains("user")) {
            flash.put("warning", "Login necessário!");
            ficha();
        }
        Usuario u = Usuario.findById(session.get("user"));
        u.cargo = Cargo.ADMINISTRADOR;
        u.save();
        flash.success("Parabens, agora você é ADM");
        ficha();
    }

    public static void editar(long id) {
        Usuario u = Usuario.findById(id);
        renderTemplate("Usuarios/form.html", u);
    }

    public static void remover(long id) {
        Usuario u = Usuario.findById(id);
        flash.success("Removido com sucesso");
        u.status = Status.INATIVO;
        u.save();
        Logins.logout();
    }
}
