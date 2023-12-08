package domenech.jordi.dam.no05.uf1.p02.serialitzacio.xml.view;

public class UtilitatsSortidaView {
	private UtilitatsSortidaView() {
        // Constructor privado
    }

    public static UtilitatsSortidaView getInstance() {
        if (instance == null) {
            instance = new UtilitatsSortidaView();
        }
        return instance;
    }

    private static UtilitatsSortidaView instance = null;

    public void show(String missatge, boolean isError) {
        if (!isError) {
            System.out.println(missatge);
        } else {
            System.err.println(missatge);
        }
    }

}
