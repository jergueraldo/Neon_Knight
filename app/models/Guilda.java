package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Guilda extends Model {
    @Required
    public String nome, historia, emblema;
}
