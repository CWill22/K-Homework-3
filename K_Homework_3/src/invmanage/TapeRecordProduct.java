package invmanage;
//  TapeRecordProduct class
class TapeRecordProduct extends MediaProduct {
    public TapeRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
    }

    // Copy constructor
    public TapeRecordProduct(CDRecordProduct product) {
        super(product.title, product.price, product.year, product.genre);
    }
}
