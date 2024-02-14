package invmanage;

// CDRecordProduct class
class CDRecordProduct extends MediaProduct {
    private String title;
    private double price;
    private int year;
    private Genre genre;

    public CDRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
    }

   // Copy constructor
    public CDRecordProduct(CDRecordProduct product) {
        super(product.title, product.price, product.year, product.genre);
    }
}
