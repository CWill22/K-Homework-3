package invmanage;
//  VinylRecordProduct class
class VinylRecordProduct extends MediaProduct {
    public VinylRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
    }

    // Copy constructor
    public VinylRecordProduct(VinylRecordProduct product) {
        super(product.title, product.price, product.year, product.genre);
    }
}
