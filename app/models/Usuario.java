package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
    private static String password = "adm123";

    @Required
    public String nome, senha, email;

    @ManyToOne
    public Guilda guilda;

    @Enumerated(EnumType.STRING)
    public Status status;

    @Enumerated(EnumType.STRING)
    public Cargo cargo;

    public Usuario() {
        this.status = Status.ATIVO;
        this.cargo = Cargo.USUARIO;
    }

    public boolean elevarParaAdm(String senha) {
        if (senha.equals(password)) {
            this.cargo = Cargo.ADMINISTRADOR;
            return true;
        }
        return false;
    }

}
