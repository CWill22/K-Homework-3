package invmanage;

public class MediaProduct {
  // Genre enum
enum Genre {
    ROCK,
    POP,
    CLASSICAL,
    JAZZ
}

// MediaProduct class
class MediaProduct {
    protected String title;
    protected double price;
    protected int year;
    protected Genre genre;
  
  public class TapeRecordProduct extends MediaProduct{

	}

	public class CDRecordProduct extends MediaProduct {

	}

	public class VinylRecordProduct extends MediaProduct{

	}

}
