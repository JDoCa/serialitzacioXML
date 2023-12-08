package domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.controllers;

import java.io.IOException;
import java.util.List;

import domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.domain.Cotxe;
import domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.service.CotxeSerialitzacioService;
import domenech.jordi.dam.no05.uf1.p02.serialitzacio.xml.view.FormulariCotxeView;
import domenech.jordi.dam.no05.uf1.p02.serialitzacio.xml.view.UtilitatsSortidaView;

public class CotxeSerialitzacioController {

    private CotxeSerialitzacioController() {
        // Constructor privado
    }

    public static CotxeSerialitzacioController getInstance() {
        if (instance == null) {
            instance = new CotxeSerialitzacioController();
        }
        return instance;
    }

    private static CotxeSerialitzacioController instance = null;

    FormulariCotxeView formulariCotxeView = FormulariCotxeView.getInstance();
    CotxeSerialitzacioService service = CotxeSerialitzacioService.getInstance();
    UtilitatsSortidaView utilitatsSortidaView = UtilitatsSortidaView.getInstance();

    public void serialitzaUnCotxe() {
        try {
            titol("Serialitza un cotxe");
            Cotxe cotxe = formulariCotxeView.getCotxe();
            service.serialitzaUnCotxe(cotxe);
            utilitatsSortidaView.show("Cotxe serialitzat correctament", false);
        } catch (IOException e) {
            utilitatsSortidaView.show(e.getMessage(), true);
        }
    }

    public void serialitzaLlistaCotxes() {
        try {
            titol("Serialitza una llista de cotxes");
            List<Cotxe> cotxes = formulariCotxeView.getCotxes();
            service.serialitzaLlistaCotxes(cotxes);
            utilitatsSortidaView.show("Llista Cotxes serialitzada correctament", false);
        } catch (IOException e) {
            utilitatsSortidaView.show(e.getMessage(), true);
        }
    }

    public void deserialitzaUnCotxe() {
        try {
            titol("Deserialitza un cotxe");
            Cotxe cotxe = service.deserialitzaUnCotxe();
            utilitatsSortidaView.show(cotxe.toString(), false);
        } catch (IOException | ClassNotFoundException e) {
            utilitatsSortidaView.show(e.getMessage(), true);
        }
    }

    public void deserialitzaLlistaCotxes() {
        try {
            titol("Deserialitza una llista de cotxes");
            List<Cotxe> cotxes = service.deserialitzaLlistaCotxes();
            utilitatsSortidaView.show(cotxes.toString(), false);
        } catch (IOException | ClassNotFoundException e) {
            utilitatsSortidaView.show(e.getMessage(), true);
        }
    }

    private void titol(String accio) {
        utilitatsSortidaView.show("===========================", true);
        utilitatsSortidaView.show("Serialitzar/Deserialitzar - XML - " + accio, true);
        utilitatsSortidaView.show("===========================", true);
    }
}

