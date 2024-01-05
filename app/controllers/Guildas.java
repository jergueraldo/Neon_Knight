package controllers;

import java.util.Collections;
import java.util.List;

import models.Guilda;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Guildas extends Controller {

    public static void form() {
        Guilda g = (Guilda) Cache.get("guilda");
        Cache.clear();
        render(g);
    }

    public static void salvar(@Valid Guilda g) {

        if (validation.hasErrors()) {
            validation.keep();
            flash.error("Falha ao salvar");
            Cache.set("guilda", g);
            form();
        }

        g.save();
        flash.success(g.nome + " salva com sucesso");
        Usuarios.form();
    }

    public static void entrarNaGuilda(long id) {
        Guilda g = Guilda.findById(id);
        Usuario u = Usuario.find("nome = ?1", session.get("userName")).first();

        if (u.guilda != null) {
            flash.error("você já possuí uma guilda, acesse editar na aba de perfil para sair da guilda");
            Usuarios.ficha();
        }

        u.guilda = g;
        g.usuarios.add(u);

        g.save();
        u.save();

        session.put("userGuilda", g.nome);
        flash.success("Bem vindo(a) a " + g.nome);

        Usuarios.ficha();
    }

    public static void sairDaGuilda(long id) {
        Usuario u = Usuario.find("nome = ?1", session.get("userName")).first();
        Guilda g = Guilda.findById(id);

        u.guilda = null;
        g.usuarios.remove(u);

        g.save();
        u.save();

        Usuarios.ficha();
    }

    public static void detalhar(long id) {
        Guilda g = Guilda.findById(id);
        render(g);
    }

    public static void listar() {
        List<Guilda> guildas = Guilda.findAll();
        render(guildas);
    }

    public static void editar(long id) {
        Guilda g = Guilda.findById(id);
        renderTemplate("Guildas/form.html", g);
    }

    public static void remover(long id) {
        Guilda g = Guilda.findById(id);
        flash.success(g.nome + " removido com sucesso");
        g.delete();
        Usuarios.home();

    }
}
