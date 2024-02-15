package invmanage;
//  VinylRecordProduct class
class VinylRecordProduct extends MediaProduct {
    // vinyl array 
    public VinylRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
    }

    // Copy constructor
    public VinylRecordProduct(CDRecordProduct product) {
        super(product.title, product.price, product.year, product.genre);
    }
}
