package invmanage;
//  VinylRecordProduct class
class CDRecordProduct extends MediaProduct {
    // CDRecordProduct
    public CDRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
    }

    // Copy constructor
    public CDRecordProduct(CDRecordProduct product) {
        super(product.title, product.price, product.year, product.genre);
    }
}
