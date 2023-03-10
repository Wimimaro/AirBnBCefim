package zender.airbnb.outils;

import org.xml.sax.SAXException;
import zender.airbnb.logements.Logement;
import zender.airbnb.utilisateurs.Hote;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class AirBnBData {

    private static AirBnBData instance = new AirBnBData();

    private ArrayList<Logement> logements;
    private ArrayList<Hote> hotes;

    private AirBnBData() {

        logements = new ArrayList<>();
        hotes  = new ArrayList<>();

        try {
            LogementsDomParser.parse("logements.xml", hotes, logements);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static AirBnBData getInstance() {
        return instance;
    }

    public ArrayList<Logement> getLogements() {
        return logements;
    }

    public ArrayList<Hote> getHotes() {
        return hotes;
    }
}
