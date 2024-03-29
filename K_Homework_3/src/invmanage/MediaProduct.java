package invmanage;

public class MediaProduct {

// MediaProduct class
    protected String title;
    protected double price;
    protected int year;
    protected Genre genre;

    public MediaProduct(String title, double price, int year, Genre genre) {
	this.title = title;
	this.price = price;
	this.year = year;
	this.genre = genre;
    }

    // Copy constructor
    public MediaProduct(MediaProduct product) {
	this.title = product.title;
	this.price = product.price;
	this.year = product.year;
	this.genre = product.genre;
    }
	
   // Getters and setters
    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public int getYear() {
	return year;
    }

    public void setYear(int year) {
	this.year = year;
    }

    public Genre getGenre() {
	return genre;
    }

    public void setGenre(Genre genre) {
	this.genre = genre;
    }
    @Override
    public String toString(){
	return "MediaProduct{" + "title = " + title + 
			    ", price = " + price + 
			    ", year = " + year + 
			    ", genre = " + genre + '}';
    }
}