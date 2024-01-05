package Jobs;

import models.Adm;
import models.Classe;
import models.Guilda;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

    @Override
    public void doJob() throws Exception {
        if (Usuario.count() == 0) {
            Usuario adm = new Usuario();
            adm.nome = "adm";
            adm.email = "adm@adm.com";
            adm.senha = "12345";
            adm.save();

            Usuario user1 = new Usuario();
            user1.nome = "user1";
            user1.email = "user1@user1.com";
            user1.senha = "12345";
            user1.classe = Classe.MAGE;
            user1.save();

            Usuario user2 = new Usuario();
            user2.nome = "user2";
            user2.email = "user2@user2.com";
            user2.senha = "12345";
            user2.classe = Classe.MAGE;
            user2.save();

            Usuario user3 = new Usuario();
            user3.nome = "user3";
            user3.email = "user3@user3.com";
            user3.senha = "12345";
            user3.classe = Classe.MAGE;
            user3.save();

            Usuario user4 = new Usuario();
            user4.nome = "user4";
            user4.email = "user4@user4.com";
            user4.senha = "12345";
            user4.classe = Classe.WARRIOR;
            user4.save();

            Usuario user5 = new Usuario();
            user5.nome = "user5";
            user5.email = "user5@user5.com";
            user5.senha = "12345";
            user5.classe = Classe.WARRIOR;
            user5.save();

            Usuario user6 = new Usuario();
            user6.nome = "user6";
            user6.email = "user6@user6.com";
            user6.senha = "12345";
            user6.classe = Classe.WARRIOR;
            user6.save();

            Usuario user7 = new Usuario();
            user7.nome = "user7";
            user7.email = "user7@user7.com";
            user7.senha = "12345";
            user7.classe = Classe.HEALER;
            user7.save();

            Usuario user8 = new Usuario();
            user8.nome = "user8";
            user8.email = "user8@user8.com";
            user8.senha = "12345";
            user8.classe = Classe.HEALER;
            user8.save();

            Usuario user9 = new Usuario();
            user9.nome = "user9";
            user9.email = "user9@user9.com";
            user9.senha = "12345";
            user9.classe = Classe.HEALER;
            user9.save();

            Guilda gui = new Guilda();
            gui.nome = "blue";
            gui.historia = "criada por sla quem bla bla bla para ser a guilda de magos";
            gui.lore = "sla";
            gui.matriz = "guilda especializada em combate magico";
            gui.save();

            Guilda gui2 = new Guilda();
            gui2.nome = "red";
            gui2.historia = "criada por sla quem bla bla bla para ser a guilda de guerreiros";
            gui2.lore = "sla";
            gui2.matriz = "Glória, duelos, honra, e sangue nos olhos";
            gui2.save();

            Guilda gui3 = new Guilda();
            gui3.nome = "yellow";
            gui3.historia = "criada por sla quem bla bla bla para ser a guilda de sacerdotes";
            gui3.lore = "sla";
            gui3.matriz = "A paz do senhor";
            gui3.save();
        }
    }
}
