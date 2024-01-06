package controllers;

import java.util.Arrays;
import java.util.List;

import models.EstiloDeCombate;
import models.Guilda;
import models.Status;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Usuarios extends Controller {

    public static void home() {
        render();
    }

    public static void ficha() {
        Usuario u = Usuario.find("nome = ?1", session.get("userName")).first();
        render(u);
    }

    public static void detalhar(long id) {
        Usuario u = Usuario.findById(id);
        render(u);
    }

    public static void editar(long id) {
        Usuario u = Usuario.findById(id);
        List<EstiloDeCombate> estilos = Arrays.asList(EstiloDeCombate.values());
        renderTemplate("Logins/form.html", u, estilos);
    }

    public static void remover(long id) {
        Usuario u = Usuario.findById(id);
        flash.success("Removido com sucesso");
        u.status = Status.INATIVO;
        u.save();
        Logins.logout();
    }
}
