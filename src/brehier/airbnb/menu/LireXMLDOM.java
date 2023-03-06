package brehier.airbnb.menu;

import brehier.airbnb.logement.Appartement;
import brehier.airbnb.logement.Logement;
import brehier.airbnb.logement.Maison;
import brehier.airbnb.menu.Menu;
import brehier.airbnb.utilisateurs.Hote;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class LireXMLDOM {
    public static void read() {
       try{
           File inputFile = new File("logements.xml");
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(inputFile);
           doc.getDocumentElement().normalize();
           System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
           NodeList nList = doc.getElementsByTagName("Logements");
           System.out.println("----------------------------");


           Node nNode = nList.item(0);
//           System.out.println("Logement : " + nNode.getNodeName());

           if(nNode.getNodeType() == Node.ELEMENT_NODE) {
               //Element eElement = (Element) nNode;
               NodeList listeLogements = nList.item(0).getChildNodes();

               for (int i = 0; i < listeLogements.getLength(); i++) {
                   Node logement = listeLogements.item(i);
                   if (logement.getNodeType() == Node.ELEMENT_NODE) {
                       Element eLogement = (Element) logement;
                       NodeList listeHotes = eLogement.getElementsByTagName("hote");
                       Node nHote = listeHotes.item(0);
                       Element eHote = (Element) nHote;
                       Hote hote = null;
                       //System.out.println("adresse : " + eLogement.getElementsByTagName("adresse").item(0).getTextContent());

                       for(int j = 0; j < listeHotes.getLength(); j++) {
//                           System.out.println("hote : " + eHote.getElementsByTagName("nom").item(j).getTextContent());
                           String nom = eHote.getElementsByTagName("nom").item(j).getTextContent();
                           String prenom = eHote.getElementsByTagName("prenom").item(j).getTextContent();
                           int age = Integer.parseInt(eHote.getElementsByTagName("age").item(j).getTextContent());
                           int delaiReponse = Integer.parseInt(eHote.getElementsByTagName("delaiReponse").item(j).getTextContent());

                           hote = new Hote(nom, prenom, age, delaiReponse);
                           if (!alreadyExist(hote)) {
                               Menu.listHotes.add(hote);
                           } else {
                               System.out.println(prenom + " " + nom + " existe déjà.");
                           }
                           //ArrayList listHotes = new ArrayList<Hote>();
                           //Menu.listHotes.add(hote);
                       }

                      int tarifParNuit = Integer.parseInt(eLogement.getElementsByTagName("tarifParNuit").item(0).getTextContent());
                      int superficie = Integer.parseInt(eLogement.getElementsByTagName("superficie").item(0).getTextContent());
                      int nbVoyageursMax = Integer.parseInt(eLogement.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());
                      String name = eLogement.getAttribute("name");
                      String adresse = eLogement.getElementsByTagName("adresse").item(0).getTextContent();
                      Logement objectLogement = null;


                      if (eLogement.getNodeName().equals("Appartement")) {
                        int numeroEtage = Integer.parseInt(eLogement.getElementsByTagName("numeroEtage").item(0).getTextContent());
                        int superficieBalcon = Integer.parseInt(eLogement.getElementsByTagName("superficieBalcon").item(0).getTextContent());
                        objectLogement = new Appartement(name, hote,tarifParNuit, adresse,superficie, nbVoyageursMax, numeroEtage, superficieBalcon);

                      } else if (eLogement.getNodeName().equals("Maison")) {
                        int superficieJardin = Integer.parseInt(eLogement.getElementsByTagName("superficieJardin").item(0).getTextContent());
                        boolean possedePiscine = Boolean.parseBoolean(eLogement.getElementsByTagName("possedePiscine").item(0).getTextContent());
                        objectLogement = new Maison(name, hote,tarifParNuit, adresse,superficie, nbVoyageursMax, superficieJardin, possedePiscine);
                      }
                      if(objectLogement != null) {
                          ArrayList listLogements = new ArrayList<Logement>();
                          Menu.listLogements.add(objectLogement);
                      }
                   }
               }
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    private static boolean alreadyExist(Hote hote1) {
        for (int i=0;i<Menu.listHotes.size();i++) {
            Hote hote2 = Menu.listHotes.get(i);
            if (hote1.equals(hote2)) {
                return true;
            }
        }
        return false;
    }
}
