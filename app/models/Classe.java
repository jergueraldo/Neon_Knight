package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;

@Entity
public class Classe extends Model {

    public Classe(String nome, EstiloDeCombate estilo) {
        this.nome = nome;
        this.estilo = estilo;
    }

    public String nome;

    @Enumerated(EnumType.STRING)
    public EstiloDeCombate estilo;

}