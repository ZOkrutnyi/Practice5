package main.java.com.delphi.app;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.StringJoiner;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return title+","+artist+","+country+","+company+","+price+"$,"+year;
    }
}
