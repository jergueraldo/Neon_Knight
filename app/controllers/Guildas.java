package controllers;

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

    public static void detalhar(long id) {
        Guilda g = Guilda.findById(id);
        render(g);
    }

    public static void listar() {
        List<Guilda> lista = Guilda.findAll();
        render(lista);
    }

    public static void editar(long id) {
        Guilda g = Guilda.findById(id);
        renderTemplate("Guildas/form.html", g);
    }

    public static void remover(long id) {
        Guilda g = Guilda.findById(id);
        flash.success(g.nome + " removido com sucesso");
        g.delete();
        Application.home();

    }
}
