package main.java.com.delphi.app;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "CATALOG")
public class CD  {
    @Column(name = "TITLE",order = 1,type = "String")
    private String title;
    @Column(name = "ARTIST",order = 2,type = "String")
    private String artist;
    @Column(name = "COUNTRY",order = 3,type = "String")
    private String country;
    @Column(name = "COMPANY",order = 4,type = "String")
    private String company;
    @Column(name = "PRICE",order = 5,type = "Money")
    private float price;
    @Column(name = "YEAR",order = 6,type = "LocalDate")
    private LocalDate year;



    public void setCompany(String company) {
        this.company = company;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public void setArtist(String artist) {
        this.artist = artist;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return title+","+artist+","+country+","+company+","+price+"$,"+year;
    }
}
