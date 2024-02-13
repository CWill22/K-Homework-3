package invmanage;
//  VinylRecordProduct class
class VinylRecordProduct extends MediaProduct {
    public VinylRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
    }

    // Copy constructor
    public VinylRecordProduct(CDRecordProduct other) {
        super(other);
    }
}
