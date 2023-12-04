package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {

    @Required
    public String nome, senha, email;

    @ManyToOne
    public Guilda guilda;

    @Enumerated(EnumType.STRING)
    public Status status;

    public Usuario() {
        this.status = Status.ATIVO;
    }

}
