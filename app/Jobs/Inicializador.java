package Jobs;

import javax.validation.Valid;

import models.Guilda;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

    public void doJob() throws Exception {
        if (Guilda.count() == 0) {
            Guilda gui = new Guilda();
            gui.nome = "Blue";
            gui.historia = "Alguma coisa";
            gui.save();

            Guilda gui2 = new Guilda();
            gui2.nome = "Red";
            gui2.historia = "Alguma coisa";
            gui2.save();

            Guilda gui3 = new Guilda();
            gui3.nome = "Yellow";
            gui3.historia = "Alguma coisa";
            gui3.save();

        }
    }
}
