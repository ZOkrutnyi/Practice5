package main.java.com.delphi.app;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppendElements {
    public static List<CD> append(String filepath)
    {
        List<CD> cds = new ArrayList<>();
        try {
            File fXmlFile = new File(filepath);
            CD cd;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("CD");
            System.out.print("----------------------------"+System.lineSeparator());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                cd = new CD();
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    cd.setTitle(eElement.getElementsByTagName("TITLE").item(0).getTextContent());
                    cd.setArtist(eElement.getElementsByTagName("ARTIST").item(0).getTextContent());
                    cd.setCountry(eElement.getElementsByTagName("COUNTRY").item(0).getTextContent());
                    cd.setCompany(eElement.getElementsByTagName("COMPANY").item(0).getTextContent());
                    cd.setPrice(Float.parseFloat(eElement.getElementsByTagName("PRICE").item(0).getTextContent()));
                    cd.setYear(LocalDate.ofYearDay(Integer.parseInt(eElement.getElementsByTagName("YEAR").item(0).getTextContent()),21));
                    cds.add(cd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cds;
    }
}
