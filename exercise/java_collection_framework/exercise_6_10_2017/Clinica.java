import java.util.*;

public class Clinica {

    private Map<String, Specialista> prenotazioni;

    public Clinica() {
        prenotazioni = new HashMap<>();
    }

    public void prenota(Specialista specialista, String paziente) {
        if (!prenotazioni.containsKey(paziente)) {
            prenotazioni.put(paziente, specialista);
        }
    }

    public void cancellaPrenotazione(Specialista specialista, String paziente) {
        prenotazioni.remove(paziente);
    }

    public List<String> getPrenotati(Specialista specialista) {
        List<String> res = new ArrayList<>();
        for (String s : prenotazioni.keySet()) {
            if (prenotazioni.get(s) == specialista) {
                res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Clinica c = new Clinica();
        c.prenota(Specialista.OCULISTA, "Pippo Franco");
        c.prenota(Specialista.OCULISTA, "Leo Gullotta");
        c.prenota(Specialista.OCULISTA, "Leo Gullotta");
        c.prenota(Specialista.PEDIATRA, "Ciccio Ingrassia");
        c.prenota(Specialista.PEDIATRA, "Leo Gullotta");
        c.cancellaPrenotazione(Specialista.PEDIATRA, "Ciccio Ingrassia");
        Collection<String> ocu = c.getPrenotati(Specialista.OCULISTA);
        System.out.println(ocu);
        System.out.println(c.getPrenotati(Specialista.PEDIATRA));
    }

}
