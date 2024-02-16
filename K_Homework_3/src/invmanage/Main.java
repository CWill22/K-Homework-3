package invmanage;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Create a new StockManagerSingleton instance
		StockManagerSingleton stockManager = new StockManagerSingleton();
		
		// Initialize stock
		boolean initialized = stockManager.initializeStock();

		if (initialized) {
			// Add a new VinylRecordProduct to the stock
			stockManager.addItem(new VinylRecordProduct("The Dark Side of the Moon", 29.99, 1973, Genre.ROCK));

			// Update price of the product
			ArrayList<MediaProduct> productList = stockManager.getMediaProductBelowPrice(30);
			if (!productList.isEmpty()) {
				MediaProduct productToUpdate = productList.get(0);
				stockManager.updateItemPrice(productToUpdate, 25.99);
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
            		ArrayList<MediaProduct> allProducts = stockManager.getMediaProductBelowPrice(20);
            		stockManager.printListOfMediaProduct(allProducts);
            		
            
            		// Get lists of specific record types
            		ArrayList<VinylRecordProduct> vinylRecords = stockManager.getVinylRecordList(allProducts);
            		ArrayList<MediaProduct> records = new ArrayList<MediaProduct>();
            		records.addAll(vinylRecords);

            		ArrayList<CDRecordProduct> cdRecords = stockManager.getCDRecordsList(allProducts);
           		ArrayList<TapeRecordProduct> tapeRecords = stockManager.getTapeRecordList(allProducts);
            
            		// Print lists of specific record types
           		System.out.println("Vinyl Records:");
            		stockManager.printListOfMediaProduct(records);
            
            		System.out.println("CD Records:");
            		//stockManager.printListOfMediaProduct(cdRecords);
            
            		System.out.println("Tape Records:");
            		//stockManager.printListOfMediaProduct(tapeRecords);
        	} else {
            		System.out.println("Failed to initialize stock.");
        	}
	}
}
