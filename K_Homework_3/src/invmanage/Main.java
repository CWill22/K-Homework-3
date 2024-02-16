package invmanage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a new StockManagerSingleton instance
		StockManagerSingleton stockManager = new StockManagerSingleton();

		boolean initialized = stockManager.initializeStock();

		if (initialized) {
			// Add a new VinylRecordProduct to the stock
			stockManager.initializeStock();
	   	 	
		        
			stockManager.addItem(new VinylRecordProduct("The Dark Side of the Moon", 29.99, 1973, Genre.ROCK));

			//Update price of the product
			ArrayList<MediaProduct> productList = stockManager.getMediaProductBelowPrice(30);
			if (!productList.isEmpty()) {
				MediaProduct productToUpdate = productList.get(0);
				stockManager.updateItemPrice(produceToUpdate, 25.99);
			}

			// Remove a product from stock
			stockManager.removeItem(new VinylRecordProduct("Vinyl Record", 19.99, 1999, Genre.ROCK));

			// Save stock
            		boolean saved = stockManager.saveStock();
           		 if (saved) {
                		System.out.println("Stock saved successfully.");
            		} else {
                		System.out.println("Failed to save stock.");
            		}

			// Print list of media products
            		ArrayList<MediaProduct> allProducts = stockManager.getMediaProductBelowPrice(Double.MAX_VALUE);
            		stockManager.printListOfMediaProduct(allProducts);
            
            		// Get lists of specific record types
            		ArrayList<VinylRecordProduct> vinylRecords = stockManager.getVinylRecordList(allProducts);
            		ArrayList<CDRecordProduct> cdRecords = stockManager.getCDRecordsList(allProducts);
           		 ArrayList<TapeRecordProduct> tapeRecords = stockManager.getTapeRecordList(allProducts);
            
            		// Print lists of specific record types
           		System.out.println("Vinyl Records:");
            		stockManager.printListOfMediaProduct(vinylRecords);
            
            		System.out.println("CD Records:");
            		stockManager.printListOfMediaProduct(cdRecords);
            
            		System.out.println("Tape Records:");
            		stockManager.printListOfMediaProduct(tapeRecords);
        	} else {
            		System.out.println("Failed to initialize stock.");
        	}
	}
}
