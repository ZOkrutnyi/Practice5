package main.java.com.delphi.app;

public class CD {
    private String title;
    private String artist;
    @Column(type = "Country")
    private String country;
    private String company;
    @Column(type = "price")
    private float price;
    private int year;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  "title=" + title +
                ", artist=" + artist +
                ", country=" + country +
                ", price=" + price +
                ", year=" + year;
    }
}
