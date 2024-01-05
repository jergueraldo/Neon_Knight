package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Guilda extends Model {
    @Required
    public String nome, historia, lore, matriz;


    @OneToMany(mappedBy = "guilda")
    public List<Usuario> usuarios;
}
