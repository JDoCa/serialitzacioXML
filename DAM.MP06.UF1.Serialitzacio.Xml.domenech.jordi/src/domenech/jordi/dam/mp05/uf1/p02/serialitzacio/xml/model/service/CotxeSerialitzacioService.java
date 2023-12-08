package domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.service;

import java.io.IOException;
import java.util.List;

import domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.configuration.Settings;
import domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.domain.Cotxe;
import domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.repository.CotxeSerialitzacioRepository;

public class CotxeSerialitzacioService {

    private CotxeSerialitzacioService() {
       
    }

    public static CotxeSerialitzacioService getInstance() {
        if (instance == null) {
            instance = new CotxeSerialitzacioService();
        }
        return instance;
    }

    private static CotxeSerialitzacioService instance = null;

    public void serialitzaUnCotxe(Cotxe cotxe) throws IOException {
        CotxeSerialitzacioRepository rep = CotxeSerialitzacioRepository.getInstance();
        rep.serialitzaUnCotxe(cotxe, Settings.FITXER_COTXE_INDIVIDUAL);
    }

    public void serialitzaLlistaCotxes(List<Cotxe> cotxes) throws IOException {
        CotxeSerialitzacioRepository rep = CotxeSerialitzacioRepository.getInstance();
        rep.serialitzaLlistaCotxes(cotxes, Settings.FITXER_LLISTA_COTXES);
    }

    public Cotxe deserialitzaUnCotxe() throws IOException, ClassNotFoundException {
        CotxeSerialitzacioRepository rep = CotxeSerialitzacioRepository.getInstance();
        return rep.deserialitzaUnCotxe(Settings.FITXER_COTXE_INDIVIDUAL);
    }

    public List<Cotxe> deserialitzaLlistaCotxes() throws IOException, ClassNotFoundException {
        CotxeSerialitzacioRepository rep = CotxeSerialitzacioRepository.getInstance();
        return rep.deserialitzaLlistaCotxes(Settings.FITXER_LLISTA_COTXES);
    }
}

