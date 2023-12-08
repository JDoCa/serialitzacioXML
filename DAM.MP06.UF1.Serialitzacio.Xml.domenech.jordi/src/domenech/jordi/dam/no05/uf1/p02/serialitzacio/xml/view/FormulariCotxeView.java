package domenech.jordi.dam.no05.uf1.p02.serialitzacio.xml.view;

import java.util.ArrayList;
import java.util.List;

import domenech.jordi.dam.mp05.uf1.p02.serialitzacio.xml.model.domain.Cotxe;

public class FormulariCotxeView {

    private FormulariCotxeView() {
        // Constructor privado
    }

    public static FormulariCotxeView getInstance() {
        if (instance == null) {
            instance = new FormulariCotxeView();
        }
        return instance;
    }

    private static FormulariCotxeView instance = null;

    public List<Cotxe> getCotxes() {
        List<Cotxe> resultat = new ArrayList<Cotxe>();
        System.out.println(" --------------------------------- Primer Cotxe");
        Cotxe cotxe = getCotxe();
        resultat.add(cotxe);
        System.out.println(" --------------------------------- Segon Cotxe");
        cotxe = getCotxe();
        resultat.add(cotxe);
        return resultat;
    }

    public Cotxe getCotxe() {
        UtilitatsPeticioView utilitatsPeticioView = UtilitatsPeticioView.getInstance();
        String matricula = utilitatsPeticioView.getParaulaString("Introdueixi la matrícula:");
        String marca = utilitatsPeticioView.getParaulaString("Introdueixi la marca:");
        String model = utilitatsPeticioView.getParaulaString("Introdueixi el model:");
        String numeroBastidor = utilitatsPeticioView.getParaulaString("Introdueixi el número de bastidor:");

        Cotxe cotxe = new Cotxe(matricula, marca, model, numeroBastidor);
        System.out.println("Cotxe registrat: " + cotxe.toString());
        return cotxe;
    }
}

