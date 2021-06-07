package main.java.com.delphi.app;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "cd_catalog.xml";
    public static void main(String[] args) {
        List<CD> cds = getXMLData(FILE_PATH);

//        for (CD c:cds) {
//            System.out.println(c);
//        }
    }

    public static List<CD> getXMLData(String filepath)
    {
        List<CD> cds = new ArrayList<>();
        CD cd = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try{
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(filepath));
            while (xmlEventReader.hasNext())
            {
                XMLEvent event = xmlEventReader.nextEvent();
                if(event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    System.out.println();
//                    switch (startElement.getName().getLocalPart()){
//                        case "CD": cd = new CD(); break;
//                        case "TITLE":
//                            event = xmlEventReader.nextEvent();
//                            cd.setTitle(event.asCharacters().getData());
//                            break;
//                            case "ARTIST":
//                            event = xmlEventReader.nextEvent();
//                            cd.setArtist(event.asCharacters().getData());
//                            break;
//                            case "COUNTRY":
//                            event = xmlEventReader.nextEvent();
//                            cd.setCountry(event.asCharacters().getData());
//                            break;
//                            case "COMPANY":
//                            event = xmlEventReader.nextEvent();
//                            cd.setCompany(event.asCharacters().getData());
//                            break;
//                            case "PRICE":
//                            event = xmlEventReader.nextEvent();
//                            cd.setPrice(Float.parseFloat(event.asCharacters().getData()));
//                            break;
//                            case "YEAR":
//                            event = xmlEventReader.nextEvent();
//                            cd.setYear(Integer.parseInt(event.asCharacters().getData()));
//                            break;
//                    }
                }
                if(event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("CD"))
                    {
//                        cds.add(cd);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return cds;
    }
}
