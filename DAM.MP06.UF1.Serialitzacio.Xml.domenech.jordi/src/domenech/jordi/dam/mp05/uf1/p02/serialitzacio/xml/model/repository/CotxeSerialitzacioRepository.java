package domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.domain.Cotxe;

public class CotxeSerialitzacioRepository {

    private CotxeSerialitzacioRepository() {

        serialitzador = CommonSerialitzacioXmlRepository.getInstance(); 
    }

    public static CotxeSerialitzacioRepository getInstance() {
        if (instance == null) {
            instance = new CotxeSerialitzacioRepository();
        }

        return instance;
    }

    private static CotxeSerialitzacioRepository instance = null;

    private CommonSerialitzacioXmlRepository serialitzador;

    public void serialitzaUnCotxe(Cotxe cotxe, String nomFitxer) throws IOException {
        serialitzador.serialitza(cotxe, nomFitxer);
    }

    public Cotxe deserialitzaUnCotxe(String nomFitxer) throws IOException, ClassNotFoundException {

        Cotxe resultat = null;
        Object object = serialitzador.deserialitza(nomFitxer);
        if (object != null && object instanceof Cotxe) {
            resultat = (Cotxe) object;
        }
        return resultat;

    }

    public void serialitzaLlistaCotxes(List<Cotxe> cotxes, String nomFitxer) throws IOException {

        Cotxe[] arrayCotxes = null;
        if (cotxes != null && cotxes.size() > 0) {
            arrayCotxes = new Cotxe[cotxes.size()];
            int count = 0;
            for(Cotxe c : cotxes) {
                arrayCotxes[count] = c;
                count++;
            }
        }
        serialitzador.serialitza(arrayCotxes, nomFitxer);
    }

    public List<Cotxe> deserialitzaLlistaCotxes(String nomFitxer) throws IOException, ClassNotFoundException {

        List<Cotxe> resultat = null;
        Cotxe[] arrayCotxes = null;
        Object object = serialitzador.deserialitza(nomFitxer);
        if (object != null && object.getClass().isArray()) {
            Object[] arrayObjects = (Object[]) object;
            arrayCotxes = (Cotxe[]) arrayObjects;

            resultat = new ArrayList<Cotxe>(Arrays.asList(arrayCotxes));
        }
        return resultat;

    }
}
