/**
 * @author Tim Nätebus
 * @category Learning
 * 
 * Diese klasse stellt einfach nur einen Wissensfundus für I/O Streams bereit, damit man sich mit Streams von Strings beschäftigen kann. Es wird sich auf die Folien PII_09_IO_... bezogen.
 * 
 * Zuerst sei gesagt, Programme dienen zur Bearbeitung von Daten, Daten eines Programms werden dabei gelesen eingegeben, berechnet / Gefiltert / ausgewählt, ausgegeben und geschrieben.
 * 
 * I / O sagt nicht mehr als Input / Output, allgemeines Prinzip zur Verbindung von Daten-Quellen mit Daten-Zielen
 * 
 * Konkrete Unterklassen von `Stream` binden an die Zugriffsroutinen an echte ein- oder aus- gabegeräte wie beispielsweise an Dateien, strings oder kommunikationskanäle im netzwerk. Spezielle Klassen, die das Stream-Konzept in die Objektorientierte welt umsetzen.
 * 
 * Bei einer Verkettung von Streams, ist es möglich, mehrere Quellen zusammenzufassen und für den Aufrufer als einzigen Stream darzustellen.
 * 
 * Das Schachteln von Streams erlaubt die Konstruktion von Filtern die bei der EIn oder Ausgabe bestimmte Zusatzfunktionen übernehmen beispielsweise das Puffern von Zeichen, das Zählen von Zeilen oder die Interpretation binärer daten
 *  
 * Die verschiedenen Stream-Typen in Java lassen sich unterscheiden in "Write", "Read", "Data-Source"
 * 
 * Die Datentypen von Streams sind:
 *   - Byte-Daten: Stream
 *   - Zeichendaten: Reader/Writer
 * Dann gibt es Richtungen von Streams:
 *   - Eingabe: InputStream bzw. Reader
 *   - Ausgabe: OutputStream bzw. Writer
 * Funktionen eines Streams:
 *   - Basis-Streams zur vebrinudng mit unterschiedlichen Quellen
 *   - Filter-Streams zum formatabhängigen Umgang mit den Daten
 * 
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ArbeitenMitStrings {
    private static String name = "abc";
    private static int alter = 21;

    public static void main(String[] args) {
        String fileString = "output.txt";
        schreibenMitBufferedOutPutStream(fileString);
        lesenMitBufferedInputStream(fileString);

    }

    // Actually das einzig Klausurrelevante
    public static String writeAsToString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name: ").append( name);
        sb.append(", Alter: ").append( alter);
        return sb.toString();
    }


    public static void lesenMitBufferedInputStream(String fileString) {
        String inputText;
        StringBuffer strBuffer = new StringBuffer();

        try (FileInputStream fis = new FileInputStream(fileString)) {
            BufferedInputStream bis = new BufferedInputStream(fis);
            for(byte n: fis.readAllBytes()) {
                strBuffer.append((char) n);
            }
            inputText = strBuffer.toString();
            System.out.println(inputText);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void schreibenMitBufferedOutPutStream(String fileString) {
         String text = "Hallo Welt! \n"
            + "Dies ist ein Test für BufferedStream. \n"
            + "Zeile 3\n"
            + "Ende der Nachricht";

        try (FileOutputStream fos = new FileOutputStream(fileString)) {
            BufferedOutputStream bfo = new BufferedOutputStream(fos);
            bfo.write(text.getBytes());
            bfo.flush();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
