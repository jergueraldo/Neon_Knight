package Jobs;

import javax.validation.Valid;

import models.Adm;
import models.Guilda;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;


// Não sei por que parou de funcionar, tive que improvisar

@OnApplicationStart
public class Inicializador extends Job {

    public static void doJobs() throws Exception {
        if (Usuario.count() == 0) {
            Usuario adm = new Usuario();
            adm.nome = "adm";
            adm.email = "adm@adm.com";
            adm.senha = "12345";
            adm.save();
        }
        
        if (Guilda.count() == 0) {
            Guilda gui = new Guilda();
            gui.nome = "blue";
            gui.historia = "sla";
            gui.save();

            Guilda gui2 = new Guilda();
            gui2.nome = "red";
            gui2.historia = "sla2";
            gui2.save();

            Guilda gui3 = new Guilda();
            gui3.nome = "yellow";
            gui3.historia = "sla3";
            gui3.save();

        }
    }
}
