package invmanage;

// CDRecordProduct class
class CDRecordProduct extends MediaProduct {
    public CDRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
    }

   // Copy constructor
    public CDRecordProduct(CDRecordProduct product) {
        super(product.title, product.price, product.year, product.genre);
}
}
