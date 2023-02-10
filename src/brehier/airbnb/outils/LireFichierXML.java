package brehier.airbnb.outils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class LireFichierXML {

        public static void main(String[] args) {
            try{
                //Obtenir la config du sax parser
                SAXParserFactory spfactory = SAXParserFactory.newInstance();
                //Obtenir une instance de l'objet parser
                SAXParser saxParser = spfactory.newSAXParser();

                //les 3 méthodes sont déclarées dans le corps du Default Handler
                DefaultHandler handler = new DefaultHandler(){

                    //Logement + Hote
                    boolean bhote = false;
                    boolean blogements = false;
                    boolean bappartements = false;
                    boolean bmaisons = false;
                    boolean bnom = false;
                    boolean bprenom = false;
                    boolean bage = false;
                    boolean bdelaiDeReponse = false;

                    //Logement
                    boolean btarifParNuit = false;
                    boolean badresse = false;
                    boolean bsuperficie = false;
                    boolean nbVoyageursMax = false;

                    //Logement + Appartement
                    boolean bnumeroEtage = false;
                    boolean bsuperficieBalcon = false;

                    //Logement + Maison
                    boolean bsuperficieJardin = false;
                    boolean bpossedePiscine = false;


                //cette méthode est invoquée à chaque fois que parser rencontre
                // une balise ouvrante '<'
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
                    if(qName.equalsIgnoreCase("nom")){
                        bnom = true;
                    }
                    if(qName.equalsIgnoreCase("prenom")){
                        bprenom = true;
                    }
                    if(qName.equalsIgnoreCase("age")){
                        bage = true;
                    }
                    if(qName.equalsIgnoreCase("delaiDeReponse")){
                        bdelaiDeReponse = true;
                    }
                    if(qName.equalsIgnoreCase("tarifParNuit")){
                        btarifParNuit = true;
                    }
                    if(qName.equalsIgnoreCase("adresse")){
                        badresse = true;
                    }
                    if(qName.equalsIgnoreCase("superficie")){
                        bsuperficie = true;
                    }
                    if(qName.equalsIgnoreCase("nbVoyageursMax")){
                        nbVoyageursMax = true;
                    }
                    if(qName.equalsIgnoreCase("numeroEtage")){
                        bnumeroEtage = true;
                    }
                    if(qName.equalsIgnoreCase("superficieBalcon")){
                        bsuperficieBalcon = true;
                    }
                    if(qName.equalsIgnoreCase("superficieJardin")){
                        bsuperficieJardin = true;
                    }
                    if(qName.equalsIgnoreCase("possedePiscine")){
                        bpossedePiscine = true;
                    }
                    if (qName.equalsIgnoreCase("hote")) {
                        bhote = true;
                    }
                    if (qName.equalsIgnoreCase("logements")) {
                        blogements = true;
                    }
                    if (qName.equalsIgnoreCase("appartements")) {
                        bappartements = true;
                    }
                    if (qName.equalsIgnoreCase("maisons")) {
                        bmaisons = true;
                    }
                }

                //cette méthode est invoquée à chaque fois que parser rencontre
                // une balise fermante '>'
                public void endElement(String uri, String localName, String qName) throws SAXException{
                    if(qName.equalsIgnoreCase("nom")){
                        bnom = false;
                    }
                    if(qName.equalsIgnoreCase("prenom")){
                        bprenom = false;
                    }
                    if(qName.equalsIgnoreCase("age")){
                        bage = false;
                    }
                    if(qName.equalsIgnoreCase("delaiDeReponse")){
                        bdelaiDeReponse = false;
                    }
                    if(qName.equalsIgnoreCase("tarifParNuit")){
                        btarifParNuit = false;
                    }
                    if(qName.equalsIgnoreCase("adresse")){
                        badresse = false;
                    }
                    if(qName.equalsIgnoreCase("superficie")){
                        bsuperficie = false;
                    }
                    if(qName.equalsIgnoreCase("nbVoyageursMax")){
                        nbVoyageursMax = false;
                    }
                    if(qName.equalsIgnoreCase("numeroEtage")){
                        bnumeroEtage = false;
                    }
                    if(qName.equalsIgnoreCase("superficieBalcon")){
                        bsuperficieBalcon = false;
                    }
                    if(qName.equalsIgnoreCase("superficieJardin")){
                        bsuperficieJardin = false;
                    }
                    if(qName.equalsIgnoreCase("possedePiscine")){
                        bpossedePiscine = false;
                    }
                    if (qName.equalsIgnoreCase("hote")) {
                        bhote = false;
                    }
                    if (qName.equalsIgnoreCase("logements")) {
                        blogements = false;
                    }
                    if (qName.equalsIgnoreCase("appartements")) {
                        bappartements = false;
                    }
                    if (qName.equalsIgnoreCase("maisons")) {
                        bmaisons = false;
                    }
                }

                //imprime les données entre chaque balise
                public void characters(char ch[], int start, int length) throws SAXException{
                    if(bnom){
                        System.out.println("Nom: " + new String(ch, start, length));
                        bnom = false;
                    }
                    if(bprenom){
                        System.out.println("Prenom: " + new String(ch, start, length));
                        bprenom = false;
                    }
                    if(bage){
                        System.out.println("Age: " + new String(ch, start, length));
                        bage = false;
                    }
                    if(bdelaiDeReponse){
                        System.out.println("Delai de reponse: " + new String(ch, start, length));
                        bdelaiDeReponse = false;
                    }
                    if(btarifParNuit){
                        System.out.println("Tarif par nuit: " + new String(ch, start, length));
                        btarifParNuit = false;
                    }
                    if(badresse){
                        System.out.println("Adresse: " + new String(ch, start, length));
                        badresse = false;
                    }
                    if(bsuperficie){
                        System.out.println("Superficie: " + new String(ch, start, length));
                        bsuperficie = false;
                    }
                    if(nbVoyageursMax){
                        System.out.println("Nombre de voyageurs max: " + new String(ch, start, length));
                        nbVoyageursMax = false;
                    }
                    if(bnumeroEtage){
                        System.out.println("Numero d'etage: " + new String(ch, start, length));
                        bnumeroEtage = false;
                    }
                    if(bsuperficieBalcon){
                        System.out.println("Superficie du balcon: " + new String(ch, start, length));
                        bsuperficieBalcon = false;
                    }
                    if(bsuperficieJardin){
                        System.out.println("Superficie du jardin: " + new String(ch, start, length));
                        bsuperficieJardin = false;
                    }
                    if(bpossedePiscine){
                        System.out.println("Possède piscine: " + new String(ch, start, length));
                        bpossedePiscine = false;
                    }
                    if (bhote) {
                        System.out.println("Hote: " + new String(ch, start, length));
                        bhote = false;
                    }
                    if (blogements) {
                        System.out.println("Logements: " + new String(ch, start, length));
                        blogements = false;
                    }
                    if (bappartements) {
                        System.out.println("Appartements: " + new String(ch, start, length));
                        bappartements = false;
                    }
                    if (bmaisons) {
                        System.out.println("Maisons: " + new String(ch, start, length));
                        bmaisons = false;
                    }
                }
            };

            //parse le fichier xml
            saxParser.parse("logements.xml", handler);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        public static ArrayList<Logement> getLogements(){
//            return logements;
//        }
}

